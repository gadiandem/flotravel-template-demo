package com.flocash.flotravel.demo.service.flocash;


import com.flocash.flotravel.demo.dto.common.AuthBasic;
import com.flocash.flotravel.demo.dto.flocash.OtpCache;
import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import com.flocash.flotravel.demo.dto.flocash.request.CardInfo;
import com.flocash.flotravel.demo.dto.flocash.request.Payer;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpCardOrder;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpRes;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpResponse;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.*;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;
import com.flocash.flotravel.demo.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Base64;

import static com.flocash.flotravel.demo.constant.Constant.*;
import static com.flocash.flotravel.demo.constant.FlocashConstant.*;

@Slf4j
@Service
public class FlocashVCNServiceImp implements FlocashVCNService {
    @Value("${payment.env}")
    private String paymentEnv;

    private FlocashBuildRequestService flocashBuildRequestService;
    private OtpCacheService otpCacheService;

    @Autowired
    public void setFlocashBuildRequestService(FlocashBuildRequestService flocashBuildRequestService) {
        this.flocashBuildRequestService = flocashBuildRequestService;
    }

    @Autowired
    public void setOtpCacheService(OtpCacheService otpCacheService) {
        this.otpCacheService = otpCacheService;
    }

    @Override
    public FlocashVCNRes requestVCN(VcnRequest vcnRequest) {
        AuthBasic authBasic = new AuthBasic();
//        String auth;
        String endpoint;
        String merchantAccount;
        if (LIVE_ENV.equalsIgnoreCase(paymentEnv)) {
            merchantAccount = FLOCASH_LIVE_MERCHANT_EMAIL;
            endpoint = REQUEST_VCN_LIVE_URL;
            authBasic.setUserName(API_USER_FLOCASH_LIVE);
            authBasic.setPassword(API_PASS_FLOCASH_LIVE);
        } else {
            merchantAccount = FLOCASH_SANDBOX_MERCHANT_EMAIL;
            endpoint = REQUEST_VCN_SANDBOX_URL;
            authBasic.setUserName(API_USER_FLOCASH_LIVE);
            authBasic.setPassword(API_PASS_FLOCASH_LIVE);
        }
        FlocashVCNReq request = buildFlocashVcnRequest(vcnRequest, merchantAccount);
        FlocashVCNRes response = flocashBuildRequestService.vcnRequest(endpoint, authBasic, request);
        return response;
    }

    @Override
    public OtpResponse updateOtp(String traceNumber, String otp) {
        AuthBasic authBasic = new AuthBasic();
        OtpResponse otpResponse = new OtpResponse();
        OtpCache otpCache = otpCacheService.getOtpCard(traceNumber);
        if (otpCache != null) {
            OtpRes otpRes = new OtpRes();
            otpRes.setCardOrder(otpCache.getCardOrder());
            otpResponse.setResult(otpRes);
            otpResponse.setCode("200");
            otpResponse.setMessage("Get Otp value from cache");
            return otpResponse;
        }
        if (otp == null) {
            throw new ApplicationException(BAD_REQUEST, "Missing otp value, Try again!", 400);
        }
        String data = "otp=" + otp;
        String endpoint;

        if (LIVE_ENV.equalsIgnoreCase(paymentEnv)) {
            authBasic.setUserName(API_USER_FLOCASH_LIVE);
            authBasic.setPassword(API_PASS_FLOCASH_LIVE);
            endpoint = REQUEST_VCN_LIVE_URL;
        } else {
            authBasic.setUserName(API_USER_FLOCASH_SANDBOX);
            authBasic.setPassword(API_PASSWORD_FLOCASH_SANDBOX);
            endpoint = REQUEST_VCN_SANDBOX_URL;
        }
        endpoint = endpoint + "/" + traceNumber;
        OtpResponse response = flocashBuildRequestService.updateOpt(endpoint, authBasic, otp);
        OtpRes res;
        if(response.getResult() != null){
            res = response.getResult();
        } else {
            throw new ApplicationException(response.getCode(), response.getMessage(), 500);
        }
        OtpCache card = new OtpCache();
        card.setId(traceNumber);
        card.setCardOrder(res.getCardOrder());
        OtpCache otpSave = otpCacheService.saveOtpCard(card);
        OtpRes otpRes = new OtpRes();
        otpRes.setCardOrder(otpSave.getCardOrder());
        otpResponse.setResult(otpRes);
        otpResponse.setCode("200");
        otpResponse.setMessage("Otp save success");
        return otpResponse;
    }

    @Override
    public PaymentInfo buildFlocashPaymentRequest(OtpCardOrder card, String email) {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setPrice(new BigDecimal(card.getAmount()));
        paymentInfo.setCurrency(card.getCurrency());
        paymentInfo.setName("VCN payment: " + card.getTraceNumber());
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCvv(card.getCard().getCvv());
        cardInfo.setExpireYear(card.getCard().getExpireYear());
        cardInfo.setExpireMonth(card.getCard().getExpireMonth());
        cardInfo.setCardHolder(card.getCard().getBillingAddress().getFullName());
        cardInfo.setCardNumber(card.getCard().getRealPan());
        paymentInfo.setCardInfo(cardInfo);
        Payer payer = new Payer();
        String fullName = card.getCard().getBillingAddress().getFullName();
        String[] arrOfStr = fullName.split(" ", 2);
        payer.setFirstName(arrOfStr[0]);
        payer.setLastName(arrOfStr[1]);
        payer.setCountry(card.getCard().getBillingAddress().getCountry());
//        payer.setEmail(email);
        payer.setEmail(email);
        payer.setMobile(card.getCard().getBillingAddress().getPhoneNo());
        paymentInfo.setPayer(payer);
        return paymentInfo;
    }

    @Override
    public FlocashVCNReq buildFlocashVcnRequest(VcnRequest vcnRequest, String merchantAccount) {
        FlocashVCNReq request = new FlocashVCNReq();
        VCNOrder order = new VCNOrder();
        order.setAmount(vcnRequest.getPrice().toString());
        order.setCurrency(vcnRequest.getCurrency());
        request.setOrder(order);
        VCNMerchant merchant = new VCNMerchant();

        merchant.setMerchantAccount(merchantAccount);
        request.setMerchant(merchant);
        VCNCardInfo cardInfo = new VCNCardInfo();
        cardInfo.setGenerateCard(vcnRequest.getMerchantPayment().isGenerateCard());
        request.setCardInfo(cardInfo);
        VCNAgent agent = new VCNAgent();
        agent.setAgentAccount(vcnRequest.getMerchantPayment().getVcnAgentAccount());
        String apiCredential = vcnRequest.getMerchantPayment().getApiAccount() + ":" + vcnRequest.getMerchantPayment().getApiPassword();
        String basicBase64formatAPICredential = Base64.getEncoder().encodeToString(apiCredential.getBytes());
        agent.setToken(basicBase64formatAPICredential);
        request.setVcnAgent(agent);
        return request;
    }
}

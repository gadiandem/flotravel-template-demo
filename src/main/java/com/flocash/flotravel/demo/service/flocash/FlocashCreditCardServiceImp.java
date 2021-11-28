package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.common.AuthBasic;
import com.flocash.flotravel.demo.dto.flocash.PaymentInfo;
import com.flocash.flotravel.demo.dto.flocash.RefundData;
import com.flocash.flotravel.demo.dto.flocash.refund.RefundFLocash;
import com.flocash.flotravel.demo.dto.flocash.request.CardInfo;
import com.flocash.flotravel.demo.dto.flocash.request.FlocashRequest;
import com.flocash.flotravel.demo.dto.flocash.request.Merchant;
import com.flocash.flotravel.demo.dto.flocash.request.PayOption;
import com.flocash.flotravel.demo.dto.flocash.response.FlocashCreateOrderRes;
import com.flocash.flotravel.demo.dto.flocash.response.Order;
import com.flocash.flotravel.demo.dto.flocash.response.ResultResponse;
import com.flocash.flotravel.demo.service.WebClientService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static com.flocash.flotravel.demo.constant.Constant.*;
import static com.flocash.flotravel.demo.constant.FlocashConstant.*;
import static com.flocash.flotravel.demo.constant.FlocashConstant.MERCHANT_FLOTRAVEL_SANDBOX;

@Service
@Slf4j
public class FlocashCreditCardServiceImp implements FlocashCreditCardService {
    @Value("${payment.env}")
    private String paymentEnv;
    private WebClientService webClientService;

    @Autowired
    public void setWebClientService(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @Override
    public FlocashCreateOrderRes paymentAndBooking(FlocashRequest data) {
        FlocashCreateOrderRes order = flocashPayment(data, paymentEnv);
        return order;
    }

    @Override
    public RefundFLocash refundFlocashProvider(RefundData refundData, String traceNumber) {
        AuthBasic authBasic = new AuthBasic();
        String endpoint;
        if (LIVE_ENV.equalsIgnoreCase(paymentEnv)) {
            authBasic.setUserName(API_USER_FLOCASH_LIVE);
            authBasic.setPassword(API_PASS_FLOCASH_LIVE);
            endpoint = CREATE_ORDER_LIVE_URL + "/" + traceNumber + "/refunds";
        } else {
            authBasic.setUserName(API_USER_FLOCASH_SANDBOX);
            authBasic.setPassword(API_PASSWORD_FLOCASH_SANDBOX);
            endpoint = CREATE_ORDER_SANDBOX_URL + "/" + traceNumber + "/refunds";
        }
        log.info("Refund Endpoint: " + endpoint);
        log.info("Refund Auth: " + authBasic);
        ResultResponse res = webClientService.requestAuthBasic(endpoint, authBasic)
                .post()
                .body(BodyInserters.fromFormData("amount", String.valueOf(refundData.getAmount()))
                        .with("currency", refundData.getCurrency())
                        .with("statement", refundData.getStatement()))
                .retrieve()
                .bodyToMono(ResultResponse.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("RefundFlocash res: " + listResult);
        RefundFLocash refundFLocash = new RefundFLocash();
        if (res != null) {
            refundFLocash.setResult(res.getOrder());
            refundFLocash.setCode(SUCCESS_CODE);
            refundFLocash.setMessage(GET_OPTIONAL_SUCCESS);
        } else {
            refundFLocash.setResult(null);
            refundFLocash.setCode(NO_RESULT_CODE);
            refundFLocash.setMessage(NO_RESULT_MASSAGE);
        }
        return refundFLocash;
    }

    private FlocashCreateOrderRes flocashPayment(FlocashRequest data, String env) {
        AuthBasic authBasic = new AuthBasic();
        String endpoint;
        if (LIVE_ENV.equalsIgnoreCase(env)) {
            authBasic.setUserName(API_USER_FLOCASH_LIVE);
            authBasic.setPassword(API_PASS_FLOCASH_LIVE);
            endpoint = CREATE_ORDER_LIVE_URL;
        } else {
            authBasic.setUserName(API_USER_FLOCASH_SANDBOX);
            authBasic.setPassword(API_PASSWORD_FLOCASH_SANDBOX);
            endpoint = CREATE_ORDER_SANDBOX_URL;
        }
        ResultResponse res = webClientService.requestAuthBasic(endpoint, authBasic)
                .post()
                .body(Mono.just(data), FlocashRequest.class)
                .retrieve()
                .bodyToMono(ResultResponse.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("FlocashCreateOrder res: " + listResult);
        FlocashCreateOrderRes refundFLocash = new FlocashCreateOrderRes();
        if (res != null) {
            refundFLocash.setResult(res.getOrder());
            refundFLocash.setCode(SUCCESS_CODE);
            refundFLocash.setMessage(GET_OPTIONAL_SUCCESS);
        } else {
            refundFLocash.setResult(null);
            refundFLocash.setCode(NO_RESULT_CODE);
            refundFLocash.setMessage(NO_RESULT_MASSAGE);
        }
        return refundFLocash;
    }


    public FlocashRequest buildFlocashPaymentRequest(PaymentInfo paymentInfo, String merchantValue) {
        FlocashRequest flocashRequest = new FlocashRequest();
        // build order
        com.flocash.flotravel.demo.dto.flocash.request.Order order = new com.flocash.flotravel.demo.dto.flocash.request.Order();
        order.setAmount(paymentInfo.getPrice());
        order.setQuantity(1);
        order.setItem_price(paymentInfo.getPrice());
        if (paymentInfo.getCurrency() == null) {
            order.setCurrency(CURRENCY_DEFAULT);
        } else {
            order.setCurrency(paymentInfo.getCurrency());
        }
        order.setOrderId(FLOCASH_OPTN);
        order.setItem_name(paymentInfo.getName());
        flocashRequest.setOrder(order);
        // build merchant
        Merchant merchant = new Merchant();
        if (merchantValue != null && !merchantValue.isEmpty()) {
            merchant.setMerchantAccount(merchantValue);
        } else {
            merchant.setMerchantAccount(MERCHANT_FLOTRAVEL_SANDBOX);
        }
        flocashRequest.setMerchant(merchant);
        // build payer
        flocashRequest.setPayer(paymentInfo.getPayer());
        // build payerOption
        PayOption payOption = new PayOption();
        payOption.setId(FLOCASH_OPTN);
        flocashRequest.setPayOption(payOption);
        // build cardInfo
        CardInfo cardInfo = new CardInfo();
        cardInfo.setCardHolder(paymentInfo.getCardInfo().getCardHolder());
        cardInfo.setCardNumber(paymentInfo.getCardInfo().getCardNumber());
        cardInfo.setExpireMonth(paymentInfo.getCardInfo().getExpireMonth());
        cardInfo.setExpireYear(paymentInfo.getCardInfo().getExpireYear());
        cardInfo.setCvv(paymentInfo.getCardInfo().getCvv());
        flocashRequest.setCardInfo(cardInfo);
        return flocashRequest;
    }

}

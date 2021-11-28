package com.flocash.flotravel.demo;

import com.flocash.flotravel.demo.dto.common.MerchantPayment;
import com.flocash.flotravel.demo.dto.flocash.RefundData;
import com.flocash.flotravel.demo.dto.flocash.refund.RefundFLocash;
import com.flocash.flotravel.demo.dto.flocash.request.FlocashRequest;
import com.flocash.flotravel.demo.dto.flocash.response.FlocashCreateOrderRes;
import com.flocash.flotravel.demo.dto.flocash.vcn.otp.OtpResponse;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.VcnRequest;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCN;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;
import com.flocash.flotravel.demo.service.flocash.FlocashCreditCardService;
import com.flocash.flotravel.demo.service.flocash.FlocashVCNService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static com.flocash.flotravel.demo.constant.Constant.SUCCESS_CODE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class FlocashRequestVcnServiceTests {

	private FlocashVCNService flocashVCNService;

	@Autowired
	public void setFlocashVCNService(FlocashVCNService flocashVCNService) {
		this.flocashVCNService = flocashVCNService;
	}
	@Test
	void contextLoads() {
	}

	@Test
	void testVcnRequest() {
		VcnRequest vcnRequest = new VcnRequest();
		vcnRequest.setCurrency("USD");
		vcnRequest.setPrice(new BigDecimal("1"));
		MerchantPayment merchantPayment = new MerchantPayment();
		merchantPayment.setGenerateCard(true);
		merchantPayment.setApiAccount("Agent71");
		merchantPayment.setApiPassword("Agent71");
		merchantPayment.setVcnAgentAccount("agent71@mobirr.com");
		vcnRequest.setMerchantPayment(merchantPayment);
		FlocashVCNRes flocashVCN = flocashVCNService.requestVCN(vcnRequest);
		assertThat(flocashVCN.getCode()).isEqualTo(SUCCESS_CODE);
	}

	@Test
	void testUpdateOtp() {
		RefundData refundData = new RefundData();
		refundData.setCurrency("USD");
		refundData.setStatement("test");
		refundData.setAmount(new BigDecimal("1"));
		OtpResponse updateOtp = flocashVCNService.updateOtp("VC90958813273446", "000000");
		assertThat(updateOtp.getCode()).isEqualTo(SUCCESS_CODE);
	}

}

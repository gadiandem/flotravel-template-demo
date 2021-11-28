package com.flocash.flotravel.demo;

import com.flocash.flotravel.demo.dto.flocash.RefundData;
import com.flocash.flotravel.demo.dto.flocash.refund.RefundFLocash;
import com.flocash.flotravel.demo.dto.flocash.request.FlocashRequest;
import com.flocash.flotravel.demo.dto.flocash.response.FlocashCreateOrderRes;
import com.flocash.flotravel.demo.dto.search.destination.DestinationRes;
import com.flocash.flotravel.demo.service.flocash.FlocashCreditCardService;
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
class FlocashCreditCardServiceTests {

	private FlocashCreditCardService flocashCreditCardService;

	@Autowired
	public void setFlocashCreditCardService(FlocashCreditCardService flocashCreditCardService) {
		this.flocashCreditCardService = flocashCreditCardService;
	}
	@Test
	void contextLoads() {
	}

	@Test
	void testFlocashCreateOrder() {
		Gson gson = new Gson();
		String data = "{\n" +
				"    \"order\": {\n" +
				"        \"amount\": 4.08,\n" +
				"        \"orderId\": \"123\",\n" +
				"        \"item_name\": \"VCN payment: VC90910164792187\",\n" +
				"        \"item_price\": 4.08,\n" +
				"        \"quantity\": 1,\n" +
				"        \"currency\": \"USD\"\n" +
				"    },\n" +
				"    \"merchant\": {\n" +
				"        \"merchantAccount\": \"flotravel@mobirr.com\"\n" +
				"    },\n" +
				"    \"payer\": {\n" +
				"        \"country\": \"GB\",\n" +
				"        \"firstName\": \"Agent\",\n" +
				"        \"lastName\": \"1\",\n" +
				"        \"mobile\": \"+237693945123\",\n" +
				"        \"email\": \"gadiandem19.tl@gmail.com\"\n" +
				"    },\n" +
				"    \"payOption\": {\n" +
				"        \"id\": \"123\"\n" +
				"    },\n" +
				"    \"cardInfo\": {\n" +
				"        \"cardHolder\": \"Agent 1\",\n" +
				"        \"cardNumber\": \"9900990075711196\",\n" +
				"        \"expireMonth\": \"10\",\n" +
				"        \"expireYear\": \"23\",\n" +
				"        \"cvv\": \"630\"\n" +
				"    }\n" +
				"}";
		FlocashRequest flocashRequest = gson.fromJson(data, FlocashRequest.class);
		FlocashCreateOrderRes destinationRes = flocashCreditCardService.paymentAndBooking(flocashRequest);
		assertThat(destinationRes.getCode()).isEqualTo(SUCCESS_CODE);
	}

	@Test
	void testFlocashRefundOrder() {
		RefundData refundData = new RefundData();
		refundData.setCurrency("USD");
		refundData.setStatement("test");
		refundData.setAmount(new BigDecimal("4.08"));
		RefundFLocash destinationRes = flocashCreditCardService.refundFlocashProvider(refundData, "T90959378492971");
		assertThat(destinationRes.getCode()).isEqualTo(SUCCESS_CODE);
	}

}

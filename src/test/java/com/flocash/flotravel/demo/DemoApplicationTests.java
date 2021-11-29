package com.flocash.flotravel.demo;

import com.flocash.flotravel.demo.dto.flocash.RefundParameter;
import com.flocash.flotravel.demo.dto.flocash.vcn.request.VcnRequest;
import com.flocash.flotravel.demo.dto.flocash.vcn.response.FlocashVCNRes;
import com.flocash.flotravel.demo.dto.packages.*;
import com.flocash.flotravel.demo.dto.search.destination.DestinationRes;
import com.flocash.flotravel.demo.service.FlotravelDemoService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.flocash.flotravel.demo.constant.Constant.SUCCESS_CODE;
import static com.flocash.flotravel.demo.constant.FlotravelConstant.ACCOUNT_ID;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    private FlotravelDemoService flotravelDemoService;
    private String accountId = ACCOUNT_ID;

    @Autowired
    public void setFlotravelDemoService(FlotravelDemoService flotravelDemoService) {
        this.flotravelDemoService = flotravelDemoService;
    }
    @Test
    void contextLoads() {
    }

    @Test
    void testDestinationSearch() {
        String keyword = "new";
        DestinationRes destinationRes = flotravelDemoService.destinationSearch(keyword);
        assertThat(destinationRes.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testDestinationElasticSearch() {
        String keyword = "dubai";
        DestinationRes destinationRes = flotravelDemoService.destinationElasticSearch(keyword);
        assertThat(destinationRes.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void shoppingPackages() {
        PackageShoppingReq packageShoppingReq = new PackageShoppingReq();
        packageShoppingReq.setDate(LocalDate.of(2021, 12, 3));
        packageShoppingReq.setMinDay(1);
        packageShoppingReq.setMaxDay(7);
        packageShoppingReq.setCityCode("6053839");
        PackageShoppingRes packageShoppingRes = flotravelDemoService.shoppingPackage(packageShoppingReq);
        assertThat(packageShoppingRes.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testGetPackageHotelDetail() {
        String hotelId = "60fe4877b6ee7c668d8b1589";
        HotelRoomDetailReq req = new HotelRoomDetailReq();
        req.setHotelId(hotelId);
        HotelRoomDetailRes packageShoppingRes = flotravelDemoService.getPackageHotelDetail(req);
        assertThat(packageShoppingRes.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testGetOptionList() {
        String packageId = "60fe4e35deac2115c5b2cb8f";
        OptionalReq req = new OptionalReq();
        req.setPackageId(packageId);
        OptionalRes optionalList = flotravelDemoService.getOptionalList(req);
        assertThat(optionalList.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testSummaryPrice() {
        String data = "{\n" +
                "  \"packageInfo\": {\n" +
                "    \"id\": \"61041ed5d57e25360762078e\",\n" +
                "    \"count\": 1\n" +
                "  },\n" +
                "  \"hotelId\": \"6135cb00fa0de50d9f719da3\",\n" +
                "  \"hotelRooms\": [\n" +
                "    {\n" +
                "      \"id\": \"61360912fa0de50d9f719e4f\",\n" +
                "      \"count\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"startDate\": \"2021-11-25\",\n" +
                "  \"supplements\": [\n" +
                "    {\n" +
                "      \"id\": \"6103f0a5d57e253607620789\",\n" +
                "      \"count\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Gson gson = new Gson();
        SummaryPackageReq req = gson.fromJson(data, SummaryPackageReq.class);
        SummaryPackageRes summary = flotravelDemoService.getSummary(req);
		assertThat(summary.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testRequestVcn() {
        String data = "{\n" +
                "    \"accountId\": \"60379f09c860bf795b44c394\",\n" +
                "    \"currency\": \"USD\",\n" +
                "    \"price\": 165,\n" +
                "    \"merchantPayment\": {\n" +
                "        \"generateCard\": true,\n" +
                "        \"vcnAgentAccount\": \"flotraveltester@gmail.com\",\n" +
                "        \"apiAccount\": \"PeY83tTg\",\n" +
                "        \"apiPassword\": \"Testpass@1234\"\n" +
                "    }\n" +
                "}";
        Gson gson = new Gson();
        VcnRequest req = gson.fromJson(data, VcnRequest.class);
        FlocashVCNRes requestVcn = flotravelDemoService.requestVcn(req);
		assertThat(requestVcn.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testCreatePackageOrder() {
        String data = "{\n" +
                "    \"paymentInfo\": {\n" +
                "        \"vcnPayment\": true,\n" +
                "        \"traceNumber\": \"VC17927423980693\",\n" +
                "        \"otpValue\": \"003157\",\n" +
                "        \"currency\": \"USD\",\n" +
                "        \"price\": 165,\n" +
                "        \"payer\": {\n" +
                "            \"country\": \"ET\",\n" +
                "            \"firstName\": \"huy\",\n" +
                "            \"lastName\": \"nguyen\",\n" +
                "            \"mobile\": \"0358964922\",\n" +
                "            \"email\": \"gadiandem19.tl@gmail.com\"\n" +
                "        },\n" +
                "        \"name\": \"Fortune Hotel Karama or Similar - 4D3N \"\n" +
                "    },\n" +
                "    \"accountBooking\": \"60379f09c860bf795b44c394\",\n" +
                "    \"bookingForUser\": false,\n" +
                "    \"userIsBooking\": \"60379f09c860bf795b44c394\",\n" +
                "    \"customerBookingInfos\": [\n" +
                "        {\n" +
                "            \"gender\": \"MALE\",\n" +
                "            \"firstName\": \"huy\",\n" +
                "            \"middleName\": \"van\",\n" +
                "            \"lastName\": \"nguyen\",\n" +
                "            \"country\": \"ET\",\n" +
                "            \"mobile\": \"0358964922\",\n" +
                "            \"isNotify\": true,\n" +
                "            \"passport\": \"123456789\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"bookingContact\": {\n" +
                "        \"email\": \"gadiandem19.tl@gmail.com\",\n" +
                "        \"createAccount\": false,\n" +
                "        \"password\": \"\"\n" +
                "    },\n" +
                "    \"packagesBookingInfo\": {\n" +
                "        \"summaryId\": \"61a3d465e944c545bd5cd6b1\"\n" +
                "    }\n" +
                "}";
        Gson gson = new Gson();
        OrderPackageReq req = gson.fromJson(data, OrderPackageReq.class);
        CreateOrderPackageRes createOrderPackageRes = flotravelDemoService.createOrder(req);
		assertThat(createOrderPackageRes.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testCancelPackageOrder() {
        String data = "{\n" +
                "    \"id\": \"61a3da67e944c545bd5cd6b5\",\n" +
                "    \"statement\": \"test\"\n" +
                "}";
        Gson gson = new Gson();
        RefundParameter req = gson.fromJson(data, RefundParameter.class);
        CancelOrderPackageRes cancelOrderPackageRes = flotravelDemoService.cancelBooking(req);
		assertThat(cancelOrderPackageRes.getCode()).isEqualTo(SUCCESS_CODE);
//        assertThat(cancelOrderPackageRes).isNotNull();
    }

    @Test
    void testGetBookingHistory() {
        HistoryOrderPackageListReq req = new HistoryOrderPackageListReq();
        req.setUserId(accountId);
        HistoryOrderPackageListRes bookingHistoryList = flotravelDemoService.getBookingHistoryList(req);
        assertThat(bookingHistoryList.getCode()).isEqualTo(SUCCESS_CODE);
    }

    @Test
    void testGetBookingHistoryDetail() {
        HistoryOrderPackageDetailReq req = new HistoryOrderPackageDetailReq();
        req.setPackageOrderId("61a3d4c0e944c545bd5cd6b2");
        HistoryOrderPackageDetailRes bookingHistoryDetail = flotravelDemoService.getBookingHistoryDetail(req);
        assertThat(bookingHistoryDetail.getCode()).isEqualTo(SUCCESS_CODE);
    }
}

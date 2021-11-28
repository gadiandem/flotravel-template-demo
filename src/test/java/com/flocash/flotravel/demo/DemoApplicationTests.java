package com.flocash.flotravel.demo;

import com.flocash.flotravel.demo.dto.packages.*;
import com.flocash.flotravel.demo.dto.search.destination.DestinationRes;
import com.flocash.flotravel.demo.service.FlotravelDemoService;
import com.flocash.flotravel.demo.service.WebClientService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

import static com.flocash.flotravel.demo.constant.Constant.SUCCESS_CODE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	private FlotravelDemoService flotravelDemoService;
	private WebClientService webclientService;

	@Autowired
	public void setFlotravelDemoService(FlotravelDemoService flotravelDemoService) {
		this.flotravelDemoService = flotravelDemoService;
	}
	@Autowired
	public void setWebclientService(WebClientService webclientService) {
		this.webclientService = webclientService;
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
        SummaryPackageRes optionalList = flotravelDemoService.getSummary(req);
//		assertThat(optionalList.getCode()).isEqualTo(SUCCESS_CODE);
		assertThat(optionalList).isNotNull();
	}
}

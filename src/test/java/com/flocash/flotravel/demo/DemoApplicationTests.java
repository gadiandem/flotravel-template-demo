package com.flocash.flotravel.demo;

import com.flocash.flotravel.demo.dto.packages.*;
import com.flocash.flotravel.demo.dto.search.destination.DestinationRes;
import com.flocash.flotravel.demo.service.FlotravelDemoService;
import com.flocash.flotravel.demo.service.WebClientService;
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
		String keyword = "new york";
		DestinationRes destinationRes = flotravelDemoService.destinationElasticSearch(keyword);
		assertThat(destinationRes.getCode()).isEqualTo(SUCCESS_CODE);
	}
	@Test
	void shoppingPackages() {
		PackageShoppingReq packageShoppingReq = new PackageShoppingReq();
		packageShoppingReq.setDate(LocalDate.of(2021, 11, 25));
		packageShoppingReq.setMinDay(7);
		packageShoppingReq.setMaxDay(1);
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
}

package com.flocash.flotravel.demo;

import com.flocash.flotravel.demo.dto.common.packages.consumer.HotelRoomDetailReq;
import com.flocash.flotravel.demo.dto.common.packages.consumer.HotelRoomDetailRes;
import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingReq;
import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingRes;
import com.flocash.flotravel.demo.service.FlotravelDemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	private FlotravelDemoService flotravelDemoService;

	@Autowired
	public void setFlotravelDemoService(FlotravelDemoService flotravelDemoService) {
		this.flotravelDemoService = flotravelDemoService;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void shoppingPackages() {
		PackageShoppingReq packageShoppingReq = new PackageShoppingReq();
		packageShoppingReq.setDate(LocalDate.of(2021, 11, 25));
		packageShoppingReq.setMinDay(7);
		packageShoppingReq.setMaxDay(1);
		packageShoppingReq.setCityCode("6053839");
		PackageShoppingRes packageShoppingRes = flotravelDemoService.shoppingPackage(packageShoppingReq);
		assertThat(packageShoppingRes.getCode()).isEqualTo("200");
	}

	@Test
	void testGetPackageHotelDetail() {
		String hotelId = "60fe4877b6ee7c668d8b1589";
		HotelRoomDetailReq req = new HotelRoomDetailReq();
		req.setHotelId(hotelId);
		HotelRoomDetailRes packageShoppingRes = flotravelDemoService.getPackageHotelDetail(req);
		assertThat(packageShoppingRes.getCode()).isEqualTo("200");
	}
}

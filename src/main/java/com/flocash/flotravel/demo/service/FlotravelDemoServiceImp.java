package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.packages.*;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

import static com.flocash.flotravel.demo.constant.Constant.*;
import static com.flocash.flotravel.demo.constant.FlotravelConstant.*;

@Service
@Slf4j
public class FlotravelDemoServiceImp implements FlotravelDemoService {
    @Value("${env}")
    private String env;
    private String domainUrl;
    private WebclientService webclientService;

    @Autowired
    public void setWebclientService(WebclientService webclientService) {
        this.webclientService = webclientService;
    }

    @PostConstruct
    public void selectDomainUrl() {
        if (LIVE_ENV.equalsIgnoreCase(env)) {
            domainUrl = FLOTRAVEL_LIVE_DOMAIN;
        } else {
            domainUrl = FLOTRAVEL_TEST_DOMAIN;
        }
    }

    @Override
    public PackageShoppingRes shoppingPackage(PackageShoppingReq req) {
        List<PackageShoppingItem> res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_SHOPPING_URL)
                .post()
                .body(Mono.just(req), PackageShoppingReq.class)
                .retrieve()
                .bodyToFlux(PackageShoppingItem.class)
                .collectList().block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res.size());
        log.info("Shopping Package: " + listResult + " item");
        PackageShoppingRes packageShoppingRes = new PackageShoppingRes();
        if(res.size() > 0){
            packageShoppingRes.setResult(res);
            packageShoppingRes.setCode(SUCCESS_CODE);
            packageShoppingRes.setMessage(SHOPPING_PACKAGE_SUCCESS);
        } else {
            packageShoppingRes.setResult(Collections.emptyList());
            packageShoppingRes.setResult(res);
            packageShoppingRes.setCode(NO_RESULT_CODE);
            packageShoppingRes.setMessage(NO_RESULT_MASSAGE);
        }
        return packageShoppingRes;
    }

    @Override
    public HotelRoomDetailRes getPackageHotelDetail(HotelRoomDetailReq req) {
        List<HotelRoomDetailItem> res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_HOTEL_ROOM_URL)
                .post()
                .body(Mono.just(req), PackageShoppingReq.class)
                .retrieve()
                .bodyToFlux(HotelRoomDetailItem.class)
                .collectList().block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res.size());
        log.info("Shopping Package: " + listResult + " item");
        HotelRoomDetailRes hotelRoomDetailRes = new HotelRoomDetailRes();
        if(res.size() > 0){
            hotelRoomDetailRes.setResult(res);
            hotelRoomDetailRes.setCode(SUCCESS_CODE);
            hotelRoomDetailRes.setMessage(SHOPPING_PACKAGE_SUCCESS);
        } else {
            hotelRoomDetailRes.setResult(Collections.emptyList());
            hotelRoomDetailRes.setResult(res);
            hotelRoomDetailRes.setCode(NO_RESULT_CODE);
            hotelRoomDetailRes.setMessage(NO_RESULT_MASSAGE);
        }
        return hotelRoomDetailRes;
    }

    @Override
    public OptionalRes getOptionalList(OptionalReq req) {
        OptionalList res = webclientService.retRequestWithEndpoint(domainUrl + PACKAGE_OPTIONAL_URL)
                .post()
                .body(Mono.just(req), PackageShoppingReq.class)
                .retrieve()
                .bodyToMono(OptionalList.class)
                .block();
        Gson gson = new Gson();
        String listResult = gson.toJson(res);
        log.info("Optional res: " + listResult);
        OptionalRes optionalRes = new OptionalRes();
        if(res != null){
            optionalRes.setResult(res);
            optionalRes.setCode(SUCCESS_CODE);
            optionalRes.setMessage(SHOPPING_PACKAGE_SUCCESS);
        } else {
            optionalRes.setResult(null);
            optionalRes.setCode(NO_RESULT_CODE);
            optionalRes.setMessage(NO_RESULT_MASSAGE);
        }
        return optionalRes;
    }

    @Override
    public SummaryPackageRes getSummary(SummaryPackageReq req) {
        return null;
    }
}

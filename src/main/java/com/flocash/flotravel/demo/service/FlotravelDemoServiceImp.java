package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingReq;
import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingItem;
import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingRes;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static com.flocash.flotravel.demo.constant.Constant.*;
import static com.flocash.flotravel.demo.constant.FlotravelConstant.*;

@Service
@Slf4j
public class FlotravelDemoServiceImp implements FlotravelDemoService {
    private WebclientService webclientService;

    @Autowired
    public void setWebclientService(WebclientService webclientService) {
        this.webclientService = webclientService;
    }


    @Override
    public PackageShoppingRes shoppingPackage(PackageShoppingReq req) {
        List<PackageShoppingItem> res = webclientService.retRequestWithEndpoint(FLOTRAVEL_LIVE_DOMAIN + PACKAGE_SHOPPING_URL)
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
}

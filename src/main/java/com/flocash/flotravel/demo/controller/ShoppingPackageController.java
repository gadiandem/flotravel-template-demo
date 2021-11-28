package com.flocash.flotravel.demo.controller;

import com.flocash.flotravel.demo.dto.packages.PackageShoppingReq;
import com.flocash.flotravel.demo.dto.packages.PackageShoppingRes;
import com.flocash.flotravel.demo.service.FlotravelDemoService;
import com.flocash.flotravel.demo.util.RequestHeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/packages/shopping")
public class ShoppingPackageController {
    private FlotravelDemoService flotravelDemoService;

    @Autowired
    public void setFlotravelDemoService(FlotravelDemoService flotravelDemoService) {
        this.flotravelDemoService = flotravelDemoService;
    }

    @PostMapping()
    public Mono<PackageShoppingRes> shoppingPackage(@RequestBody PackageShoppingReq packageShoppingReq, @RequestHeader Map<String, String> headers) {
//        String packageType = RequestHeaderUtil.getPackageTypeHeader(headers);
        PackageShoppingRes shoppingRes = flotravelDemoService.shoppingPackage(packageShoppingReq);
        return Mono.just(shoppingRes);
    }

}

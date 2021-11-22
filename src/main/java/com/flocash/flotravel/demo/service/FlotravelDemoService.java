package com.flocash.flotravel.demo.service;


import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingReq;
import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingItem;
import com.flocash.flotravel.demo.dto.common.packages.consumer.PackageShoppingRes;

import java.util.List;

public interface FlotravelDemoService {
    PackageShoppingRes shoppingPackage(PackageShoppingReq req);

}

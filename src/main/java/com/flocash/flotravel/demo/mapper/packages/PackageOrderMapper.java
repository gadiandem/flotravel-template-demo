package com.flocash.flotravel.demo.mapper.packages;

import com.flocash.flotravel.demo.dto.flocash.response.Order;
import com.flocash.flotravel.demo.dto.packages.provider.PackageOrder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PackageOrderMapper {

    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private PackageOrder mapPackageOrder(Order flocashOrder){
        PackageOrder packageOrder = modelMapper.map(flocashOrder, PackageOrder.class);
        return packageOrder;
    }
}

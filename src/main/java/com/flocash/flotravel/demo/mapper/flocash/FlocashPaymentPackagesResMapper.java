package com.flocash.flotravel.demo.mapper.flocash;

import com.flocash.flotravel.demo.dto.flocash.response.Order;
import com.flocash.flotravel.demo.dto.packages.provider.PackageOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
@Slf4j
public class FlocashPaymentPackagesResMapper {
    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PackageOrder mapFlocashPaymentPackages(Order order){
//        PackageOrder flocashPaymentExtra = new PackageOrder();
//        try {
//            BeanUtils.copyProperties(flocashPaymentExtra, order);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            log.error(e.getMessage());
//        }
//        return flocashPaymentExtra;
        PackageOrder packageOrder = modelMapper.map(order, PackageOrder.class);
        return packageOrder;
    }
}

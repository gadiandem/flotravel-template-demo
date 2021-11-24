package com.flocash.flotravel.demo.mapper.packages;

import com.flocash.flotravel.demo.dto.packages.SummaryPackageRes;
import com.flocash.flotravel.demo.dto.packages.provider.SummaryPackageCache;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class SummaryPackageMapper {
    public SummaryPackageCache mapToSummaryPackageDomain(SummaryPackageRes summary){
        SummaryPackageCache orderPackageRes = new SummaryPackageCache();
        try {
            BeanUtils.copyProperties(orderPackageRes, summary);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return orderPackageRes;
    }
    public SummaryPackageRes mapToSummaryPackageDTO(SummaryPackageCache summary){
        SummaryPackageRes orderPackageRes = new SummaryPackageRes();
        try {
            BeanUtils.copyProperties(orderPackageRes, summary);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return orderPackageRes;
    }
}

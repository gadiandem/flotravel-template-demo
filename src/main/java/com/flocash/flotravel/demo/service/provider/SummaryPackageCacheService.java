package com.flocash.flotravel.demo.service.provider;

import com.flocash.flotravel.demo.dto.packages.provider.SummaryPackageCache;
import com.flocash.flotravel.demo.exception.ApplicationException;
import com.flocash.flotravel.demo.repository.SummaryPackageCacheRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.flocash.flotravel.demo.constant.Constant.BAD_REQUEST;

@Service
@Slf4j
public class SummaryPackageCacheService {
    private SummaryPackageCacheRepository summaryPackageCacheRepository;

    @Autowired
    public void setSummaryPackageCacheRepository(SummaryPackageCacheRepository summaryPackageCacheRepository) {
        this.summaryPackageCacheRepository = summaryPackageCacheRepository;
    }

    public SummaryPackageCache addSummaryPackage(SummaryPackageCache summaryPackage) {
        return summaryPackageCacheRepository.insert(summaryPackage).block();
    }

    public SummaryPackageCache updateSummaryPackage(SummaryPackageCache summaryPackage, String summaryId) {
        SummaryPackageCache hotelPackageExist = summaryPackageCacheRepository.findById(summaryId).block();
//        if (hotelPackageExist == null) {
//            throw new ApplicationException(APP_ERROR_CODE, "hotel package with id: " + summaryId + " not exist", 400);
//        }
        summaryPackage.setId(summaryId);
        return summaryPackageCacheRepository.save(summaryPackage).block();
    }

    public SummaryPackageCache getSummaryPackage(String summaryId) {
        SummaryPackageCache result = summaryPackageCacheRepository.findById(summaryId).block();
        if(result == null){
            throw new ApplicationException(BAD_REQUEST, "SummaryCache not Exist with this id: " + summaryId, 400);
        }
        return result;
    }

    public List<SummaryPackageCache> getSummaryPackageList() {
        return summaryPackageCacheRepository.findAll().collectList().block();
    }

    public Void deleteSummaryPackage(String summaryId) {
        SummaryPackageCache hotelPackageExist = summaryPackageCacheRepository.findById(summaryId).block();
        if (hotelPackageExist == null) {
            throw new ApplicationException(BAD_REQUEST, "summary package with id: " + summaryId + " not exist", 400);
        }
        return summaryPackageCacheRepository.deleteById(summaryId).block();
    }

}

package com.flocash.flotravel.demo.service.flocash;

import com.flocash.flotravel.demo.dto.flocash.OtpCache;
import com.flocash.flotravel.demo.repository.OtpCacheRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OtpCacheServiceImp implements OtpCacheService {
    private OtpCacheRepository otpCacheRepository;

    @Autowired
    public void setOtpCacheRepository(OtpCacheRepository otpCacheRepository) {
        this.otpCacheRepository = otpCacheRepository;
    }

    @Override
    public OtpCache saveOtpCard(OtpCache card) {
        OtpCache saveCard;
//        if(card.getId() != null){
            saveCard = otpCacheRepository.insert(card).block();
//        } else {
//            saveCard = otpCacheRepository.save(card).block();
//        }
        return saveCard;
    }

    @Override
    public OtpCache getOtpCard(String traceNumber) {
        return otpCacheRepository.findById(traceNumber).block();
    }


}

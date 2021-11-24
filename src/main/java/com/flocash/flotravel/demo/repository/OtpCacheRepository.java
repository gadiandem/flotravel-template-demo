package com.flocash.flotravel.demo.repository;

import com.flocash.flotravel.demo.dto.flocash.OtpCache;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OtpCacheRepository extends ReactiveMongoRepository<OtpCache, String> {
}

package com.flocash.flotravel.demo.repository;

import com.flocash.flotravel.demo.dto.packages.provider.SummaryPackageCache;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryPackageCacheRepository extends ReactiveMongoRepository<SummaryPackageCache, String> {

}

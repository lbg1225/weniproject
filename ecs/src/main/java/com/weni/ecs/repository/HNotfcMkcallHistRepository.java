package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.HNotfcMkcallHist;

@RepositoryRestResource(collectionResourceRel="hnotfcmkcallhists", path="hnotfcmkcallhists")
public interface HNotfcMkcallHistRepository extends PagingAndSortingRepository<HNotfcMkcallHist, Integer>{
}

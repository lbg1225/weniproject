package com.sample.repository;

import com.sample.domain.CommonCode;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "commoncodes", path = "commoncodes")
public interface CommonCodeRepository extends PagingAndSortingRepository<CommonCode, String>{ //Entity 클래스, PK 타입
 
}
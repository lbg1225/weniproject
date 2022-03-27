package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.HSmsMkcallInfo;

@RepositoryRestResource(collectionResourceRel="hsmsmkcallinfos", path="hsmsmkcallinfos")
public interface HSmsMkcallInfoRepository extends PagingAndSortingRepository<HSmsMkcallInfo, Integer>{
}

package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.HChangeHist;

@RepositoryRestResource(collectionResourceRel="hchangehists", path="hchangehists")
public interface HChangeHistRepository extends PagingAndSortingRepository<HChangeHist, Integer>{
}

package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.HNotfcRecvHist;

@RepositoryRestResource(collectionResourceRel="hnotfcrecvhists", path="hnotfcrecvhists")
public interface HNotfcRecvHistRepository extends PagingAndSortingRepository<HNotfcRecvHist, Integer>{
}

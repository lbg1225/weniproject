package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MUsrInfo;

@RepositoryRestResource(collectionResourceRel="musrinfos", path="musrinfos")
public interface MUsrInfoRepository extends PagingAndSortingRepository<MUsrInfo, String>{
}

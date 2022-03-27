package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MAddrInfo;

@RepositoryRestResource(collectionResourceRel="maddrinfos", path="maddrinfos")
public interface MAddrInfoRepository extends PagingAndSortingRepository<MAddrInfo, String>{
}

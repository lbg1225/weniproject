package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MMnuInfo;

@RepositoryRestResource(collectionResourceRel="mmnuinfos", path="mmnuinfos")
public interface MMnuInfoRepository extends PagingAndSortingRepository<MMnuInfo, String>{
}

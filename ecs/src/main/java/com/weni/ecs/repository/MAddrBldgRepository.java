package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MAddrBldg;

@RepositoryRestResource(collectionResourceRel="maddrbldgs", path="maddrbldgs")
public interface MAddrBldgRepository extends PagingAndSortingRepository<MAddrBldg, String>{
}

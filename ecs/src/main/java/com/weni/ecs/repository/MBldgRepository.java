package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MBldg;

@RepositoryRestResource(collectionResourceRel="mbldgs", path="mbldgs")
public interface MBldgRepository extends PagingAndSortingRepository<MBldg, String>{
}

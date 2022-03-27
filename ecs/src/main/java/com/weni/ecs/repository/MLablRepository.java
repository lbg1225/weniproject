package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MLabl;

@RepositoryRestResource(collectionResourceRel="mlabls", path="mlabls")
public interface MLablRepository extends PagingAndSortingRepository<MLabl, String>{
}

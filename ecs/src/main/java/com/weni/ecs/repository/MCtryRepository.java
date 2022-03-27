package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MCtry;

@RepositoryRestResource(collectionResourceRel="mctrys", path="mctrys")
public interface MCtryRepository extends PagingAndSortingRepository<MCtry, String>{
}

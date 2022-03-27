package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MDispFac;

@RepositoryRestResource(collectionResourceRel="mdispfacs", path="mdispfacs")
public interface MDispFacRepository extends PagingAndSortingRepository<MDispFac, Integer>{
}

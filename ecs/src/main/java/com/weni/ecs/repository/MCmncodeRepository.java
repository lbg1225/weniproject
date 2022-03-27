package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MCmncode;

@RepositoryRestResource(collectionResourceRel="mcmncodes", path="mcmncodes")
public interface MCmncodeRepository extends PagingAndSortingRepository<MCmncode, String>{
}

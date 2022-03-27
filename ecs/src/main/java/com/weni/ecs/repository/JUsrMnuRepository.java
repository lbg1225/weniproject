package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.JUsrMnu;

@RepositoryRestResource(collectionResourceRel="jusrmnus", path="jusrmnus")
public interface JUsrMnuRepository extends PagingAndSortingRepository<JUsrMnu, String>{
}

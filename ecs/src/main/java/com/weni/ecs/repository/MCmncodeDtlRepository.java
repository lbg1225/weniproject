package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MCmncodeDtl;

@RepositoryRestResource(collectionResourceRel="mcmncodedtls", path="mcmncodedtls")
public interface MCmncodeDtlRepository extends PagingAndSortingRepository<MCmncodeDtl, String>{
}

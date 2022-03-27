package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardPolDtl;

@RepositoryRestResource(collectionResourceRel="sincidcardpoldtls", path="sincidcardpoldtls")
public interface SIncidCardPolDtlRepository extends PagingAndSortingRepository<SIncidCardPolDtl, Integer>{
}

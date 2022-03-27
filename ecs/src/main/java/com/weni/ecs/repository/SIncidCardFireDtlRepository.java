package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardFireDtl;

@RepositoryRestResource(collectionResourceRel="sincidcardfiredtls", path="sincidcardfiredtls")
public interface SIncidCardFireDtlRepository extends PagingAndSortingRepository<SIncidCardFireDtl, Integer>{
}

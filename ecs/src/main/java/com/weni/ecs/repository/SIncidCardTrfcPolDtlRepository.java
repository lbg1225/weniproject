package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardTrfcPolDtl;

@RepositoryRestResource(collectionResourceRel="sincidcardtrfcpoldtls", path="sincidcardtrfcpoldtls")
public interface SIncidCardTrfcPolDtlRepository extends PagingAndSortingRepository<SIncidCardTrfcPolDtl, Integer>{
}

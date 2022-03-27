package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardTrfcPol;

@RepositoryRestResource(collectionResourceRel="sincidcardtrfcpols", path="sincidcardtrfcpols")
public interface SIncidCardTrfcPolRepository extends PagingAndSortingRepository<SIncidCardTrfcPol, Integer>{
}

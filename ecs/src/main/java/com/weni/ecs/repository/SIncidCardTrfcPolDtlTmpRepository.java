package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardTrfcPolDtlTmp;

@RepositoryRestResource(collectionResourceRel="sincidcardtrfcpoldtltmps", path="sincidcardtrfcpoldtltmps")
public interface SIncidCardTrfcPolDtlTmpRepository extends PagingAndSortingRepository<SIncidCardTrfcPolDtlTmp, Integer>{
}

package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardPolDtlTmp;

@RepositoryRestResource(collectionResourceRel="sincidcardpoldtltmps", path="sincidcardpoldtltmps")
public interface SIncidCardPolDtlTmpRepository extends PagingAndSortingRepository<SIncidCardPolDtlTmp, Integer>{
}

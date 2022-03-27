package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardFireDtlTmp;

@RepositoryRestResource(collectionResourceRel="sincidcardfiredtltmps", path="sincidcardfiredtltmps")
public interface SIncidCardFireDtlTmpRepository extends PagingAndSortingRepository<SIncidCardFireDtlTmp, Integer>{
}

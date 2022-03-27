package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MBldgDtl;

@RepositoryRestResource(collectionResourceRel="mbldgdtls", path="mbldgdtls")
public interface MBldgDtlRepository extends PagingAndSortingRepository<MBldgDtl, String>{
}

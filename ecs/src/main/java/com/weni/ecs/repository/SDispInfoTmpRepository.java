package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SDispInfoTmp;

@RepositoryRestResource(collectionResourceRel="sdispinfotmps", path="sdispinfotmps")
public interface SDispInfoTmpRepository extends PagingAndSortingRepository<SDispInfoTmp, Integer>{
}

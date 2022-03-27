package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SDispInfo;

@RepositoryRestResource(collectionResourceRel="sdispinfos", path="sdispinfos")
public interface SDispInfoRepository extends PagingAndSortingRepository<SDispInfo, Integer>{
}

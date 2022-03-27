package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SRecptVrecFileInfo;

@RepositoryRestResource(collectionResourceRel="srecptvrecfileinfos", path="srecptvrecfileinfos")
public interface SRecptVrecFileInfoRepository extends PagingAndSortingRepository<SRecptVrecFileInfo, String>{
}

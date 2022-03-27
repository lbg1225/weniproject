package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MBldgFileInfo;

@RepositoryRestResource(collectionResourceRel="mbldgfileinfos", path="mbldgfileinfos")
public interface MBldgFileInfoRepository extends PagingAndSortingRepository<MBldgFileInfo, String>{
}

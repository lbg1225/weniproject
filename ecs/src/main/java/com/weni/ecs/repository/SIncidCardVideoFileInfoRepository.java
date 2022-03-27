package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardVideoFileInfo;

@RepositoryRestResource(collectionResourceRel="sincidcardvideofileinfos", path="sincidcardvideofileinfos")
public interface SIncidCardVideoFileInfoRepository extends PagingAndSortingRepository<SIncidCardVideoFileInfo, Integer>{
}

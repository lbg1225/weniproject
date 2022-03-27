package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MJurisInfo;

@RepositoryRestResource(collectionResourceRel="mjurisinfos", path="mjurisinfos")
public interface MJurisInfoRepository extends PagingAndSortingRepository<MJurisInfo, String>{
}

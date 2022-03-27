package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MJurisMngInfo;

@RepositoryRestResource(collectionResourceRel="mjurismnginfos", path="mjurismnginfos")
public interface MJurisMngInfoRepository extends PagingAndSortingRepository<MJurisMngInfo, String>{
}

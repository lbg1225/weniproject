package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.IDispFacHist;

@RepositoryRestResource(collectionResourceRel="idispfachists", path="idispfachists")
public interface IDispFacHistRepository extends PagingAndSortingRepository<IDispFacHist, Integer>{
}

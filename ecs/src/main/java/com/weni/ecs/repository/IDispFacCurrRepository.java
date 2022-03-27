package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.IDispFacCurr;

@RepositoryRestResource(collectionResourceRel="idispfaccurrs", path="idispfaccurrs")
public interface IDispFacCurrRepository extends PagingAndSortingRepository<IDispFacCurr, Integer>{
}

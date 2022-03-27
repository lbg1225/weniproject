package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.JJurisAgcy;

@RepositoryRestResource(collectionResourceRel="jjurisagcys", path="jjurisagcys")
public interface JJurisAgcyRepository extends PagingAndSortingRepository<JJurisAgcy, String>{
}
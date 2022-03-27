package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.IExtnIfRslt;

@RepositoryRestResource(collectionResourceRel="iextnifrslts", path="iextnifrslts")
public interface IExtnIfRsltRepository extends PagingAndSortingRepository<IExtnIfRslt, String>{
}

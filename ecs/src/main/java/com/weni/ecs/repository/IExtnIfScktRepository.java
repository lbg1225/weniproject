package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.IExtnIfSckt;

@RepositoryRestResource(collectionResourceRel="iextnifsckts", path="iextnifsckts")
public interface IExtnIfScktRepository extends PagingAndSortingRepository<IExtnIfSckt, String>{
}

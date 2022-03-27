package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCardPol;

@RepositoryRestResource(collectionResourceRel="sincidcardpols", path="sincidcardpols")
public interface SIncidCardPolRepository extends PagingAndSortingRepository<SIncidCardPol, Integer>{
}

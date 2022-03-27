package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SIncidCard;

@RepositoryRestResource(collectionResourceRel="sincidcards", path="sincidcards")
public interface SIncidCardRepository extends PagingAndSortingRepository<SIncidCard, Integer>{
}

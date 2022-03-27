package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.SWrongReprtPhon;

@RepositoryRestResource(collectionResourceRel="swrongreprtphons", path="swrongreprtphons")
public interface SWrongReprtPhonRepository extends PagingAndSortingRepository<SWrongReprtPhon, Integer>{
}
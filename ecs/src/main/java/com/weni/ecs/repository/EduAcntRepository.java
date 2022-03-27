package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.EduAcnt;

@RepositoryRestResource(collectionResourceRel="eduacnts", path="eduacnts")
public interface EduAcntRepository extends PagingAndSortingRepository<EduAcnt, Integer>{
}

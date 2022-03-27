package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MClssfyCodeGetNum;

@RepositoryRestResource(collectionResourceRel="mclssfycodegetnums", path="mclssfycodegetnums")
public interface MClssfyCodeGetNumRepository extends PagingAndSortingRepository<MClssfyCodeGetNum, String>{
}

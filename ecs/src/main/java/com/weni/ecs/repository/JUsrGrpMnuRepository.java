package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.JUsrGrpMnu;

@RepositoryRestResource(collectionResourceRel="jusrgrpmnus", path="jusrgrpmnus")
public interface JUsrGrpMnuRepository extends PagingAndSortingRepository<JUsrGrpMnu, String>{
}

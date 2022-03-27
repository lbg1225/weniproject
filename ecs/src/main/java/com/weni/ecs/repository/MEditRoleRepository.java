package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MEditRole;

@RepositoryRestResource(collectionResourceRel="meditroles", path="meditroles")
public interface MEditRoleRepository extends PagingAndSortingRepository<MEditRole, String>{
}

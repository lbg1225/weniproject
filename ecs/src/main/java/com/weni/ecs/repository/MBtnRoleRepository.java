package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MBtnRole;

@RepositoryRestResource(collectionResourceRel="mbtnroles", path="mbtnroles")
public interface MBtnRoleRepository extends PagingAndSortingRepository<MBtnRole, String>{
}

package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MIncidType;

@RepositoryRestResource(collectionResourceRel="mincidtypes", path="mincidtypes")
public interface MIncidTypeRepository extends PagingAndSortingRepository<MIncidType, String>{
}

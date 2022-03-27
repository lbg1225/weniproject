package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.JUsrGrpRelatdBusn;

@RepositoryRestResource(collectionResourceRel="jusrgrprelatdbusns", path="jusrgrprelatdbusns")
public interface JUsrGrpRelatdBusnRepository extends PagingAndSortingRepository<JUsrGrpRelatdBusn, String>{
}

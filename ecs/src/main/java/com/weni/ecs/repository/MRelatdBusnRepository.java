package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MRelatdBusn;

@RepositoryRestResource(collectionResourceRel="mrelatdbusns", path="mrelatdbusns")
public interface MRelatdBusnRepository extends PagingAndSortingRepository<MRelatdBusn, String>{
}

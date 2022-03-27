package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MAddrRoadSect;

@RepositoryRestResource(collectionResourceRel="maddrroadsects", path="maddrroadsects")
public interface MAddrRoadSectRepository extends PagingAndSortingRepository<MAddrRoadSect, String>{
}

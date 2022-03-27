package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MUsrGrp;

@RepositoryRestResource(collectionResourceRel="musrgrps", path="musrgrps")
public interface MUsrGrpRepository extends PagingAndSortingRepository<MUsrGrp, String>{
}

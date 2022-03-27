package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.HCallIfHist;

@RepositoryRestResource(collectionResourceRel="hcallifhists", path="hcallifhists")
public interface HCallIfHistRepository extends PagingAndSortingRepository<HCallIfHist, Integer>{
}

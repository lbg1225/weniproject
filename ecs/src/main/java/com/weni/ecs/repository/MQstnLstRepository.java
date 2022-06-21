/** 
* MQstnLst Entity 접근을 위한 Repository 클래스 

* @author  Lee Byoung Gwan
* @version 1.0 
* @see     org.springframework.data.repository.PagingAndSortingRepository
*/
package com.weni.ecs.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.weni.ecs.domain.MQstnLst;

@RepositoryRestResource(collectionResourceRel="mqstnlsts", path="mqstnlsts")
public interface MQstnLstRepository extends PagingAndSortingRepository<MQstnLst, String>{
}

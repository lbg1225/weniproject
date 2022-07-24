/**
 * MLabl Entity Controller 클래스
 *
 *  @author  Lee Byoung Gwan
 *  @version 1.0
**/
package com.weni.ecs.domain.repository;

// import java.util.Map;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.weni.ecs.domain.entity.MLabl;

@RepositoryRestResource
public interface MLablRepository extends JpaRepository<MLabl, String> {
	// JPQL SAMPLE
	// @Query("select new  com.sample.dto.TestUser(m.username, m.address, m.age) from User m")
    // Page<TestUser>test(Pageable pageable);

	// JPQL SAMPLE
	// @Query("select new map(m.username, m.address, m.age) from User m")
    // Page<Map<String, Object>>test(Pageable pageable);
}

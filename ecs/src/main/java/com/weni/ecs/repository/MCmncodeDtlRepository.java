package com.weni.ecs.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.weni.ecs.domain.MCmncode;
import com.weni.ecs.domain.MCmncodeDtl;
import com.weni.ecs.dto.MCmncodeDtlMCmncode;

@RepositoryRestResource(collectionResourceRel="mcmncodedtls", path="mcmncodedtls")
public interface MCmncodeDtlRepository extends PagingAndSortingRepository<MCmncodeDtl, String>{
    @RestResource
    @Query("SELECT m From MCmncodeDtl m LEFT JOIN MCmncode n ON n.clssfyCode = m.clssfyCode WHERE m.clssfyCode = :clssfyCode")
    List<MCmncodeDtlMCmncode> findByclssfyCode(String clssfyCode);
   // List<MCmncodeDtlMCmncode> findByclssfyCode(String clssfyCode);
}

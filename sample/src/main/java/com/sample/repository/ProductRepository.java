package com.sample.repository;

import com.sample.domain.Product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository
  extends PagingAndSortingRepository<Product, Long> {}

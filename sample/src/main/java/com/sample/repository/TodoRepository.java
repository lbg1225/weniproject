package com.sample.repository;

import com.sample.domain.TodoEntity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
public interface TodoRepository
  extends PagingAndSortingRepository<TodoEntity, String> {}

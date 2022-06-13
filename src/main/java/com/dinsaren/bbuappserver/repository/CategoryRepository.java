package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAllByStatus(String status);
}

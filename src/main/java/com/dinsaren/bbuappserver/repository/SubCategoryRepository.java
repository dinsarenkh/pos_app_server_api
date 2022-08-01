package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Integer> {
    List<SubCategory> findAllByCategoryIdAndStatus(Integer categoryId, String status);
}

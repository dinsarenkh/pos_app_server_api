package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    List<Brand> findAllBySubCategoryIdAndStatus(Integer subCategoryId, String status);
}

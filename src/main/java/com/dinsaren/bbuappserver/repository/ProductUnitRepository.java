package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.ProductUnit;
import com.dinsaren.bbuappserver.models.UnitType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductUnitRepository extends CrudRepository<ProductUnit, Integer> {
    List<ProductUnit> findAllByStatus(String status);
    List<ProductUnit> findAllByProductIdAndStatus(Integer productId, String status);
}

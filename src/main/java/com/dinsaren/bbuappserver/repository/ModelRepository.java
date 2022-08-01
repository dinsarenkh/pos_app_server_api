package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Integer> {
    List<Model> findAllByBrandIdAndStatus(Integer brandId, String status);
}

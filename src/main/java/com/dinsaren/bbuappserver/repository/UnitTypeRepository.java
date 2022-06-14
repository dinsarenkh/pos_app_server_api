package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Category;
import com.dinsaren.bbuappserver.models.UnitType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnitTypeRepository extends CrudRepository<UnitType, Integer> {
    List<UnitType> findAllByStatus(String status);
    Integer countByMerchantIdAndStatus(Integer merchantId, String status);
}

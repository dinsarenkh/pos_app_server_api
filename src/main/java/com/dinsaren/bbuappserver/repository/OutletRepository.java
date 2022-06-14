package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Category;
import com.dinsaren.bbuappserver.models.Outlet;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OutletRepository extends CrudRepository<Outlet, Integer> {
    List<Outlet> findAllByStatus(String status);
    Integer countByMerchantIdAndStatus(Integer merchantId, String status);
}

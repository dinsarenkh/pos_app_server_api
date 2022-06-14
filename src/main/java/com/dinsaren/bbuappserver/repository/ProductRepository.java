package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAllByStatus(String status);
    List<Product> findAllByCategoryIdAndStatus(Integer categoryId, String status);
    Integer countByMerchantIdAndStatus(Integer merchantId, String status);
}

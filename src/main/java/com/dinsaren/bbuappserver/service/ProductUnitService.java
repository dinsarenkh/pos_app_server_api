package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.ProductUnitReq;
import com.dinsaren.bbuappserver.payload.res.ProductUnitRes;

import java.util.List;

public interface ProductUnitService {
    List<ProductUnitRes> findAll();
    List<ProductUnitRes> findAllByProduct(Integer id);
    void create(ProductUnitReq req);
    void delete(ProductUnitReq req);
    void update(ProductUnitReq req);
    ProductUnitRes findById(Integer id);
}

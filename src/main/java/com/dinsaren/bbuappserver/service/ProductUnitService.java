package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.ProductUnitCreateReq;
import com.dinsaren.bbuappserver.payload.req.ProductUnitUpdateReq;
import com.dinsaren.bbuappserver.payload.res.ProductUnitRes;

import java.util.List;

public interface ProductUnitService {
    List<ProductUnitRes> findAll();
    List<ProductUnitRes> findAllByProduct(Integer id);
    void create(ProductUnitCreateReq req);
    void delete(ProductUnitUpdateReq req);
    void update(ProductUnitUpdateReq req);
    ProductUnitRes findById(Integer id);
}

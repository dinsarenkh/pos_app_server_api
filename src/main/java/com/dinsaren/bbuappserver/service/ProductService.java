package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.ProductCreateReq;
import com.dinsaren.bbuappserver.payload.req.ProductUpdateReq;
import com.dinsaren.bbuappserver.payload.res.ProductRes;

import java.util.List;

public interface ProductService {
    List<ProductRes> findAll();

    List<ProductRes> findAllByCategoryId(Integer id);

    void create(ProductCreateReq req);

    void delete(ProductUpdateReq req);

    void update(ProductUpdateReq req);

    ProductRes findById(Integer id);
}

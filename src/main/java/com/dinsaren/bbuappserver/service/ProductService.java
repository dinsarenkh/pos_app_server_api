package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.ProductReq;
import com.dinsaren.bbuappserver.payload.res.ProductRes;

import java.util.List;

public interface ProductService {
    List<ProductRes> findAll();
    List<ProductRes> findAllByCategoryId(Integer id);
    void create(ProductReq req);
    void delete(ProductReq req);
    void update(ProductReq req);
    ProductRes findById(Integer id);
    Integer countByMerchantIdAndStatus(Integer merchantId);
}

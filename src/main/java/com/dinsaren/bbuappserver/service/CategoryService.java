package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.CategoryReq;
import com.dinsaren.bbuappserver.payload.res.CategoryRes;

import java.util.List;

public interface CategoryService {
    List<CategoryRes> findAll();

    void create(CategoryReq req);

    void delete(CategoryReq req);

    void update(CategoryReq req);

    CategoryRes findById(Integer id);

    Integer countCategoryByMerchantId(Integer merchantId);
}

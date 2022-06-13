package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.CategoryCreateReq;
import com.dinsaren.bbuappserver.payload.req.CategoryUpdateReq;
import com.dinsaren.bbuappserver.payload.res.CategoryRes;

import java.util.List;

public interface CategoryService {
    List<CategoryRes> findAll();

    void create(CategoryCreateReq req);

    void delete(CategoryUpdateReq req);

    void update(CategoryUpdateReq req);

    CategoryRes findById(Integer id);
}

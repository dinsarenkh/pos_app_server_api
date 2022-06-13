package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.CategoryCreateReq;
import com.dinsaren.bbuappserver.payload.req.CategoryUpdateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeUpdateReq;
import com.dinsaren.bbuappserver.payload.res.CategoryRes;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;

import java.util.List;

public interface UnitTypeService {
    List<UnitTypeRes> findAll();
    void create(UnitTypeCreateReq req);
    void delete(UnitTypeUpdateReq req);
    void update(UnitTypeUpdateReq req);
    UnitTypeRes findById(Integer id);
}

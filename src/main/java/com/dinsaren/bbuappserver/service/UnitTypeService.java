package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;

import java.util.List;

public interface UnitTypeService {
    List<UnitTypeRes> findAll();
    void create(UnitTypeCreateReq req);
    void delete(UnitTypeCreateReq req);
    void update(UnitTypeCreateReq req);
    UnitTypeRes findById(Integer id);
    Integer countByMerchantIdAndStatus(Integer merchantId);
}

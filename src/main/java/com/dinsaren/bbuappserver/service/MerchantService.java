package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.MerchantReq;
import com.dinsaren.bbuappserver.payload.res.MerchantRes;
import java.util.List;

public interface MerchantService {
    List<MerchantRes> findAll();
    void create(MerchantReq req);
    void delete(MerchantReq req);
    void update(MerchantReq req);
    MerchantRes findById(Integer id);
}

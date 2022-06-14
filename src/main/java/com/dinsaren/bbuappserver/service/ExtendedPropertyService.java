package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.ExtendedPropertyReq;
import com.dinsaren.bbuappserver.payload.res.ExtendedPropertyRes;
import java.util.List;

public interface ExtendedPropertyService {
    List<ExtendedPropertyRes> findAll();
    List<ExtendedPropertyRes> findAllByCode(String code);
    void create(ExtendedPropertyReq req);
    void delete(ExtendedPropertyReq req);
    void update(ExtendedPropertyReq req);
    ExtendedPropertyRes findById(Integer id);
    ExtendedPropertyRes findByKey(String key);
}

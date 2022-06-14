package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.PeopleReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeUpdateReq;
import com.dinsaren.bbuappserver.payload.res.PeopleRes;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;
import java.util.List;

public interface PeopleService {
    List<PeopleRes> findAll();
    List<PeopleRes> findAllByType(String type);
    void create(PeopleReq req);
    void delete(PeopleReq req);
    void update(PeopleReq req);
    PeopleRes findById(Integer id);
    Integer countByMerchantIdAndStatus(Integer merchantId);

}

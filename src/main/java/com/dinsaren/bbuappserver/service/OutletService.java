package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.payload.req.OutletReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeUpdateReq;
import com.dinsaren.bbuappserver.payload.res.OutletRes;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;
import java.util.List;

public interface OutletService {
    List<OutletRes> findAll();
    void create(OutletReq req);
    void delete(OutletReq req);
    void update(OutletReq req);
    OutletRes findById(Integer id);
    Integer countByMerchantIdAndStatus(Integer merchantId);
}

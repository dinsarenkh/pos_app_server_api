package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Outlet;
import com.dinsaren.bbuappserver.models.UnitType;
import com.dinsaren.bbuappserver.payload.req.OutletReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeUpdateReq;
import com.dinsaren.bbuappserver.payload.res.OutletRes;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;
import com.dinsaren.bbuappserver.repository.OutletRepository;
import com.dinsaren.bbuappserver.repository.UnitTypeRepository;
import com.dinsaren.bbuappserver.service.OutletService;
import com.dinsaren.bbuappserver.service.UnitTypeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OutletServiceImpl implements OutletService {
    private final OutletRepository outletRepository;

    public OutletServiceImpl(OutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    @Override
    public List<OutletRes> findAll() {
        List<OutletRes> list = new ArrayList<>();
        outletRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c->{
            OutletRes res = new OutletRes();
            res.setDataRes(c);
            list.add(res);
        });
        return list;
    }

    @Override
    public void create(OutletReq req) {
        Outlet create = new Outlet();
        create.setCreate(req);
        outletRepository.save(create);
    }

    @Override
    public void delete(OutletReq req) {
        var find = outletRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            find.get().setStatus(Constants.DELETE_STATUS);
            outletRepository.save(find.get());
        }
    }

    @Override
    public void update(OutletReq req) {
        var find = outletRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            outletRepository.save(find.get());
        }
    }

    @Override
    public OutletRes findById(Integer id) {
        OutletRes res = new OutletRes();
        var find = outletRepository.findById(id);
        if(find.isPresent()){
            res.setDataRes(find.get());
            return res;
        }
        return null;
    }

    @Override
    public Integer countByMerchantIdAndStatus(Integer merchantId) {
        return outletRepository.countByMerchantIdAndStatus(merchantId, Constants.ACTIVE_STATUS);
    }
}

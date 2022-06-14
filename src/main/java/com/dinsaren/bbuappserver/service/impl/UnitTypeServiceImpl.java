package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Category;
import com.dinsaren.bbuappserver.models.UnitType;
import com.dinsaren.bbuappserver.payload.req.CategoryCreateReq;
import com.dinsaren.bbuappserver.payload.req.CategoryUpdateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeUpdateReq;
import com.dinsaren.bbuappserver.payload.res.CategoryRes;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;
import com.dinsaren.bbuappserver.repository.CategoryRepository;
import com.dinsaren.bbuappserver.repository.UnitTypeRepository;
import com.dinsaren.bbuappserver.service.CategoryService;
import com.dinsaren.bbuappserver.service.UnitTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitTypeServiceImpl implements UnitTypeService {
    private final UnitTypeRepository unitTypeRepository;

    public UnitTypeServiceImpl(UnitTypeRepository unitTypeRepository) {
        this.unitTypeRepository = unitTypeRepository;
    }

    @Override
    public List<UnitTypeRes> findAll() {
        List<UnitTypeRes> list = new ArrayList<>();
        unitTypeRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c->{
            UnitTypeRes res = new UnitTypeRes();
            res.setDateRes(c);
            list.add(res);
        });
        return list;
    }

    @Override
    public void create(UnitTypeCreateReq req) {
        UnitType create = new UnitType();
        create.setCreate(req);
        unitTypeRepository.save(create);
    }

    @Override
    public void delete(UnitTypeUpdateReq req) {
        var find = unitTypeRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            find.get().setStatus(Constants.DELETE_STATUS);
            unitTypeRepository.save(find.get());
        }
    }

    @Override
    public void update(UnitTypeUpdateReq req) {
        var find = unitTypeRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            unitTypeRepository.save(find.get());
        }
    }

    @Override
    public UnitTypeRes findById(Integer id) {
        UnitTypeRes res = new UnitTypeRes();
        var find = unitTypeRepository.findById(id);
        if(find.isPresent()){
            res.setDateRes(find.get());
            return res;
        }
        return null;
    }

    @Override
    public Integer countByMerchantIdAndStatus(Integer merchantId) {
        return unitTypeRepository.countByMerchantIdAndStatus(merchantId, Constants.ACTIVE_STATUS);
    }
}

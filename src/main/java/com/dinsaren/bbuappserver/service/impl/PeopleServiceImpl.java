package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.People;
import com.dinsaren.bbuappserver.payload.req.PeopleReq;
import com.dinsaren.bbuappserver.payload.res.PeopleRes;
import com.dinsaren.bbuappserver.repository.PeopleRepository;
import com.dinsaren.bbuappserver.service.PeopleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<PeopleRes> findAll() {
        List<PeopleRes> list = new ArrayList<>();
        peopleRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c->{
            PeopleRes res = new PeopleRes();
            res.setData(c);
            list.add(res);
        });
        return list;
    }

    @Override
    public List<PeopleRes> findAllByType(String type) {
        List<PeopleRes> list = new ArrayList<>();
        peopleRepository.findAllByTypeAndStatus(type, Constants.ACTIVE_STATUS).forEach(c->{
            PeopleRes res = new PeopleRes();
            res.setData(c);
            list.add(res);
        });
        return list;
    }

    @Override
    public void create(PeopleReq req) {
        People create = new People();
        create.setDataCreate(req);
        peopleRepository.save(create);
    }

    @Override
    public void delete(PeopleReq req) {
        var find = peopleRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setDataUpdate(req);
            find.get().setStatus(Constants.DELETE_STATUS);
            peopleRepository.save(find.get());
        }
    }

    @Override
    public void update(PeopleReq req) {
        var find = peopleRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setDataUpdate(req);
            peopleRepository.save(find.get());
        }
    }

    @Override
    public PeopleRes findById(Integer id) {
        PeopleRes res = new PeopleRes();
        var find = peopleRepository.findById(id);
        if(find.isPresent()){
            res.setData(find.get());
            return res;
        }
        return null;
    }

    @Override
    public Integer countByMerchantIdAndStatus(Integer merchantId) {
        return peopleRepository.countByMerchantIdAndStatus(merchantId, Constants.ACTIVE_STATUS);
    }


}

package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.ExtendedProperty;
import com.dinsaren.bbuappserver.payload.req.ExtendedPropertyReq;
import com.dinsaren.bbuappserver.payload.res.ExtendedPropertyRes;
import com.dinsaren.bbuappserver.repository.ExtendedPropertyRepository;
import com.dinsaren.bbuappserver.service.ExtendedPropertyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExtendedPropertyServiceImpl implements ExtendedPropertyService {
	private final ExtendedPropertyRepository extendedPropertyRepository;

	public ExtendedPropertyServiceImpl(ExtendedPropertyRepository extendedPropertyRepository) {
		this.extendedPropertyRepository = extendedPropertyRepository;
	}

	@Override
	public List<ExtendedPropertyRes> findAll() {
		List<ExtendedPropertyRes> resList = new ArrayList<>();
		extendedPropertyRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c->{
			ExtendedPropertyRes res = new ExtendedPropertyRes();
			res.setData(c);
			resList.add(res);
		});
		return resList;
	}

	@Override
	public List<ExtendedPropertyRes> findAllByCode(String code) {
		List<ExtendedPropertyRes> resList = new ArrayList<>();
		extendedPropertyRepository.findAllByCodeAndStatus(code, Constants.ACTIVE_STATUS).forEach(c->{
			ExtendedPropertyRes res = new ExtendedPropertyRes();
			res.setData(c);
			resList.add(res);
		});
		return resList;
	}

	@Override
	public void create(ExtendedPropertyReq req) {
		ExtendedProperty create = new ExtendedProperty();
		create.setCreate(req);
		extendedPropertyRepository.save(create);
	}

	@Override
	public void delete(ExtendedPropertyReq req) {
		var find = extendedPropertyRepository.findById(req.getId());
		if(find.isPresent()){
			find.get().setUpdate(req);
			find.get().setStatus(Constants.DELETE_STATUS);
			extendedPropertyRepository.save(find.get());
		}
	}

	@Override
	public void update(ExtendedPropertyReq req) {
		var find = extendedPropertyRepository.findById(req.getId());
		if(find.isPresent()){
			find.get().setUpdate(req);
			extendedPropertyRepository.save(find.get());
		}
	}

	@Override
	public ExtendedPropertyRes findById(Integer id) {
		var find = extendedPropertyRepository.findById(id);
		ExtendedPropertyRes res = new ExtendedPropertyRes();
		find.ifPresent(res::setData);
		return res;
	}

	@Override
	public ExtendedPropertyRes findByKey(String key) {
		ExtendedPropertyRes res = new ExtendedPropertyRes();
		var find = extendedPropertyRepository.findByKeyAndStatus(key, Constants.ACTIVE_STATUS);
		if(find.isPresent()) {
			res.setData(find.get());
		}
		return res;
	}
}

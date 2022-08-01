package com.dinsaren.bbuappserver.security.services.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Slide;
import com.dinsaren.bbuappserver.repository.SlideRepository;
import com.dinsaren.bbuappserver.security.services.SlideService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideServiceImpl implements SlideService {
    private final SlideRepository slideRepository;

    public SlideServiceImpl(SlideRepository slideRepository) {
        this.slideRepository = slideRepository;
    }

    @Override
    public List<Slide> findAllSlide() {
        return slideRepository.findAllByStatus(Constants.ACTIVE_STATUS);
    }

    @Override
    public Slide findById(Integer id) {
        return slideRepository.findByIdAndStatus(id, Constants.ACTIVE_STATUS);
    }

    @Override
    public void save(Slide req) {
        req.setId(0);
        req.setStatus(Constants.ACTIVE_STATUS);
        slideRepository.save(req);
    }

    @Override
    public void update(Slide req) {
        var checkId = findById(req.getId());
        if(null != checkId){
            slideRepository.save(req);
        }
    }

    @Override
    public void delete(Slide req) {
        var checkId = findById(req.getId());
        if(null != checkId){
            checkId.setStatus(Constants.DELETE_STATUS);
            slideRepository.save(checkId);
        }
    }

}

package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Branch;
import com.dinsaren.bbuappserver.models.Floor;
import com.dinsaren.bbuappserver.repository.BranchRepository;
import com.dinsaren.bbuappserver.repository.FloorRepository;
import com.dinsaren.bbuappserver.service.BranchService;
import com.dinsaren.bbuappserver.service.FloorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorServiceImpl implements FloorService {

    private final FloorRepository floorRepository;

    public FloorServiceImpl(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @Override
    public List<Floor> findAll() {
        return floorRepository.findAllByStatus(Constants.ACTIVE_STATUS);
    }

    @Override
    public List<Floor> findAllByBranchId(Integer id) {
        return floorRepository.findAllByBranchIdAndStatus(id,Constants.ACTIVE_STATUS);
    }

    @Override
    public void create(Floor req) {
        Floor find =this.findById(req.getId());
        if (null == find) {
            req.setId(0);
            req.setStatus(Constants.ACTIVE_STATUS);
            floorRepository.save(req);
        }
    }

    @Override
    public void delete(Floor req) {
        Floor find =this.findById(req.getId());
        if (null != find) {
            find.setStatus(Constants.DELETE_STATUS);
            floorRepository.save(find);
        }
    }

    @Override
    public void update(Floor req) {
        Floor find =this.findById(req.getId());
        if (null != find) {
            req.setStatus(Constants.ACTIVE_STATUS);
            floorRepository.save(req);
        }
    }

    @Override
    public Floor findById(Integer id) {
        Optional<Floor> find = floorRepository.findByIdAndStatus(id,Constants.ACTIVE_STATUS);
        return find.orElse(null);

    }
}

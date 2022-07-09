package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.RoomType;
import com.dinsaren.bbuappserver.repository.RoomTypeRepository;
import com.dinsaren.bbuappserver.service.RoomTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public List<RoomType> findAll() {
        return roomTypeRepository.findAllByStatus(Constants.ACTIVE_STATUS);
    }

    @Override
    public void create(RoomType req) {
        RoomType find =this.findById(req.getId());
        if (find == null) {
            req.setId(0);
            req.setStatus(Constants.ACTIVE_STATUS);
            roomTypeRepository.save(req);
        }
    }

    @Override
    public void delete(RoomType req) {
        RoomType find =this.findById(req.getId());
        if (null != find) {
            find.setStatus(Constants.DELETE_STATUS);
            roomTypeRepository.save(find);
        }
    }

    @Override
    public void update(RoomType req) {
        RoomType find =this.findById(req.getId());
        if (null != find) {
            req.setStatus(Constants.ACTIVE_STATUS);
            roomTypeRepository.save(req);
        }
    }

    @Override
    public RoomType findById(Integer id) {
        Optional<RoomType> find = roomTypeRepository.findByIdAndStatus(id,Constants.ACTIVE_STATUS);
        return find.orElse(null);

    }
}

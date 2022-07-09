package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Room;
import com.dinsaren.bbuappserver.repository.RoomRepository;
import com.dinsaren.bbuappserver.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAllByStatus(Constants.ACTIVE_STATUS);
    }

    @Override
    public List<Room> findAllByFloorId(Integer id) {
        return roomRepository.findByFloorIdAndStatus(id,Constants.ACTIVE_STATUS);
    }

    @Override
    public void create(Room req) {
        Room find =this.findById(req.getId());
        if (null == find) {
            req.setId(0);
            req.setStatus(Constants.ACTIVE_STATUS);
            roomRepository.save(req);
        }
    }

    @Override
    public void delete(Room req) {
        Room find =this.findById(req.getId());
        if (null != find) {
            find.setStatus(Constants.DELETE_STATUS);
            roomRepository.save(find);
        }
    }

    @Override
    public void update(Room req) {
        Room find =this.findById(req.getId());
        if (null != find) {
            req.setStatus(Constants.ACTIVE_STATUS);
            roomRepository.save(req);
        }
    }

    @Override
    public Room findById(Integer id) {
        Optional<Room> find = roomRepository.findByIdAndStatus(id,Constants.ACTIVE_STATUS);
        return find.orElse(null);

    }
}

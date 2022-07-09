package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.models.Branch;
import com.dinsaren.bbuappserver.models.RoomType;

import java.util.List;

public interface RoomTypeService {
    List<RoomType> findAll();
    void create(RoomType req);
    void delete(RoomType req);
    void update(RoomType req);
    RoomType findById(Integer id);

}

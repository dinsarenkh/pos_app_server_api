package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.models.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAllByFloorId(Integer id);
    List<Room> findAll();
    void create(Room req);
    void delete(Room req);
    void update(Room req);
    Room findById(Integer id);

}

package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.models.Floor;

import java.util.List;

public interface FloorService {
    List<Floor> findAllByBranchId(Integer id);
    List<Floor> findAll();
    void create(Floor req);
    void delete(Floor req);
    void update(Floor req);
    Floor findById(Integer id);

}

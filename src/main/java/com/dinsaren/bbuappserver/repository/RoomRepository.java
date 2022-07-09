package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    List<Room> findAllByStatus(String status);
    List<Room> findByFloorIdAndStatus(Integer floorId, String status);
    Optional<Room> findByIdAndStatus(Integer id, String status);
}

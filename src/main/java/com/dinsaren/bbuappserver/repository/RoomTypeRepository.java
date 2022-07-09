package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Branch;
import com.dinsaren.bbuappserver.models.RoomType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomTypeRepository extends CrudRepository<RoomType, Integer> {
    List<RoomType> findAllByStatus(String status);
    Optional<RoomType> findByIdAndStatus(Integer id, String status);
}

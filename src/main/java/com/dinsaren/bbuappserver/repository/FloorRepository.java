package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Branch;
import com.dinsaren.bbuappserver.models.Floor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FloorRepository extends CrudRepository<Floor, Integer> {
    List<Floor> findAllByStatus(String status);
    List<Floor> findAllByBranchIdAndStatus(Integer branchId, String status);
    Optional<Floor> findByIdAndStatus(Integer id, String status);
}

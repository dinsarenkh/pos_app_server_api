package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Branch;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BranchRepository extends CrudRepository<Branch, Integer> {
    List<Branch> findAllByStatus(String status);
    Optional<Branch> findByIdAndStatus(Integer id, String status);
}

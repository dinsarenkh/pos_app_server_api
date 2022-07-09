package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.models.Branch;

import java.util.List;

public interface BranchService {
    List<Branch> findAll();
    void create(Branch req);
    void delete(Branch req);
    void update(Branch req);
    Branch findById(Integer id);

}

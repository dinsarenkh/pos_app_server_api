package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Branch;
import com.dinsaren.bbuappserver.repository.BranchRepository;
import com.dinsaren.bbuappserver.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAllByStatus(Constants.ACTIVE_STATUS);
    }

    @Override
    public void create(Branch req) {
        Branch find =this.findById(req.getId());
        if (null == find) {
            req.setId(0);
            req.setStatus(Constants.ACTIVE_STATUS);
            branchRepository.save(req);
        }
    }

    @Override
    public void delete(Branch req) {
        Branch find =this.findById(req.getId());
        if (null != find) {
            find.setStatus(Constants.DELETE_STATUS);
            branchRepository.save(find);
        }
    }

    @Override
    public void update(Branch req) {
        Branch find =this.findById(req.getId());
        if (null != find) {
            req.setStatus(Constants.ACTIVE_STATUS);
            branchRepository.save(req);
        }
    }

    @Override
    public Branch findById(Integer id) {
        Optional<Branch> find = branchRepository.findByIdAndStatus(id,Constants.ACTIVE_STATUS);
        return find.orElse(null);

    }
}

package com.dinsaren.bbuappserver.services;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Model;
import com.dinsaren.bbuappserver.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public List<Model> findAll(Integer brandId){
        return modelRepository.findAllByBrandIdAndStatus(brandId, Constants.ACTIVE_STATUS);
    }
}

package com.dinsaren.bbuappserver.services;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Brand;
import com.dinsaren.bbuappserver.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll(Integer subCategoryId){
        return brandRepository.findAllBySubCategoryIdAndStatus(subCategoryId, Constants.ACTIVE_STATUS);
    }
}

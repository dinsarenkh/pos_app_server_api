package com.dinsaren.bbuappserver.services;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.SubCategory;
import com.dinsaren.bbuappserver.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> findAll(Integer categoryId){
        return subCategoryRepository.findAllByCategoryIdAndStatus(categoryId, Constants.ACTIVE_STATUS);
    }
}

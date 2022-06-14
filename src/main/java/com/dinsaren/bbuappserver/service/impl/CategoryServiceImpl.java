package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Category;
import com.dinsaren.bbuappserver.payload.req.CategoryCreateReq;
import com.dinsaren.bbuappserver.payload.req.CategoryUpdateReq;
import com.dinsaren.bbuappserver.payload.res.CategoryRes;
import com.dinsaren.bbuappserver.repository.CategoryRepository;
import com.dinsaren.bbuappserver.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryRes> findAll() {
        List<CategoryRes> categoryResList = new ArrayList<>();
        categoryRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c -> {
            CategoryRes res = new CategoryRes();
            res.setDataRes(c);
            categoryResList.add(res);
        });
        return categoryResList;
    }

    @Override
    public void create(CategoryCreateReq req) {
        Category category = new Category();
        category.setCreate(req);
        categoryRepository.save(category);
    }

    @Override
    public void delete(CategoryUpdateReq req) {
        var category = categoryRepository.findById(req.getId());
        if (category.isPresent()) {
            category.get().setUpdate(req);
            category.get().setStatus(Constants.DELETE_STATUS);
            categoryRepository.save(category.get());
        }
    }

    @Override
    public void update(CategoryUpdateReq req) {
        var category = categoryRepository.findById(req.getId());
        if (category.isPresent()) {
            category.get().setUpdate(req);
            categoryRepository.save(category.get());
        }
    }

    @Override
    public CategoryRes findById(Integer id) {
        CategoryRes res = new CategoryRes();
        var category = categoryRepository.findById(id);
        if (category.isPresent()) {
            res.setDataRes(category.get());
            return res;
        }
        return null;
    }

    @Override
    public Integer countCategoryByMerchantId(Integer merchantId) {
        return categoryRepository.countByMerchantIdAndStatus(merchantId, Constants.ACTIVE_STATUS);
    }

}

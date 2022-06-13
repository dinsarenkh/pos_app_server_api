package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Product;
import com.dinsaren.bbuappserver.payload.req.ProductCreateReq;
import com.dinsaren.bbuappserver.payload.req.ProductUpdateReq;
import com.dinsaren.bbuappserver.payload.res.ProductRes;
import com.dinsaren.bbuappserver.repository.ProductRepository;
import com.dinsaren.bbuappserver.service.CategoryService;
import com.dinsaren.bbuappserver.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductRes> findAll() {
        List<ProductRes> list = new ArrayList<>();
        productRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c -> {
            ProductRes res = new ProductRes();
            var category = categoryService.findById(c.getCategoryId());
            res.setDataRes(c, category);
            list.add(res);
        });
        return list;
    }

    @Override
    public List<ProductRes> findAllByCategoryId(Integer id) {
        List<ProductRes> list = new ArrayList<>();
        productRepository.findAllByCategoryIdAndStatus(id, Constants.ACTIVE_STATUS).forEach(c -> {
            ProductRes res = new ProductRes();
            var category = categoryService.findById(c.getCategoryId());
            res.setDataRes(c, category);
            list.add(res);
        });
        return list;
    }

    @Override
    public void create(ProductCreateReq req) {
        Product create = new Product();
        create.setCreate(req);
        productRepository.save(create);
    }

    @Override
    public void delete(ProductUpdateReq req) {
        var find = productRepository.findById(req.getId());
        if (find.isPresent()) {
            find.get().setUpdate(req);
            find.get().setStatus(Constants.DELETE_STATUS);
            productRepository.save(find.get());
        }
    }

    @Override
    public void update(ProductUpdateReq req) {
        var find = productRepository.findById(req.getId());
        if (find.isPresent()) {
            find.get().setUpdate(req);
            productRepository.save(find.get());
        }
    }

    @Override
    public ProductRes findById(Integer id) {
        ProductRes res = new ProductRes();
        var find = productRepository.findById(id);
        if (find.isPresent()) {
            var category = categoryService.findById(find.get().getCategoryId());
            res.setDataRes(find.get(), category);
            return res;
        }
        return null;
    }
}

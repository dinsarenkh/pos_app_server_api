package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.ProductUnit;
import com.dinsaren.bbuappserver.payload.req.ProductUnitReq;
import com.dinsaren.bbuappserver.payload.res.ProductUnitRes;
import com.dinsaren.bbuappserver.repository.ProductUnitRepository;
import com.dinsaren.bbuappserver.service.ProductService;
import com.dinsaren.bbuappserver.service.ProductUnitService;
import com.dinsaren.bbuappserver.service.UnitTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductUnitServiceImpl implements ProductUnitService {
    private final ProductUnitRepository productUnitRepository;
    private final UnitTypeService unitTypeService;
    private final ProductService productService;

    public ProductUnitServiceImpl(ProductUnitRepository productUnitRepository, UnitTypeService unitTypeService, ProductService productService) {
        this.productUnitRepository = productUnitRepository;
        this.unitTypeService = unitTypeService;
        this.productService = productService;
    }

    @Override
    public List<ProductUnitRes> findAll() {
        List<ProductUnitRes> list = new ArrayList<>();
        productUnitRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c->{
            ProductUnitRes res = new ProductUnitRes();
            var product = productService.findById(c.getProductId());
            var unitType = unitTypeService.findById(c.getUnitTypeId());
            res.setDateRes(c,product, unitType);
            list.add(res);
        });
        return list;
    }

    @Override
    public List<ProductUnitRes> findAllByProduct(Integer id) {
        List<ProductUnitRes> list = new ArrayList<>();
        productUnitRepository.findAllByProductIdAndStatus(id, Constants.ACTIVE_STATUS).forEach(c->{
            ProductUnitRes res = new ProductUnitRes();
            var product = productService.findById(c.getProductId());
            var unitType = unitTypeService.findById(c.getUnitTypeId());
            res.setDateRes(c,product, unitType);
            list.add(res);
        });
        return list;
    }

    @Override
    public void create(ProductUnitReq req) {
        ProductUnit create = new ProductUnit();
        create.setCreate(req);
        productUnitRepository.save(create);
    }

    @Override
    public void delete(ProductUnitReq req) {
        var find = productUnitRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            find.get().setStatus(Constants.DELETE_STATUS);
            productUnitRepository.save(find.get());
        }
    }

    @Override
    public void update(ProductUnitReq req) {
        var find = productUnitRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            productUnitRepository.save(find.get());
        }
    }

    @Override
    public ProductUnitRes findById(Integer id) {
        ProductUnitRes res = new ProductUnitRes();
        var find = productUnitRepository.findById(id);
        if(find.isPresent()){
            var product = productService.findById(find.get().getProductId());
            var unitType = unitTypeService.findById(find.get().getUnitTypeId());
            res.setDateRes(find.get(),product, unitType);
            return res;
        }
        return null;
    }
}

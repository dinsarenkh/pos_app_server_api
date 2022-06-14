package com.dinsaren.bbuappserver.service.impl;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Merchant;
import com.dinsaren.bbuappserver.payload.req.MerchantReq;
import com.dinsaren.bbuappserver.payload.res.ExtendedPropertyRes;
import com.dinsaren.bbuappserver.payload.res.MerchantRes;
import com.dinsaren.bbuappserver.payload.res.UserRes;
import com.dinsaren.bbuappserver.repository.MerchantRepository;
import com.dinsaren.bbuappserver.service.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;
    private final CategoryService categoryService;
    private final ExtendedPropertyService extendedPropertyService;
    private final PeopleService peopleService;
    private final ProductService productService;
    private final UnitTypeService unitTypeService;
    private final UserService userService;
    private final OutletService outletService;

    public MerchantServiceImpl(
            MerchantRepository merchantRepository,
            CategoryService categoryService,
            ExtendedPropertyService extendedPropertyService,
            PeopleService peopleService,
            ProductService productService,
            UnitTypeService unitTypeService,
            UserService userService,
            OutletService outletService) {
        this.merchantRepository = merchantRepository;
        this.categoryService = categoryService;
        this.extendedPropertyService = extendedPropertyService;
        this.peopleService = peopleService;
        this.productService = productService;
        this.unitTypeService = unitTypeService;
        this.userService = userService;
        this.outletService = outletService;
    }

    @Override
    public List<MerchantRes> findAll() {
        List<MerchantRes> list = new ArrayList<>();
        merchantRepository.findAllByStatus(Constants.ACTIVE_STATUS).forEach(c->{
            MerchantRes res = new MerchantRes();
            Integer categories = categoryService.countCategoryByMerchantId(c.getId());
            Integer unitTypes = unitTypeService.countByMerchantIdAndStatus(c.getId());
            Integer products = productService.countByMerchantIdAndStatus(c.getId());
            ExtendedPropertyRes extendedPropertyRes = extendedPropertyService.findByKey(c.getCategoryKey());
            Integer cashiers = peopleService.countByMerchantIdAndStatus(c.getId());
            Integer outlets = outletService.countByMerchantIdAndStatus(c.getId());
            UserRes userRes = userService.findUserId(c.getHolderId());
            res.setDataRes(c,userRes,extendedPropertyRes,cashiers,outlets,products,categories,unitTypes);
            list.add(res);
        });
        return list;
    }

    @Override
    public void create(MerchantReq req) {
        Merchant create = new Merchant();
        create.setCreate(req);
        merchantRepository.save(create);
    }

    @Override
    public void delete(MerchantReq req) {
        var find = merchantRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            find.get().setStatus(Constants.DELETE_STATUS);
            merchantRepository.save(find.get());
        }
    }

    @Override
    public void update(MerchantReq req) {
        var find = merchantRepository.findById(req.getId());
        if(find.isPresent()){
            find.get().setUpdate(req);
            merchantRepository.save(find.get());
        }
    }

    @Override
    public MerchantRes findById(Integer id) {
        MerchantRes res = new MerchantRes();
        var find = merchantRepository.findById(id);
        if(find.isPresent()){
            Integer categories = categoryService.countCategoryByMerchantId(find.get().getId());
            Integer unitTypes = unitTypeService.countByMerchantIdAndStatus(find.get().getId());
            Integer products = productService.countByMerchantIdAndStatus(find.get().getId());
            ExtendedPropertyRes extendedPropertyRes = extendedPropertyService.findByKey(find.get().getCategoryKey());
            Integer cashiers = peopleService.countByMerchantIdAndStatus(find.get().getId());
            Integer outlets = outletService.countByMerchantIdAndStatus(find.get().getId());
            UserRes userRes = userService.findUserId(find.get().getHolderId());
            res.setDataRes(find.get(),userRes,extendedPropertyRes,cashiers,outlets,products,categories,unitTypes);
            return res;
        }
        return null;
    }
}

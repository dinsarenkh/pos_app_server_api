package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.req.ProductUnitReq;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.payload.res.ProductUnitRes;
import com.dinsaren.bbuappserver.service.ProductUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
@Slf4j
public class ProductUnitController {
    private final ProductUnitService productUnitService;
    private MessageRes resMessage;

    public ProductUnitController(ProductUnitService productUnitService) {
        this.productUnitService = productUnitService;
    }

    @GetMapping("/product/unit")
    public ResponseEntity<Object> getAll() {
        log.info("Intercept get all product unit");
        try {
            List<ProductUnitRes> list = productUnitService.findAll();
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all product error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/product/unit/product-id/{id}")
    public ResponseEntity<Object> getAllByProductId(@PathVariable("id") Integer id) {
        log.info("Intercept get all product unit by product Id");
        try {
            List<ProductUnitRes> list = productUnitService.findAllByProduct(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all product unit by product Id error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }


    @GetMapping("/product/unit/{id}")
    public ResponseEntity<Object> finByid(@PathVariable("id") Integer id) {
        log.info("Intercept get product unit by id {} ", id);
        try {
            ProductUnitRes res = productUnitService.findById(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get product unit by id error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/product/unit/create")
    public ResponseEntity<Object> create(@RequestBody ProductUnitReq req) {
        log.info("Intercept create product unit {} ", req);
        try {
            productUnitService.create(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While  create product unit  error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/product/unit/update")
    public ResponseEntity<Object> update(@RequestBody ProductUnitReq req) {
        log.info("Intercept update product unit {} ", req);
        try {
            productUnitService.update(req);
            resMessage = new MessageRes();
            resMessage.setUpdateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While update product unit error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/product/unit/delete")
    public ResponseEntity<Object> delete(@RequestBody ProductUnitReq req) {
        log.info("Intercept delete product unit {} ", req);
        try {
            productUnitService.update(req);
            resMessage = new MessageRes();
            resMessage.setDeleteMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While delete product unit error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

}

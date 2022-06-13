package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.req.ProductCreateReq;
import com.dinsaren.bbuappserver.payload.req.ProductUpdateReq;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.payload.res.ProductRes;
import com.dinsaren.bbuappserver.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
@Slf4j
public class ProductController {
    private final ProductService productService;
    private MessageRes resMessage;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<Object> getAll() {
        log.info("Intercept get all product");
        try {
            List<ProductRes> list = productService.findAll();
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While get all product error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> finByid(@PathVariable("id") Integer id) {
        log.info("Intercept get product by id {} ", id);
        try {
            ProductRes res = productService.findById(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While get product by id error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/product/create")
    public ResponseEntity<Object> create(@RequestBody ProductCreateReq req) {
        log.info("Intercept create product {} ", req);
        try {
            productService.create(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While create product error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/product/update")
    public ResponseEntity<Object> update(@RequestBody ProductUpdateReq req) {
        log.info("Intercept update product {} ", req);
        try {
            productService.update(req);
            resMessage = new MessageRes();
            resMessage.setUpdateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While update product error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/product/delete")
    public ResponseEntity<Object> delete(@RequestBody ProductUpdateReq req) {
        log.info("Intercept delete product {} ", req);
        try {
            productService.update(req);
            resMessage = new MessageRes();
            resMessage.setDeleteMessageSuccess();
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While delete product error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

}

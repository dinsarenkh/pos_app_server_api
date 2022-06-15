package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.req.CategoryReq;
import com.dinsaren.bbuappserver.payload.res.CategoryRes;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;
    private MessageRes resMessage;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public ResponseEntity<Object> getAllCategory() {
        log.info("Intercept get all category by id");
        try {
            List<CategoryRes> list = categoryService.findAll();
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While get all category by error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable("id") Integer id) {
        log.info("Intercept get category by id {} ", id);
        try {
            CategoryRes res = categoryService.findById(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While get category by error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/category/create")
    public ResponseEntity<Object> create(@RequestBody
												 CategoryReq req) {
        log.info("Intercept create category {} ", req);
        try {
            categoryService.create(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While create category error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/category/update")
    public ResponseEntity<Object> update(@RequestBody CategoryReq req) {
        log.info("Intercept update category {} ", req);
        try {
            categoryService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While update category error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/category/delete")
    public ResponseEntity<Object> delete(@RequestBody CategoryReq req) {
        log.info("Intercept delete category {} ", req);
        try {
            categoryService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.info("While delete category error ", e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

}

package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.services.CategoryService;
import com.dinsaren.bbuappserver.services.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/sub-category")
public class SubCategoryController {
    private final SubCategoryService categoryService;

    public SubCategoryController(SubCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list/{categoryId}")
    public ResponseEntity<Object> getAllSubCategoryByCategoryId(@PathVariable("categoryId") Integer categoryId){
        return new ResponseEntity<>(categoryService.findAll(categoryId), HttpStatus.OK);
    }
}

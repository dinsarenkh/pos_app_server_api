package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.services.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/brand")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/list/{subCategoryId}")
    public ResponseEntity<Object> getAllBySubCategoryId(@PathVariable("subCategoryId") Integer id){
        return new ResponseEntity<>(brandService.findAll(id), HttpStatus.OK);
    }
}

package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.services.ModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/list/{brandId}")
    public ResponseEntity<Object> getAllByBrandId(@PathVariable("brandId") Integer id){
        return new ResponseEntity<>(modelService.findAll(id), HttpStatus.OK);
    }
}

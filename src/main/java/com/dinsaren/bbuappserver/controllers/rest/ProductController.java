package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.response.MessageRes;
import com.dinsaren.bbuappserver.payload.response.ProductRes;
import com.dinsaren.bbuappserver.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/public/product")
    public ResponseEntity<?> getAllProduct() {
        List<ProductRes> list = service.findAll();
        return ResponseEntity.ok(new MessageRes("Get Data successful!", list));
    }

    @GetMapping("/public/product/{id}")
    public ResponseEntity<?> getProducyById(@PathVariable("id") Long id) {
        ProductRes res = service.findById(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", res));
    }

    @GetMapping("/public/product/category/{id}")
    public ResponseEntity<?> getProductByCategoryId(@PathVariable("id") Integer id) {
        List<ProductRes> res = service.findAllByCategoryId(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", res));
    }
}

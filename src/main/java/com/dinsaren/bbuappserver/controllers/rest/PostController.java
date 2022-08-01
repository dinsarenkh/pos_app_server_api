package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }
}

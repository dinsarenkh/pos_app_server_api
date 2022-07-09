package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.models.Branch;
import com.dinsaren.bbuappserver.payload.response.MessageRes;
import com.dinsaren.bbuappserver.service.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/app/branch")
    public ResponseEntity<?> getAllCategory() {
        List<Branch> list = branchService.findAll();
        return ResponseEntity.ok(new MessageRes("Get Data successful!", list));
    }

    @GetMapping("/app/branch/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id) {
        Branch res = branchService.findById(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", res));
    }

    @PostMapping("/app/branch/create")
    public ResponseEntity<?> create(@RequestBody Branch req) {
         branchService.create(req);
        return ResponseEntity.ok(new MessageRes("Create Data successful!", null));
    }

    @PostMapping("/app/branch/delete")
    public ResponseEntity<?> delete(@RequestBody Branch req) {
        branchService.delete(req);
        return ResponseEntity.ok(new MessageRes("Delete Data successful!", null));
    }

    @PostMapping("/app/branch/update")
    public ResponseEntity<?> update(@RequestBody Branch req) {
        branchService.update(req);
        return ResponseEntity.ok(new MessageRes("Update Data successful!", null));
    }

}

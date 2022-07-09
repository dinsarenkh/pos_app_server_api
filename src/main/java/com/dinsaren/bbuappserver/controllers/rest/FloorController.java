package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.models.Branch;
import com.dinsaren.bbuappserver.models.Floor;
import com.dinsaren.bbuappserver.payload.response.MessageRes;
import com.dinsaren.bbuappserver.service.BranchService;
import com.dinsaren.bbuappserver.service.FloorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FloorController {
    private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping("/app/floor")
    public ResponseEntity<?> getAll() {
        List<Floor> list = floorService.findAll();
        return ResponseEntity.ok(new MessageRes("Get Data successful!", list));
    }

    @GetMapping("/app/floor/branch/{id}")
    public ResponseEntity<?> getAllByBranchId(@PathVariable("id") Integer id) {
        List<Floor> list = floorService.findAllByBranchId(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", list));
    }

    @GetMapping("/app/floor/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Floor res = floorService.findById(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", res));
    }

    @PostMapping("/app/floor/create")
    public ResponseEntity<?> create(@RequestBody Floor req) {
         floorService.create(req);
        return ResponseEntity.ok(new MessageRes("Create Data successful!", null));
    }

    @PostMapping("/app/floor/delete")
    public ResponseEntity<?> delete(@RequestBody Floor req) {
        floorService.delete(req);
        return ResponseEntity.ok(new MessageRes("Delete Data successful!", null));
    }

    @PostMapping("/app/floor/update")
    public ResponseEntity<?> update(@RequestBody Floor req) {
        floorService.update(req);
        return ResponseEntity.ok(new MessageRes("Update Data successful!", null));
    }

}

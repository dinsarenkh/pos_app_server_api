package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.models.RoomType;
import com.dinsaren.bbuappserver.payload.response.MessageRes;
import com.dinsaren.bbuappserver.service.RoomTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/app/room-type")
    public ResponseEntity<?> getAllCategory() {
        List<RoomType> list = roomTypeService.findAll();
        return ResponseEntity.ok(new MessageRes("Get Data successful!", list));
    }

    @GetMapping("/app/room-type/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Integer id) {
        RoomType res = roomTypeService.findById(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", res));
    }

    @PostMapping("/app/room-type/create")
    public ResponseEntity<?> create(@RequestBody RoomType req) {
         roomTypeService.create(req);
        return ResponseEntity.ok(new MessageRes("Create Data successful!", null));
    }

    @PostMapping("/app/room-type/delete")
    public ResponseEntity<?> delete(@RequestBody RoomType req) {
        roomTypeService.delete(req);
        return ResponseEntity.ok(new MessageRes("Delete Data successful!", null));
    }

    @PostMapping("/app/room-type/update")
    public ResponseEntity<?> update(@RequestBody RoomType req) {
        roomTypeService.update(req);
        return ResponseEntity.ok(new MessageRes("Update Data successful!", null));
    }

}

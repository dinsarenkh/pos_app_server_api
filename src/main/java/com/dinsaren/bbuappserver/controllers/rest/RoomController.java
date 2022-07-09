package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.models.Room;
import com.dinsaren.bbuappserver.payload.response.MessageRes;
import com.dinsaren.bbuappserver.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/app/room")
    public ResponseEntity<?> getAll() {
        List<Room> list = roomService.findAll();
        return ResponseEntity.ok(new MessageRes("Get Data successful!", list));
    }

    @GetMapping("/app/room/floor/{id}")
    public ResponseEntity<?> getAllByFloorId(@PathVariable("id") Integer id) {
        List<Room> list = roomService.findAllByFloorId(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", list));
    }

    @GetMapping("/app/room/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Room res = roomService.findById(id);
        return ResponseEntity.ok(new MessageRes("Get Data successful!", res));
    }

    @PostMapping("/app/room/create")
    public ResponseEntity<?> create(@RequestBody Room req) {
         roomService.create(req);
        return ResponseEntity.ok(new MessageRes("Create Data successful!", null));
    }

    @PostMapping("/app/room/delete")
    public ResponseEntity<?> delete(@RequestBody Room req) {
        roomService.delete(req);
        return ResponseEntity.ok(new MessageRes("Delete Data successful!", null));
    }

    @PostMapping("/app/room/update")
    public ResponseEntity<?> update(@RequestBody Room req) {
        roomService.update(req);
        return ResponseEntity.ok(new MessageRes("Update Data successful!", null));
    }

}

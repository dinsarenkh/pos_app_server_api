package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;
import com.dinsaren.bbuappserver.service.UnitTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
@Slf4j
public class UnitTypeController {
    private final UnitTypeService unitTypeService;
    private MessageRes resMessage;

    public UnitTypeController(UnitTypeService unitTypeService) {
        this.unitTypeService = unitTypeService;
    }

    @GetMapping("/unit")
    public ResponseEntity<Object> getAll() {
        log.info("Intercept get all unit type by id");
        try {
            List<UnitTypeRes> list = unitTypeService.findAll();
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all unit type by error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/unit/{id}")
    public ResponseEntity<Object> finByid(@PathVariable("id") Integer id) {
        log.info("Intercept get unit by id {} ", id);
        try {
            UnitTypeRes res = unitTypeService.findById(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get unit by error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/unit/create")
    public ResponseEntity<Object> create(@RequestBody UnitTypeCreateReq req) {
        log.info("Intercept create unit {} ", req);
        try {
            unitTypeService.create(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While create unit error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/unit/update")
    public ResponseEntity<Object> update(@RequestBody UnitTypeCreateReq req) {
        log.info("Intercept update unit {} ", req);
        try {
            unitTypeService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While update unit error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/unit/delete")
    public ResponseEntity<Object> delete(@RequestBody UnitTypeCreateReq req) {
        log.info("Intercept delete unit {} ", req);
        try {
            unitTypeService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While delete unit error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

}

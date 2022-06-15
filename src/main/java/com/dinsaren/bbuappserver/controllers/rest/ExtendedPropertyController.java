package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.req.ExtendedPropertyReq;
import com.dinsaren.bbuappserver.payload.res.ExtendedPropertyRes;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.service.ExtendedPropertyService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
@Slf4j
public class ExtendedPropertyController {
    private final ExtendedPropertyService extendedPropertyService;
    private MessageRes resMessage;

    public ExtendedPropertyController(ExtendedPropertyService extendedPropertyService) {
        this.extendedPropertyService = extendedPropertyService;
    }

    @GetMapping("/extended-properties")
    public ResponseEntity<Object> getAll() {
        log.info("Intercept get all extended properties");
        try {
            List<ExtendedPropertyRes> list = extendedPropertyService.findAll();
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all all extended properties error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/extended-properties/code/{code}")
    public ResponseEntity<Object> getAllByCode(@PathVariable("code") String code) {
        log.info("Intercept get all extended properties by code  {}", code);
        try {
            List<ExtendedPropertyRes> list = extendedPropertyService.findAllByCode(code);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all extended properties by code error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/extended-properties/{id}")
    public ResponseEntity<Object> finById(@PathVariable("id") Integer id) {
        log.info("Intercept get  extended properties by id {} ", id);
        try {
            ExtendedPropertyRes res = extendedPropertyService.findById(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get extended properties by id error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/extended-properties/key/{key}")
    public ResponseEntity<Object> finByKey(@PathVariable("key") String key) {
        log.info("Intercept get extended properties by key {} ", key);
        try {
            ExtendedPropertyRes res = extendedPropertyService.findByKey(key);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get extended properties by error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/extended-properties/create")
    public ResponseEntity<Object> create(@RequestBody ExtendedPropertyReq req) {
        log.info("Intercept create  extended properties {} ", req);
        try {
            extendedPropertyService.create(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While create  extended properties error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/extended-properties/update")
    public ResponseEntity<Object> update(@RequestBody ExtendedPropertyReq req) {
        log.info("Intercept update extended properties {} ", req);
        try {
            extendedPropertyService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While update extended properties error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/extended-properties/delete")
    public ResponseEntity<Object> delete(@RequestBody ExtendedPropertyReq req) {
        log.info("Intercept delete extended properties {} ", req);
        try {
            extendedPropertyService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While delete extended properties error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

}

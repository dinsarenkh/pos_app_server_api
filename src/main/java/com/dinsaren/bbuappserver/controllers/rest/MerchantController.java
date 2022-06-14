package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.req.MerchantReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeCreateReq;
import com.dinsaren.bbuappserver.payload.req.UnitTypeUpdateReq;
import com.dinsaren.bbuappserver.payload.res.MerchantRes;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.payload.res.UnitTypeRes;
import com.dinsaren.bbuappserver.service.MerchantService;
import com.dinsaren.bbuappserver.service.UnitTypeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
@Slf4j
public class MerchantController {
    private final MerchantService merchantService;
    private MessageRes resMessage;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("/merchant")
    public ResponseEntity<Object> getAll() {
        log.info("Intercept get all merchant");
        try {
            List<MerchantRes> list = merchantService.findAll();
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all merchant error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/merchant/{id}")
    public ResponseEntity<Object> finById(@PathVariable("id") Integer id) {
        log.info("Intercept get merchant by id {} ", id);
        try {
            MerchantRes res = merchantService.findById(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get merchant by error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/merchant/create")
    public ResponseEntity<Object> create(@RequestBody MerchantReq req) {
        log.info("Intercept create merchant {} ", req);
        try {
            merchantService.create(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While create merchant error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/merchant/update")
    public ResponseEntity<Object> update(@RequestBody MerchantReq req) {
        log.info("Intercept update merchant {} ", req);
        try {
            merchantService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While update merchant error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/merchant/delete")
    public ResponseEntity<Object> delete(@RequestBody MerchantReq req) {
        log.info("Intercept delete merchant {} ", req);
        try {
            merchantService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While delete merchant error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

}

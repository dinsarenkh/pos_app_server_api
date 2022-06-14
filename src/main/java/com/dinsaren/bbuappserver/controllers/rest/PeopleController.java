package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.payload.req.PeopleReq;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.payload.res.PeopleRes;
import com.dinsaren.bbuappserver.service.PeopleService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
@Slf4j
public class PeopleController {
    private final PeopleService peopleTypeService;
    private MessageRes resMessage;

    public PeopleController(PeopleService peopleTypeService) {
        this.peopleTypeService = peopleTypeService;
    }

    @GetMapping("/people")
    public ResponseEntity<Object> getAll() {
        log.info("Intercept get all people");
        try {
            List<PeopleRes> list = peopleTypeService.findAll();
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all people error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }
    @GetMapping("/people/type/{type}")
    public ResponseEntity<Object> getAllByType(@PathVariable("type") String type) {
        log.info("Intercept get all people by type");
        try {
            List<PeopleRes> list = peopleTypeService.findAllByType(type);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(list);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get all people by type error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Object> finById(@PathVariable("id") Integer id) {
        log.info("Intercept get people by id {} ", id);
        try {
            PeopleRes res = peopleTypeService.findById(id);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While get people by error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/people/create")
    public ResponseEntity<Object> create(@RequestBody
                                                 PeopleReq req) {
        log.info("Intercept create people {} ", req);
        try {
            peopleTypeService.create(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While create people error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

    @PostMapping("/people/update")
    public ResponseEntity<Object> update(@RequestBody PeopleReq req) {
        log.info("Intercept update people {} ", req);
        try {
            peopleTypeService.update(req);
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

    @PostMapping("/people/delete")
    public ResponseEntity<Object> delete(@RequestBody PeopleReq req) {
        log.info("Intercept delete people {} ", req);
        try {
            peopleTypeService.update(req);
            resMessage = new MessageRes();
            resMessage.setCreateMessageSuccess();
            return ResponseEntity.ok(resMessage);
        }catch (Exception e){
            log.info("While delete people error ",e);
            resMessage = new MessageRes();
            resMessage.setServerError();
            return ResponseEntity.ok(resMessage);
        }
    }

}

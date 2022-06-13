package com.dinsaren.bbuappserver.controllers.rest;

import com.dinsaren.bbuappserver.models.FileImageDetail;
import com.dinsaren.bbuappserver.payload.res.MessageRes;
import com.dinsaren.bbuappserver.payload.res.UploadImageRes;
import com.dinsaren.bbuappserver.service.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Slf4j
@RestController
@RequestMapping("/api")
public class UploadFileController {
    private final UploadFileService uploadFileService;
    private MessageRes resMessage;

    public UploadFileController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping(value = "/app/v1/upload-file/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Object>  uploadFile(
            @RequestParam("File") MultipartFile file) {
        log.debug("Intercept upload file req {}", file.toString());
        try {
            UploadImageRes res = uploadFileService.uploadFile(file);
            resMessage = new MessageRes();
            resMessage.setGetDateMessageSuccess(res);
            return ResponseEntity.ok(resMessage);
        } catch (Exception e) {
            log.error("Error while get all category {}", e.getMessage());
            return null;
        }
    }

    @GetMapping(value = "/public/v1/view-image",
            produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public ResponseEntity<byte[]> getImageById(
            @RequestParam("filename") String filename) {
        log.debug("Intercept view image file by filename : {}", filename);

        try {
            FileImageDetail detail = uploadFileService.findImageByFileName(filename);
            if (detail == null) {
                return null;
            }
            String path = detail.getFilePath();
            File file = new File(path);
            return ResponseEntity.ok(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            log.error("Errors while view image", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

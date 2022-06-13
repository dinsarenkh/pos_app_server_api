package com.dinsaren.bbuappserver.service;

import com.dinsaren.bbuappserver.models.FileImageDetail;
import com.dinsaren.bbuappserver.payload.res.UploadImageRes;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    UploadImageRes uploadFile(MultipartFile files);
    FileImageDetail findImageByFileName(String fileName);
}

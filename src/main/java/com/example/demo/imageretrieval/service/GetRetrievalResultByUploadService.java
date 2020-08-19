package com.example.demo.imageretrieval.service;

import com.example.demo.imageretrieval.entity.RetrievalResultInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface GetRetrievalResultByUploadService {
    void setFile(MultipartFile file);

    RetrievalResultInfo getRetrievalResultInfo();

    ResponseEntity<byte[]> getImg(String imgName) throws FileNotFoundException;
}

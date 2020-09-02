package com.example.demo.imageretrieval.service;

import com.example.demo.imageretrieval.entity.RetrievalResultInfo;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;

public interface GetRetrievalResultByUploadService {
    RetrievalResultInfo getRetrievalResultInfo(String hashcode, String origincode);

    ResponseEntity<byte[]> getImg(String imgName) throws FileNotFoundException;
}

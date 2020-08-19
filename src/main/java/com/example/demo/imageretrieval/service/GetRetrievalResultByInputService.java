package com.example.demo.imageretrieval.service;

import com.example.demo.imageretrieval.entity.ImageInfo;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.List;

public interface GetRetrievalResultByInputService {
    List<ImageInfo> getImgInfoList();
    ResponseEntity<byte[]> getImg() throws FileNotFoundException;
}

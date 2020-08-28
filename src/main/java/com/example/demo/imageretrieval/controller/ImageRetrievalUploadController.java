package com.example.demo.imageretrieval.controller;

import com.example.demo.imageretrieval.entity.RetrievalResultInfo;
import com.example.demo.imageretrieval.service.GetRetrievalResultByUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@CrossOrigin()
public class ImageRetrievalUploadController {
    private final GetRetrievalResultByUploadService getRetrievalResultByUploadService;

    @Autowired
    public ImageRetrievalUploadController(GetRetrievalResultByUploadService getRetrievalResultByUploadService) {
        this.getRetrievalResultByUploadService = getRetrievalResultByUploadService;
    }

    @GetMapping("/get-result-info")
    public RetrievalResultInfo handleImageRetrievalUpload(@RequestParam("hashcode") String hashcode) {
        return getRetrievalResultByUploadService.getRetrievalResultInfo(hashcode);
    }

    @GetMapping("/get-result-image")
    public ResponseEntity<byte[]> handleGetImage(@RequestParam(value = "imageName") String imageName) throws FileNotFoundException {
        return getRetrievalResultByUploadService.getImg(imageName);
    }
}

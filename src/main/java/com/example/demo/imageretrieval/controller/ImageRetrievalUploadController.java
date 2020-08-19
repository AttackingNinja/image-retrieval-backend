package com.example.demo.imageretrieval.controller;

import com.example.demo.imageretrieval.entity.RetrievalResultInfo;
import com.example.demo.imageretrieval.service.GetRetrievalResultByUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@CrossOrigin()
public class ImageRetrievalUploadController {
    private final GetRetrievalResultByUploadService getRetrievalResultByUploadService;

    @Autowired
    public ImageRetrievalUploadController(GetRetrievalResultByUploadService getRetrievalResultByUploadService) {
        this.getRetrievalResultByUploadService = getRetrievalResultByUploadService;
    }

    @PostMapping("/image-retrieval-upload")
    public RetrievalResultInfo handleImageRetrievalUpload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        getRetrievalResultByUploadService.setFile(file);
        return getRetrievalResultByUploadService.getRetrievalResultInfo();
    }

    @GetMapping("/image-retrieval-upload")
    public ResponseEntity<byte[]> handleGetImage(@RequestParam(value = "imageName") String imageName) throws FileNotFoundException {
        return getRetrievalResultByUploadService.getImg(imageName);
    }
}

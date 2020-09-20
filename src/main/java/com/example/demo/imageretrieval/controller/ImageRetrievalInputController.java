package com.example.demo.imageretrieval.controller;

import com.example.demo.imageretrieval.entity.ImageInfo;
import com.example.demo.imageretrieval.service.ImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin()
public class ImageRetrievalInputController {
    private ImageInfoService imageInfoService;

    @Autowired
    public ImageRetrievalInputController(ImageInfoService imageInfoService) {
        this.imageInfoService = imageInfoService;
    }

    @GetMapping("/image-retrieval-input")
    public List<ImageInfo> handleImageRetrievalInput(@RequestParam(value = "searchValue") String searchValue) {
        switch (searchValue) {
            case "图纸":
                return imageInfoService.getDrawingImageInfoList();
            case "人员":
                return imageInfoService.getPeopleImageInfoList();
            case "概念图":
                return imageInfoService.getConceptImageInfoList();
        }
        return null;
    }
}

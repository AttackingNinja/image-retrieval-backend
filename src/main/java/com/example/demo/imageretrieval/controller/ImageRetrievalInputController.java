package com.example.demo.imageretrieval.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class ImageRetrievalInputController {
    @GetMapping("/image-retrieval-input")
    public String handleImageRetrievalInput(@RequestParam(value = "searchValue") String searchValue) {
        return searchValue;
    }
}

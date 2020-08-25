package com.example.demo.imageretrieval.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin()
public class ImageRetrievalInputController {
    @GetMapping("/image-retrieval-input")
    public String handleImageRetrievalInput(@RequestParam(value = "searchValue") String searchValue) {
        String url = "http://127.0.0.1:9001/test";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(url, null, String.class).getBody();
    }
}

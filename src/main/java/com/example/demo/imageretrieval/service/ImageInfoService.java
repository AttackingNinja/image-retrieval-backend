package com.example.demo.imageretrieval.service;

import com.example.demo.imageretrieval.entity.CodeInfo;
import com.example.demo.imageretrieval.entity.ImageInfo;

import java.util.List;

public interface ImageInfoService {
    List<ImageInfo> getImageInfoList(int id);

    List<String> getDistinctSubcode1();

    List<String> getDistinctSubcode2();

    List<String> getDistinctSubcode3();

    List<String> getDistinctSubcode4();

    List<String> getDistinctSubcode5();

    List<String> getDistinctSubcode6();

    List<CodeInfo> getCodeInfo1(String targetSubcode);

    List<CodeInfo> getCodeInfo2(String targetSubcode);

    List<CodeInfo> getCodeInfo3(String targetSubcode);

    List<CodeInfo> getCodeInfo4(String targetSubcode);

    List<CodeInfo> getCodeInfo5(String targetSubcode);

    List<CodeInfo> getCodeInfo6(String targetSubcode);
}

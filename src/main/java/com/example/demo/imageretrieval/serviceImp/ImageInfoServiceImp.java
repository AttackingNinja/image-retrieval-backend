package com.example.demo.imageretrieval.serviceImp;

import com.example.demo.imageretrieval.dao.ImageInfoMapper;
import com.example.demo.imageretrieval.entity.CodeInfo;
import com.example.demo.imageretrieval.entity.ImageInfo;
import com.example.demo.imageretrieval.service.ImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageInfoServiceImp implements ImageInfoService {
    private ImageInfoMapper imageInfoMapper;

    @Autowired
    public ImageInfoServiceImp(ImageInfoMapper imageInfoMapper) {
        this.imageInfoMapper = imageInfoMapper;
    }

    @Override
    public List<ImageInfo> getImageInfoList(int id) {
        return imageInfoMapper.getImageInfoList(id);
    }

    @Override
    public List<String> getDistinctSubcode1() {
        return imageInfoMapper.getDistinctSubcode1();
    }

    @Override
    public List<String> getDistinctSubcode2() {
        return imageInfoMapper.getDistinctSubcode2();
    }

    @Override
    public List<String> getDistinctSubcode3() {
        return imageInfoMapper.getDistinctSubcode3();
    }

    @Override
    public List<String> getDistinctSubcode4() {
        return imageInfoMapper.getDistinctSubcode4();
    }

    @Override
    public List<String> getDistinctSubcode5() {
        return imageInfoMapper.getDistinctSubcode5();
    }

    @Override
    public List<String> getDistinctSubcode6() {
        return imageInfoMapper.getDistinctSubcode6();
    }

    @Override
    public List<CodeInfo> getCodeInfo1(String targetSubcode) {
        return imageInfoMapper.getCodeInfo1(targetSubcode);
    }

    @Override
    public List<CodeInfo> getCodeInfo2(String targetSubcode) {
        return imageInfoMapper.getCodeInfo2(targetSubcode);
    }

    @Override
    public List<CodeInfo> getCodeInfo3(String targetSubcode) {
        return imageInfoMapper.getCodeInfo3(targetSubcode);
    }

    @Override
    public List<CodeInfo> getCodeInfo4(String targetSubcode) {
        return imageInfoMapper.getCodeInfo4(targetSubcode);
    }

    @Override
    public List<CodeInfo> getCodeInfo5(String targetSubcode) {
        return imageInfoMapper.getCodeInfo5(targetSubcode);
    }

    @Override
    public List<CodeInfo> getCodeInfo6(String targetSubcode) {
        return imageInfoMapper.getCodeInfo6(targetSubcode);
    }
}

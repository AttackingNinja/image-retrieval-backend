package com.example.demo.imageretrieval.serviceImp;

import com.example.demo.imageretrieval.dao.ImageInfoMapper;
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
    public List<ImageInfo> getImageInfoList() {
        List<ImageInfo> imageInfos = imageInfoMapper.getImageInfoList();
        return imageInfos;
    }
}

package com.example.demo.imageretrieval.dao;

import com.example.demo.imageretrieval.entity.ImageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ImageInfoMapper {

    @Select("select * from image_info order by id asc")
    List<ImageInfo> getImageInfoList();
}


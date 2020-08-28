package com.example.demo.imageretrieval.dao;

import com.example.demo.imageretrieval.entity.CodeInfo;
import com.example.demo.imageretrieval.entity.ImageInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ImageInfoMapper {

    @Select("select * from image_info where id = #{id}")
    List<ImageInfo> getImageInfoList(int id);

    @Select("select distinct subcode1 from image.image_code")
    List<String> getDistinctSubcode1();

    @Select("select distinct subcode2 from image.image_code")
    List<String> getDistinctSubcode2();

    @Select("select distinct subcode3 from image.image_code")
    List<String> getDistinctSubcode3();

    @Select("select distinct subcode4 from image.image_code")
    List<String> getDistinctSubcode4();

    @Select("select distinct subcode5 from image.image_code")
    List<String> getDistinctSubcode5();

    @Select("select distinct subcode6 from image.image_code")
    List<String> getDistinctSubcode6();

    @Select("select id, hashcode from image.image_code where subcode1 = #{targetSubcode}")
    List<CodeInfo> getCodeInfo1(String targetSubcode);

    @Select("select id, hashcode from image.image_code where subcode2 = #{targetSubcode}")
    List<CodeInfo> getCodeInfo2(String targetSubcode);

    @Select("select id, hashcode from image.image_code where subcode3 = #{targetSubcode}")
    List<CodeInfo> getCodeInfo3(String targetSubcode);

    @Select("select id, hashcode from image.image_code where subcode4 = #{targetSubcode}")
    List<CodeInfo> getCodeInfo4(String targetSubcode);

    @Select("select id, hashcode from image.image_code where subcode5 = #{targetSubcode}")
    List<CodeInfo> getCodeInfo5(String targetSubcode);

    @Select("select id, hashcode from image.image_code where subcode6 = #{targetSubcode}")
    List<CodeInfo> getCodeInfo6(String targetSubcode);
}


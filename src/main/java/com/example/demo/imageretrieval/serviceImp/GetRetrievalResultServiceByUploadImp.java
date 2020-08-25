package com.example.demo.imageretrieval.serviceImp;

import com.example.demo.imageretrieval.entity.RetrievalResultInfo;
import com.example.demo.imageretrieval.service.GetRetrievalResultByUploadService;
import com.example.demo.imageretrieval.service.ImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetRetrievalResultServiceByUploadImp implements GetRetrievalResultByUploadService {
    private MultipartFile file;
    private ImageInfoService imageInfoService;

    @Autowired
    public GetRetrievalResultServiceByUploadImp(ImageInfoService imageInfoService) {
        this.imageInfoService = imageInfoService;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private byte[] getBytesByStream(InputStream inputStream) {
        byte[] bytes = new byte[1024];
        int b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            while ((b = inputStream.read(bytes)) != -1) {

                byteArrayOutputStream.write(bytes, 0, b);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RetrievalResultInfo getRetrievalResultInfo() {
        RetrievalResultInfo retrievalResultInfo = new RetrievalResultInfo();
        List<String> tagInfos = new ArrayList<>();
        tagInfos.add("施工现场");
        tagInfos.add("人员");
//        tagInfos.add("测试3");
        retrievalResultInfo.setImageInfos(imageInfoService.getImageInfoList());
        retrievalResultInfo.setTagInfos(tagInfos);
        return retrievalResultInfo;
    }

    @Override
    public ResponseEntity<byte[]> getImg(String imgName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("D:\\PyCharm-workspace\\RetrievalTest\\result\\result-ADCH-Project-20-08-24-11-16-40\\9ZPDAVYEO42_IMG_8542\\" + imgName));
        byte[] bytesByStream = getBytesByStream(inputStream);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(bytesByStream, headers, HttpStatus.OK);
    }
}

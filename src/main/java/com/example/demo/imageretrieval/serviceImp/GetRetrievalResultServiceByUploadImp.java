package com.example.demo.imageretrieval.serviceImp;

import com.example.demo.imageretrieval.entity.RetrievalResultInfo;
import com.example.demo.imageretrieval.service.GetRetrievalResultByUploadService;
import com.example.demo.imageretrieval.entity.ImageInfo;
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
        List<ImageInfo> imageInfos = new ArrayList<>();
        List<String> tagInfos = new ArrayList<>();
        File directory = new File("D:\\workspace\\image-retrieval-backend\\src\\main\\resources\\static\\images");
        String[] fileList = directory.list();
        for (int i = 0; i < fileList.length; i++) {
            ImageInfo imageInfo = new ImageInfo();
            imageInfo.setId(i);
            imageInfo.setImageName(fileList[i]);
            imageInfos.add(imageInfo);
        }
        tagInfos.add("测试1");
        tagInfos.add("测试2");
        tagInfos.add("测试3");
        retrievalResultInfo.setImageInfos(imageInfos);
        retrievalResultInfo.setTagInfos(tagInfos);
        return retrievalResultInfo;
    }

    @Override
    public ResponseEntity<byte[]> getImg(String imgName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("D:\\workspace\\image-retrieval-backend\\src\\main\\resources\\static\\images\\" + imgName));
        byte[] bytesByStream = getBytesByStream(inputStream);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(bytesByStream, headers, HttpStatus.OK);
    }
}

package com.example.demo.imageretrieval.serviceImp;

import com.example.demo.imageretrieval.entity.CodeInfo;
import com.example.demo.imageretrieval.entity.ImageInfo;
import com.example.demo.imageretrieval.entity.RetrievalResultInfo;
import com.example.demo.imageretrieval.service.GetRetrievalResultByUploadService;
import com.example.demo.imageretrieval.service.ImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class GetRetrievalResultServiceByUploadImp implements GetRetrievalResultByUploadService {
    private ImageInfoService imageInfoService;

    @Autowired
    public GetRetrievalResultServiceByUploadImp(ImageInfoService imageInfoService) {
        this.imageInfoService = imageInfoService;
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

    private int calcHammingDistance(String subcode1, String subcode2) {
        int subcodeInt1 = Integer.parseInt(subcode1, 2);
        int subcodeInt2 = Integer.parseInt(subcode2, 2);
        return Integer.bitCount(subcodeInt1 ^ subcodeInt2);
    }

    private double calcEuclidDistance(String origincode1, String origincode2) {
        String[] continuousBits1S = origincode1.split(",");
        String[] continuousBits2S = origincode2.split(" ");
        double squareSum = 0.0;
        for (int i = 0; i < 48; i++) {
            double param1 = Double.parseDouble(continuousBits1S[i]);
            double param2 = Double.parseDouble(continuousBits2S[i]);
            squareSum += Math.pow(param1 - param2, 2.0);
        }
        return Math.sqrt(squareSum);
    }

    @Override
    public RetrievalResultInfo getRetrievalResultInfo(String hashcode, String origincode) {
        List<List<String>> subcodes = new ArrayList<>();
        List<List<String>> targetSubcodes = new ArrayList<>();
        subcodes.add(imageInfoService.getDistinctSubcode1());
        subcodes.add(imageInfoService.getDistinctSubcode2());
        subcodes.add(imageInfoService.getDistinctSubcode3());
        subcodes.add(imageInfoService.getDistinctSubcode4());
        subcodes.add(imageInfoService.getDistinctSubcode5());
        subcodes.add(imageInfoService.getDistinctSubcode6());
        for (int i = 0; i < 6; i++) {
            String subHashcode = hashcode.substring(i * 8, i * 8 + 8);
            List<String> curTargetSubcodes = new ArrayList<>();
            for (int j = 0; j < subcodes.get(i).size(); j++) {
                int hammingDist = calcHammingDistance(subHashcode, subcodes.get(i).get(j));
                if (hammingDist <= 1) {
                    curTargetSubcodes.add(subcodes.get(i).get(j));
                }
            }
            targetSubcodes.add(curTargetSubcodes);
        }
        LinkedHashSet<Integer> resultSet = new LinkedHashSet<>();
        HashSet<CodeInfo> candidateSet = new HashSet<>();
        List<List<Double>> tempSet = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < targetSubcodes.get(i).size(); j++) {
                List<CodeInfo> curResult = null;
                switch (i) {
                    case 0:
                        curResult = imageInfoService.getCodeInfo1(targetSubcodes.get(i).get(j));
                        break;
                    case 1:
                        curResult = imageInfoService.getCodeInfo2(targetSubcodes.get(i).get(j));
                        break;
                    case 2:
                        curResult = imageInfoService.getCodeInfo3(targetSubcodes.get(i).get(j));
                        break;
                    case 3:
                        curResult = imageInfoService.getCodeInfo4(targetSubcodes.get(i).get(j));
                        break;
                    case 4:
                        curResult = imageInfoService.getCodeInfo5(targetSubcodes.get(i).get(j));
                        break;
                    case 5:
                        curResult = imageInfoService.getCodeInfo6(targetSubcodes.get(i).get(j));
                        break;
                }
                for (CodeInfo codeInfo : curResult) {
                    int hammingDist = calcHammingDistance(hashcode.substring(0, 24), codeInfo.getHashcode().substring(0, 24))
                            + calcHammingDistance(hashcode.substring(24, 48), codeInfo.getHashcode().substring(24, 48));
                    codeInfo.setHammingDiastance(hammingDist);
                    if(hammingDist<=2){
                        candidateSet.add(codeInfo);
                    }
                }
            }
        }
        for (CodeInfo codeInfo : candidateSet) {
            String targetOrigincode = codeInfo.getOrigincode();
            double euclidDist = calcEuclidDistance(origincode, targetOrigincode);
            List<Double> list = new ArrayList<>();
            list.add((double) codeInfo.getId());
            list.add(euclidDist);
            tempSet.add(list);
        }
        tempSet.sort(Comparator.comparingDouble(o -> o.get(1)));
        for (List<Double> list : tempSet) {
            resultSet.add((int) Math.floor(list.get(0)));
        }
        List<ImageInfo> imageInfoList = new ArrayList<>();
        for (int id : resultSet) {
            imageInfoList.addAll(imageInfoService.getImageInfoList(id));
        }
        RetrievalResultInfo retrievalResultInfo = new RetrievalResultInfo();
        List<String> tagInfos = new ArrayList<>();
        tagInfos.add("施工现场");
        tagInfos.add("人员");
//        tagInfos.add("测试3");
        retrievalResultInfo.setImageInfos(imageInfoList);
        retrievalResultInfo.setTagInfos(tagInfos);
        return retrievalResultInfo;
    }

    @Override
    public ResponseEntity<byte[]> getImg(String imgName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("D:\\PyCharm-workspace\\RetrievalTest\\data\\Project\\images\\" + imgName));
        byte[] bytesByStream = getBytesByStream(inputStream);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(bytesByStream, headers, HttpStatus.OK);
    }
}

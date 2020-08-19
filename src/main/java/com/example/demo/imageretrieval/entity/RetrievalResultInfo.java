package com.example.demo.imageretrieval.entity;

import java.util.List;

public class RetrievalResultInfo {
    private List<ImageInfo> imageInfos;
    private List<String> tagInfos;

    public List<ImageInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }

    public List<String> getTagInfos() {
        return tagInfos;
    }

    public void setTagInfos(List<String> tagInfos) {
        this.tagInfos = tagInfos;
    }
}

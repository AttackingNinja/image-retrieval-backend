package com.example.demo.imageretrieval.entity;

import java.util.Objects;

public class CodeInfo {
    private int id;
    private String hashcode;
    private String origincode;
    private int hammingDiastance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getOrigincode() {
        return origincode;
    }

    public void setOrigincode(String origincode) {
        this.origincode = origincode;
    }

    public int getHammingDiastance() {
        return hammingDiastance;
    }

    public void setHammingDiastance(int hammingDiastance) {
        this.hammingDiastance = hammingDiastance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeInfo codeInfo = (CodeInfo) o;
        return id == codeInfo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

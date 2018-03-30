package com.computerdesign.whutHouseMgmt.bean.authority;

public class Qiniu {
    private String accessKey;

    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey == null ? null : accessKey.trim();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }
}
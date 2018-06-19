package com.computerdesign.whutHouseMgmt.bean.login;

public class WXLogin {
    private String appid;

    private String secret;

    private String grant_type;

    private String jscode;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type == null ? null : grant_type.trim();
    }

    public String getJscode() {
        return jscode;
    }

    public void setJscode(String jscode) {
        this.jscode = jscode == null ? null : jscode.trim();
    }
}
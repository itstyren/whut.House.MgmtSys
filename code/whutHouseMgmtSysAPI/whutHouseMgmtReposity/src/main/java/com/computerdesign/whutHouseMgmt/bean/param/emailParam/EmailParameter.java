package com.computerdesign.whutHouseMgmt.bean.param.emailParam;

public class EmailParameter {
    private String host;

    private String port;

    private String userName;

    private String password;

    private String fromAddress;

    private String pertainContent;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress == null ? null : fromAddress.trim();
    }

    public String getPertainContent() {
        return pertainContent;
    }

    public void setPertainContent(String pertainContent) {
        this.pertainContent = pertainContent == null ? null : pertainContent.trim();
    }
}
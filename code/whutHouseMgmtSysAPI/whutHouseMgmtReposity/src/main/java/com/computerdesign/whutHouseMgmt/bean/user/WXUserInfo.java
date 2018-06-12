package com.computerdesign.whutHouseMgmt.bean.user;
/**
 *
 * @author wanhaoran
 * @date 2018年6月12日 下午11:26:03
 * 
 */
public class WXUserInfo {

	
	String encryptedData;
	
	String iv;
	
	String sessionKey;

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	
	
	
}

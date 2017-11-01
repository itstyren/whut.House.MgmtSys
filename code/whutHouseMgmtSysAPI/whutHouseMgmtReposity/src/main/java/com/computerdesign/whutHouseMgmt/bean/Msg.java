package com.computerdesign.whutHouseMgmt.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回类,用于json
 * 
 * @author Administrator
 *
 */
public class Msg {

	// 状态码 假设100表示成功，200表示失败
	private String status;

	private String message;

	// 用户要返回给浏览器的数据
	private Map<String, Object> data = new HashMap<String, Object>();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	// 处理成功
	public static Msg success() {
		Msg result = new Msg();
		result.setStatus("success");
		result.setMessage("处理成功");
		return result;
	}

	// 自定义message,处理成功
	public static Msg success(String message) {
		Msg result = new Msg();
		result.setStatus("success");
		result.setMessage(message);
		return result;
	}

	// 处理失败
	public static Msg error() {
		Msg result = new Msg();
		result.setStatus("error");
		result.setMessage("处理失败");
		return result;
	}

	// 自定义message,处理失败
	public static Msg error(String message) {
		Msg result = new Msg();
		result.setStatus("error");
		result.setMessage(message);
		return result;
	}

	// 添加需要返回的数据，便于封装
	public Msg add(String key, Object value) {
		this.getData().put(key, value);
		return this;
	}

}

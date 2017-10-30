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
	private int code;

	private String message;

	// 用户要返回给浏览器的数据
	private Map<String, Object> data = new HashMap<String, Object>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
		result.setCode(100);
		result.setMessage("处理成功");
		return result;
	}

	// 自定义message,处理成功
	public static Msg success(String message) {
		Msg result = new Msg();
		result.setCode(100);
		result.setMessage(message);
		return result;
	}

	// 处理失败
	public static Msg error() {
		Msg result = new Msg();
		result.setCode(200);
		result.setMessage("处理失败");
		return result;
	}

	// 自定义message,处理失败
	public static Msg error(String message) {
		Msg result = new Msg();
		result.setCode(200);
		result.setMessage(message);
		return result;
	}

	// 添加需要返回的数据，便于封装
	public Msg add(String key, Object value) {
		this.getData().put(key, value);
		return this;
	}

}

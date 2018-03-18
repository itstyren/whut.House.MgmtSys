package com.computerdesign.whutHouseMgmt.test;

import java.util.HashMap;
import java.util.Map;

import com.computerdesign.whutHouseMgmt.core.DocumentHandler;

/**
 *
 * @author wanhaoran
 * @date 2018年3月18日 下午3:31:21
 * 
 */
public class GenerateWordTest {

	public static void main(String[] args) throws Exception {
		DocumentHandler documentHandler = new DocumentHandler();

		String outFilePath = "C:/Users/wanhaoran/Desktop/test.doc";
		String fileName = "申请租赁住房表格.ftl";

		Map<String, Object> map = new HashMap<>();
		map.put("name", "万浩然");
		map.put("sex", "万浩然");
		map.put("marriage", "万浩然");
		documentHandler.createDocArea(map, outFilePath, fileName);

	}
	// DocumentHandler documentHandler = new DocumentHandler();
	//
	// String outFilePath = "D://";
	// String fileName = "test";
	//
	// public String GenerageWord() throws Exception {
	// Map<String, Object> map = new HashMap<>();
	// map.put("${name}", "万浩然");
	// map.put("${sex}", "万浩然");
	// map.put("${marriage}", "万浩然");
	// documentHandler.createDocArea(map, outFilePath, fileName);
	// return "22";
	// }
}

package com.computerdesign.whutHouseMgmt.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

public class DownloadUtils {
	public static void downloadSolve(String excelFileName, String fileName, HttpServletResponse response) throws IOException {
		//通知浏览器是个下载的文件 
		response.setContentType("application/x-msdownload");

		//通知浏览器不再由浏览器自行处理要下载的文件，而由用户手工完成
		response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("gb2312"),"ISO8859-1"));

		//获取输出流，以IO流的形式传给客户端
		OutputStream os = response.getOutputStream();

//		//获取文件路径及名称
//		String excelFileName = "D:\\职工数据模板20180118051344.xls";

		InputStream is = new FileInputStream(excelFileName);

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = is.read(bys)) != -1) {
			os.write(bys, 0, len);
		}
		is.close();
	}
}

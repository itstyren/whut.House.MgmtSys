package com.computerdesign.whutHouseMgmt.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import net.bytebuddy.asm.Advice.This;

/**
 *
 * @author wanhaoran
 * @date 2018年3月18日 下午3:20:15
 * 
 */
public class DocumentHandler{

	private Configuration configuration = null;

	public DocumentHandler() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}

	public byte[] createDocArea(Map<String, Object> dataMap, String outFilePath, String fileName) throws Exception {
//		 this.configuration.setClassForTemplateLoading(DocumentHandler.class, "D:\\");//第一种模板路径
		System.out.println("---进入createDocArea---");
		System.out.println( DocumentHandler.class.getClassLoader());
		System.out.println(DocumentHandler.class.getClassLoader().getResource("../../"));
		System.out.println(DocumentHandler.class.getClassLoader().getResource("../../").getPath());
//		 final String templateFolder = DocumentHandler.class.getClassLoader().getResource("../../").getPath() + "WEB-INF/HireFiles/";
		this.configuration.setDirectoryForTemplateLoading(new File("D:\\"));// 第二种模板路径
//		this.configuration.setDirectoryForTemplateLoading(new File("C:\\"));// 第二种模板路径
		Template t = null;
		File outFile = null;
		byte[] bFile = null;
		try {
			t = this.configuration.getTemplate(fileName, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		outFile = new File(outFilePath);
		Writer w = null;
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(outFile);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			w = new BufferedWriter(osw);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		try {
			t.process(dataMap, w);
			if (outFile != null) {
				FileInputStream fis = new FileInputStream(outFile);
				bFile = new byte[(int) outFile.length()];
				fis.read(bFile);
				fis.close();
			}
			System.out.println("--写入完成---");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			w.close();
			fos.close();
		}
		return bFile;
	}
}

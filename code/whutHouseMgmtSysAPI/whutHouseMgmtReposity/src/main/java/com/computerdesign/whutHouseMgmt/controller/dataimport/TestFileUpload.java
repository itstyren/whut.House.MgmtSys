package com.computerdesign.whutHouseMgmt.controller.dataimport;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestFileUpload {

	@RequestMapping("testFileUpload")
	public String testFileUpload(@RequestParam("file") MultipartFile multipartFile) {
		System.out.println(multipartFile.getOriginalFilename());

		// FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workBook;
		try {
			workBook = new XSSFWorkbook(multipartFile.getInputStream());
			XSSFSheet sheet = workBook.getSheet("sheet1");
			System.out.println(workBook.getSheetAt(1).getSheetName());
			System.out.println(sheet.getSheetName());
			// 获取Excel表中的所有行数
			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows);
			// 遍历行
			for (int i = 1; i < rows; i++) {
				XSSFRow row = sheet.getRow(i);
				if(row != null){
					int cells = row.getPhysicalNumberOfCells();
					for (int j =0 ; j<cells;j++){
						XSSFCell cell = row.getCell(j);
						System.out.println(cell.getStringCellValue());
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";
	}

}

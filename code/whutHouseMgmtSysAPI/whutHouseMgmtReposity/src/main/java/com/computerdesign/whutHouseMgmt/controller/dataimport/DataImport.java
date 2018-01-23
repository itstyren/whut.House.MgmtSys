package com.computerdesign.whutHouseMgmt.controller.dataimport;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.dataimport.DataImportService;

@Controller
public class DataImport {

	@Autowired
	private DataImportService dataImportService;
	
	@RequestMapping("staffDataImport")
	public String staffDataImport(@RequestParam("file") MultipartFile multipartFile) {

		// 用于存放导入的对象集
		List<Staff> staffs = new ArrayList<Staff>();

		XSSFWorkbook workBook;
		try {
			// 获取上传的Excel表
			workBook = new XSSFWorkbook(multipartFile.getInputStream());
			// 获取该Excel表的第一个工作表
			XSSFSheet sheet = workBook.getSheetAt(0);
			// 获取Excel表中的所有行数
			int rows = sheet.getPhysicalNumberOfRows();
			for (int row = 1; row < rows; row++) {
				//定位到行
				XSSFRow rowData = sheet.getRow(row);
				//用于将每行数据以“A,B,C...”的形式封装起来
				String result = "";
				if(rowData != null){
					//获取列
					int cells = rowData.getPhysicalNumberOfCells();
					for (int cell = 0; cell < cells; cell++){						
						//定位到单元格
						XSSFCell formData = rowData.getCell(cell);
						if(formData != null){
							//判断单元格中的数据类型
							switch (formData.getCellType()) {
							//数字
							case HSSFCell.CELL_TYPE_NUMERIC:
								result += formData.getNumericCellValue()+",";
								break;
							//字符串
							case HSSFCell.CELL_TYPE_STRING:
								result += formData.getStringCellValue()+",";
							default:
								break;
							}
						}
					}
					
					//将数据封装为Staff
					String val[] = result.split(",");
					Staff staff = new Staff();
					//若Excel单元格为数字型，则末尾会多出“.0”，需要去除
					String no = val[0];
					//System.out.println(no.indexOf('.'));
					//判断是否包含“.0”，若不包含则会返回-1，此时不需要截取字符串
					if(no.indexOf('.') != -1){
						no = no.substring(0, no.indexOf('.'));
					}
					staff.setNo(no);
					staff.setName(val[1]);
					staff.setSex(val[2]);
					staff.setMarriageState(val[3]);
					Integer title = dataImportService.getStaffParamId(val[4]);
					Integer post = dataImportService.getStaffParamId(val[5]);
					Integer type = dataImportService.getStaffParamId(val[6]);
					Integer status = dataImportService.getStaffParamId(val[7]);
					Integer dept = dataImportService.getStaffParamId(val[8]);
					if(title == null){
						System.out.println("该员工职称参数不存在或已删除");
					}else if(post == null){
						System.out.println("该员工职务参数不存在或已删除");
					}else if(type ==null){
						System.out.println("该职工类别参数不存在或已删除");
					}else if(status == null){
						System.out.println("该职工状态参数不存在或已删除");
					}else if(dept == null){
						System.out.println("该职工工作部门参数不存在或已删除");
					}else{
						staff.setTitle(title);
						staff.setPost(post);
						staff.setType(type);
						staff.setStatus(status);
						staff.setDept(dept);
					}
					
					String code = val[9];
					//正则验证code的合法性
					//待补充
					
					staff.setCode(code);
					
					
					
					System.out.println(staff);
					System.out.println(val[0] +"---" +val[1]+"---" + val[2] +"---" +val[3]);
					System.out.println(dataImportService.getStaffParamId(val[4]) +": " +val[4]);
					dataImportService.insertStaff(staff);
//					staffs.add(staff);
					
				}
			}
		} catch (Exception e) {
		}
		
//		dataImportService.batchInsertStaff(staffs);

//		Staff staff = new Staff();
//		staff.setNo("222");
//		staff.setName("aaa");
//		staff.setSex("adaf");
//		dataImportService.insertStaff(staff);
		
		return "success";
	}

}

package com.computerdesign.whutHouseMgmt.controller.dataimport;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.dataimport.DataImportService;
import com.computerdesign.whutHouseMgmt.utils.DateConversionUtils;
import com.computerdesign.whutHouseMgmt.utils.DownloadUtils;
import com.computerdesign.whutHouseMgmt.utils.ExcelUtils;

@RequestMapping("dataImport")
@Controller
public class DataImportController {

	@Autowired
	private DataImportService dataImportService;

	// 用于存储导入的职工数据
	private List<Staff> staffList;

	// 用于存储导入的住房数据
	private List<House> houseList;
	
	public List<House> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	/**
	 * 保存导入的职工数据
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveData", method = RequestMethod.POST)
	public Msg saveData() {
		if (getStaffList() != null) {
			for (Staff staff : getStaffList()) {
				dataImportService.insertStaff(staff);
			}
			// 保存完成后将数据清空
			setStaffList(null);
			return Msg.success("保存职工数据成功");
		}else if(getHouseList() != null){
			for (House house :getHouseList()){
				dataImportService.insertHouse(house);
			}
			// 保存完成后将数据清空
			setHouseList(null);
			return Msg.success("保存职工数据成功");
		}else {
			return Msg.error("请先导入数据");
		}
	}
	

	/**
	 * 导入职工数据
	 * 
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "staffDataImport", method = RequestMethod.POST)
	public Msg staffDataImport(@RequestParam("staffFile") MultipartFile multipartFile) {

		// 用于存放导入的对象集
		List<Staff> staffs = new ArrayList<Staff>();

		try {
			Workbook workBook = null;
			// System.out.println(multipartFile.getOriginalFilename());

			if (!ExcelUtils.validateExcel(multipartFile.getOriginalFilename())) {
				return Msg.error("请上传Excel格式的文件");
			}

			if (ExcelUtils.isExcel2003(multipartFile.getOriginalFilename())) {
				// 获取上传的Excel表
				workBook = new HSSFWorkbook(multipartFile.getInputStream());
			}

			if (ExcelUtils.isExcel2007(multipartFile.getOriginalFilename())) {
				// 获取上传的Excel表
				workBook = new XSSFWorkbook(multipartFile.getInputStream());
			}

			// 获取该Excel表的第一个工作表
			Sheet sheet = workBook.getSheetAt(0);
			// 获取Excel表中的所有行数
			int rows = sheet.getPhysicalNumberOfRows();
			for (int row = 1; row < rows; row++) {
				// 定位到行
				Row rowData = sheet.getRow(row);
				// 用于将每行数据以“A,B,C...”的形式封装起来
				String result = "";
				if (rowData != null) {
					// 获取列
					int cells = rowData.getPhysicalNumberOfCells();
					for (int cell = 0; cell < cells; cell++) {
						// 定位到单元格
						Cell formData = rowData.getCell(cell);
						if (formData != null) {
							// 判断单元格中的数据类型
							switch (formData.getCellType()) {
							// 数字
							case HSSFCell.CELL_TYPE_NUMERIC:
								result += formData.getNumericCellValue() + ",";
								break;
							// 字符串
							case HSSFCell.CELL_TYPE_STRING:
								result += formData.getStringCellValue() + ",";
							default:
								break;
							}
						}
					}

					// 将数据封装为Staff
					String val[] = result.split(",");
					Staff staff = new Staff();
					// 若Excel单元格为数字型，则末尾会多出“.0”，需要去除
					String no = val[0];
					// System.out.println(no.indexOf('.'));
					// 判断是否包含“.0”，若不包含则会返回-1，此时不需要截取字符串
					if (no.indexOf('.') != -1) {
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
					if (title == null) {
						System.out.println("该员工职称参数不存在或已删除");
					} else if (post == null) {
						System.out.println("该员工职务参数不存在或已删除");
					} else if (type == null) {
						System.out.println("该职工类别参数不存在或已删除");
					} else if (status == null) {
						System.out.println("该职工状态参数不存在或已删除");
					} else if (dept == null) {
						System.out.println("该职工工作部门参数不存在或已删除");
					} else {
						staff.setTitle(title);
						staff.setPost(post);
						staff.setType(type);
						staff.setStatus(status);
						staff.setDept(dept);
					}

					String code = val[9];
					// 正则验证code的合法性
					String codeReg = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
					if (code.matches(codeReg)) {
						staff.setCode(code);
					} else {
						System.out.println("身份证号格式非法,请检查Excel表中是否改为文本模式或知否输入正确");
					}

					// 来校工作时间
					String joinTimeStr = val[10];
					Date joinTime = DateConversionUtils.stringToDate(joinTimeStr, "yyyy/MM/dd");
					// 上大学时间
					String goUniversityTimeStr = val[11];
					Date goUniversityTime = DateConversionUtils.stringToDate(goUniversityTimeStr, "yyyy/MM/dd");
					// 离退休时间
					String retireTimeStr = val[12];
					Date retireTime = DateConversionUtils.stringToDate(retireTimeStr, "yyyy/MM/dd");
					if (joinTime == null) {
						System.out.println("来校工作时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
					} else if (goUniversityTime == null) {
						System.out.println("上大学时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
					} else if (retireTime == null) {
						System.out.println("离退休时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
					} else {
						staff.setJoinTime(joinTime);
						staff.setGoUniversityTime(goUniversityTime);
						staff.setRetireTime(retireTime);
					}

					// 联系电话
					String tel = val[13];
					System.out.println(tel);
					String telReg = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
					if (tel.matches(telReg)) {
						staff.setTel(tel);
					} else {
						System.out.println("电话号码格式非法,请检查EXCEL表是否为文本格式或是否输入正确");
					}

					// 备注
					staff.setRemark(val[14]);
					// 配偶姓名
					staff.setSpouseName(val[15]);
					// 配偶身份证号
					String spouseCode = val[16];
					if (spouseCode.matches(codeReg)) {
						staff.setSpouseCode(spouseCode);
					} else {
						System.out.println("配偶身份证号格式非法,请检查Excel表中是否改为文本模式或知否输入正确");
					}
					// 配偶职称
					Integer spouseTitle = dataImportService.getStaffParamId(val[17]);
					// 配偶职务
					Integer spousePost = dataImportService.getStaffParamId(val[18]);
					if (spouseTitle == null) {
						System.out.println("该员工配偶职称参数不存在或已删除");
					} else if (spousePost == null) {
						System.out.println("该员工配偶职务参数不存在或已删除");
					} else {
						staff.setSpouseTitle(spouseTitle);
						staff.setSpousePost(spousePost);
					}

					// 配偶工作单位
					staff.setSpouseDept(val[19]);

					// 配偶单位性质
					// System.out.println(val[20]);
					Integer spouseKind = dataImportService.getStaffParamId(val[20]);
					System.out.println(spouseKind);
					if (spouseKind == null) {
						System.out.println("该员工配偶单位性质参数不存在或已删除");
					} else {
						staff.setSpouseKind(spouseKind);
					}

					// 购房金额
					String buyAccount = val[21];
					if (buyAccount.indexOf('.') != -1) {
						buyAccount = buyAccount.substring(0, buyAccount.indexOf('.'));
					}
					staff.setBuyAccount((long) Integer.parseInt(buyAccount));

					// 维修基金
					String fixFund = val[22];
					if (fixFund.indexOf('.') != -1) {
						fixFund = fixFund.substring(0, fixFund.indexOf('.'));
					}
					staff.setFixFund((long) Integer.parseInt(fixFund));

					// 将封装好的数据插入数据库
					// dataImportService.insertStaff(staff);

					staffs.add(staff);

				}
			}
		} catch (Exception e) {
			return Msg.error("导入失败");
		}

		setStaffList(staffs);
		return Msg.success("导入数据成功").add("data", staffs);
	}

	/**
	 * 导入住房数据
	 * 
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "houseDataImport", method = RequestMethod.POST)
	public Msg houseDataImport(@RequestParam("houseFile") MultipartFile multipartFile) {

		// 用于存放导入的对象集
		List<House> houses = new ArrayList<House>();

		try {
			Workbook workBook = null;
			// System.out.println(multipartFile.getOriginalFilename());

			if (!ExcelUtils.validateExcel(multipartFile.getOriginalFilename())) {
				return Msg.error("请上传Excel格式的文件");
			}

			if (ExcelUtils.isExcel2003(multipartFile.getOriginalFilename())) {
				// 获取上传的Excel表
				workBook = new HSSFWorkbook(multipartFile.getInputStream());
			}

			if (ExcelUtils.isExcel2007(multipartFile.getOriginalFilename())) {
				// 获取上传的Excel表
				workBook = new XSSFWorkbook(multipartFile.getInputStream());
			}

			// 获取该Excel表的第一个工作表
			Sheet sheet = workBook.getSheetAt(0);
			// 获取Excel表中的所有行数
			int rows = sheet.getPhysicalNumberOfRows();
			for (int row = 1; row < rows; row++) {
				// 定位到行
				Row rowData = sheet.getRow(row);
				// 用于将每行数据以“A,B,C...”的形式封装起来
				String result = "";
				if (rowData != null) {
					// 获取列
					int cells = rowData.getPhysicalNumberOfCells();
					for (int cell = 0; cell < cells; cell++) {
						// 定位到单元格
						Cell formData = rowData.getCell(cell);
						if (formData != null) {
							// 判断单元格中的数据类型
							switch (formData.getCellType()) {
							// 数字
							case HSSFCell.CELL_TYPE_NUMERIC:
								result += formData.getNumericCellValue() + ",";
								break;
							// 字符串
							case HSSFCell.CELL_TYPE_STRING:
								result += formData.getStringCellValue() + ",";
							default:
								break;
							}
						}
					}

					// 将数据封装为House
					String val[] = result.split(",");
					House house = new House();
					// 若Excel单元格为数字型，则末尾会多出“.0”，需要去除
					String no = val[0];
					// System.out.println(no.indexOf('.'));
					// 判断是否包含“.0”，若不包含则会返回-1，此时不需要截取字符串
					if (no.indexOf('.') != -1) {
						no = no.substring(0, no.indexOf('.'));
					}
					house.setNo(no);
					// 住房类型
					Integer type = dataImportService.getHouseParamId(val[1]);
					// 户型
					Integer layout = dataImportService.getHouseParamId(val[2]);
					// 住房结构
					Integer struct = dataImportService.getHouseParamId(val[3]);
					if (type == null) {
						System.out.println("该住房住房类型参数不存在或已删除");
					} else if (layout == null) {
						System.out.println("该住房户型参数不存在或已删除");
					} else if (struct == null) {
						System.out.println("该住房住房结构参数不存在或已删除");
					} else {
						house.setType(type);
						house.setLayout(layout);
						house.setStruct(struct);
					}
					
					//建筑面积
					Double buildArea = Double.valueOf(val[4]);
					house.setBuildArea(buildArea);
					
					//使用面积
					Double usedArea = Double.valueOf(val[5]);
					house.setUsedArea(usedArea);
					
					//地下室面积
					Double basementArea = Double.valueOf(val[6]);
					house.setBasementArea(basementArea);
					
					//地址
					house.setAddress(val[7]);
					
					//所属楼栋
					Integer buildingId = dataImportService.getBuildingParamId(val[8]);
					if (buildingId == null) {
						System.out.println("该住房所属楼栋名称不存在");
					} else {
						house.setBuildingId(buildingId);
					}
					
					//房屋产权证号
					// 若Excel单元格为数字型，则末尾会多出“.0”，需要去除
					String proId = val[9];
					// System.out.println(no.indexOf('.'));
					// 判断是否包含“.0”，若不包含则会返回-1，此时不需要截取字符串
					if (proId.indexOf('.') != -1) {
						proId = proId.substring(0, proId.indexOf('.'));
					}
					house.setProId(proId);
					
					//租金
					Double rental = Double.valueOf(val[10]);
					house.setRental(rental);
					
					//备注
					house.setRemark(val[11]);
					
					//竣工时间
					String finishTimeStr = val[12];
					 Date finishTime =
					 DateConversionUtils.stringToDate(finishTimeStr,
					 "yyyy/MM/dd");
					 if (finishTime == null) {
					 System.out.println("竣工时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
					 } else {
						 house.setFinishTime(finishTime);
					 }
					 houses.add(house);

				}
			}
		} catch (Exception e) {
			return null;
		}
		setHouseList(houses);
		return Msg.success("导入数据成功").add("data", houses);
	}

	/**
	 * 职工模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("staffDownLoad")
	public void staffDownLoad(HttpServletResponse response) {
		try {
			DownloadUtils.downloadSolve("D:\\职工数据模板20180118051344.xls","职工模板.xls", response);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 住房模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("houseDownLoad")
	public void houseDownLoad(HttpServletResponse response) {
		try {
			DownloadUtils.downloadSolve("D:\\住房模板20180125090429.xls","住房模板.xls", response);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

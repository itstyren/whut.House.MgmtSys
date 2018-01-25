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
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.dataimport.DataImportService;
import com.computerdesign.whutHouseMgmt.utils.DateConversionUtils;
import com.computerdesign.whutHouseMgmt.utils.DownloadUtils;

@RequestMapping("dataImport")
@Controller
public class DataImport {

	@Autowired
	private DataImportService dataImportService;
	
	//用于存储导入的职工数据
	private List<Staff> staffList;

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	/**
	 * 保存导入的职工数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveStaffData", method = RequestMethod.POST)
	public Msg saveStaffData(){
		if(getStaffList() != null){
			for (Staff staff : getStaffList()){
				dataImportService.insertStaff(staff);
			}
			//保存完成后将数据清空
			setStaffList(null);
			return Msg.success("保存数据成功");
		}else{
			return Msg.error("请先导入数据");
		}
	}
	
	/**
	 * 导入职工数据
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "staffDataImport", method = RequestMethod.POST)
	public Msg staffDataImport(@RequestParam("file") MultipartFile multipartFile) {

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
				// 定位到行
				XSSFRow rowData = sheet.getRow(row);
				// 用于将每行数据以“A,B,C...”的形式封装起来
				String result = "";
				if (rowData != null) {
					// 获取列
					int cells = rowData.getPhysicalNumberOfCells();
					for (int cell = 0; cell < cells; cell++) {
						// 定位到单元格
						XSSFCell formData = rowData.getCell(cell);
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
//					dataImportService.insertStaff(staff);

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
	 * 模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("downLoad")
	public void downLoad(HttpServletResponse response) {
		try {
			DownloadUtils.downloadSolve("模板.xls", response);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

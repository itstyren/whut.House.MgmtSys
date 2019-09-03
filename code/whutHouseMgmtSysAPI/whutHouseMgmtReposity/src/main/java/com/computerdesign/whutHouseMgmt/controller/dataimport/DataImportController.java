package com.computerdesign.whutHouseMgmt.controller.dataimport;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.Building;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.Region;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParam;
import com.computerdesign.whutHouseMgmt.service.building.BuildingService;
import com.computerdesign.whutHouseMgmt.service.campus.CampusService;
import com.computerdesign.whutHouseMgmt.service.dataimport.DataImportService;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffForMonSubService;
import com.computerdesign.whutHouseMgmt.service.housesub.StaffMonetarySubService;
import com.computerdesign.whutHouseMgmt.service.region.RegionService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.service.staffparam.MonetarySubParamService;
import com.computerdesign.whutHouseMgmt.utils.DateConversionUtils;
import com.computerdesign.whutHouseMgmt.utils.DateUtil;
import com.computerdesign.whutHouseMgmt.utils.DownloadUtils;
import com.computerdesign.whutHouseMgmt.utils.ExcelUtils;

@RequestMapping("dataImport")
@Controller
public class DataImportController {

	@Autowired
	private DataImportService dataImportService;

	@Autowired
	private HouseService houseService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private MonetarySubParamService monetarySubParamService;

	@Autowired
	private StaffMonetarySubService staffMonetarySubService;
	
	@Autowired
	private StaffForMonSubService staffForMonSubService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private CampusService campusService;

	@Autowired
	private BuildingService buildingService;
	
	// 用于存储导入的职工数据
	// private List<Staff> staffList;

	// 用于存储导入的住房数据
	// private List<House> houseList;

	// public List<House> getHouseList() {
	// return houseList;
	// }
	//
	// public void setHouseList(List<House> houseList) {
	// this.houseList = houseList;
	// }
	//
	// public List<Staff> getStaffList() {
	// return staffList;
	// }
	//
	// public void setStaffList(List<Staff> staffList) {
	// this.staffList = staffList;
	// }

	/**
	 * 保存导入的职工数据
	 * 
	 * @return
	 */
	// @ResponseBody
	// @RequestMapping(value = "saveData", method = RequestMethod.POST)
	// public Msg saveData() {
	// if (getStaffList() != null) {
	// for (Staff staff : getStaffList()) {
	// dataImportService.insertStaff(staff);
	// }
	// // 保存完成后将数据清空
	// setStaffList(null);
	// return Msg.success("保存职工数据成功");
	// }else if(getHouseList() != null){
	// for (House house :getHouseList()){
	// dataImportService.insertHouse(house);
	// }
	// // 保存完成后将数据清空
	// setHouseList(null);
	// return Msg.success("保存职工数据成功");
	// }else {
	// return Msg.error("请先导入数据");
	// }
	// }

	// @ResponseBody
	// @RequestMapping(value = "staffDataImport", method = RequestMethod.POST)
	// public Msg staffDataImportByJson(@RequestBody StaffDataImport[]
	// staffDataImports){
	// if(staffDataImports != null){
	// for(StaffDataImport staffDataImport : staffDataImports){
	//
	// }
	// }else{
	// return Msg.error("导入数据字段有误，无法封装");
	// }
	// return;
	// }

	/**
	 * 工资导入，计算货币化补贴
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "salaryImport", method = RequestMethod.POST)
	public Msg salaryImport(@RequestParam("salaryFile") MultipartFile multipartFile) {

		// 用于存放导入的对象集
		List<StaffMonetarySub> staffMonetarySubs = new ArrayList<StaffMonetarySub>();

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

					System.out.println("BB");
					String val[] = result.split(",");
//					for (String str : val){
//						System.out.println(str);
//					}
					StaffMonetarySub staffMonetarySub = new StaffMonetarySub();
					// 若Excel单元格为数字型，则末尾会多出“.0”，需要去除
					String staffNo = val[0];
					// System.out.println(no.indexOf('.'));
					// 判断是否包含“.0”，若不包含则会返回-1，此时不需要截取字符串
					if (staffNo.indexOf('.') != -1) {
						staffNo = staffNo.substring(0, staffNo.indexOf('.'));
					}

					// 职工编号
					if(staffService.getByStaffNo(staffNo).size() > 0){
						staffMonetarySub.setStaffNo(staffNo);
					}else{
						return Msg.error("存在数据库中不存在的员工");
					}

					System.out.println("CC");

					// 职工年度工资设置
//					System.out.println(val[1]);
					String salary = val[1];
					long annualSal = (long) Double.parseDouble(salary) * 12;
					staffMonetarySub.setAnnualSal(annualSal);
					
//					System.out.println(val[1]);
					
					// 年份
					String year = val[2];
					if (year.indexOf('.') != -1) {
						year = year.substring(0, year.indexOf('.'));
					}
					staffMonetarySub.setYear(year);
					
//					System.out.println(val[2]);
//					System.out.println(year);
					
					// 获取补贴比例
					MonetarySubParam monetarySubParam = monetarySubParamService.getIsUsing();
					// 根据职工编号获取职工ID
					Integer staffId = staffService.getStaffIdByStaffNo(staffMonetarySub.getStaffNo());
					Staff staff = staffService.get(staffId);
					Calendar calendar = Calendar.getInstance();
					calendar.set(1998, 11, 31, 0, 0, 0);

					StaffForMonSub staffForMonSub = staffForMonSubService.getByStaffId(staffId);
					double enjoyHouseArea = 80.0;
					// 职务职称享受面积取最大值，获取职工住房补贴标准
					if(staffForMonSub.getMaxEnjoyArea() != null){
						enjoyHouseArea = staffForMonSub.getMaxEnjoyArea();
					}

					System.out.println("DD");
					
					// 获取职工家庭已购住房
					// double buyHouseArea = staffForMonSub.getHouseBuildArea();
					double buyHouseArea = 0.0;
					if(staffForMonSub.getHouseUsedArea() != null){
						buyHouseArea = staffForMonSub.getHouseUsedArea();
					}

					boolean flag = true;
					
					if (staffMonetarySubService.isOwnHouse(staffId)
							&& (staff.getJoinTime().getTime() < calendar.getTime().getTime())
							&& enjoyHouseArea > buyHouseArea) {
						// 有房且是老职工且未达标
						double subsidies = (staffMonetarySub.getAnnualSal() + staffMonetarySub.getAnnualSal() * 0.2806)
								* monetarySubParam.getSubParam() / 100.0 / enjoyHouseArea * (enjoyHouseArea - buyHouseArea);
						// 没有四舍五入
						staffMonetarySub.setSubsidies((long) subsidies);
					}else if ((!staffMonetarySubService.isOwnHouse(staffId)
							&& (staff.getJoinTime().getTime() < calendar.getTime().getTime()))
							|| (staff.getJoinTime().getTime() >= calendar.getTime().getTime())){
						// 无房老职工和新职工的补贴标准
						double subsidies = (staffMonetarySub.getAnnualSal() + staffMonetarySub.getAnnualSal() * 0.2806)
								* monetarySubParam.getSubParam() / 100.0;
						staffMonetarySub.setSubsidies((long) subsidies);
					}else{
						flag = false;
					}

					if(flag){
						System.out.println("EE");
						staffMonetarySub.setRemark(year + "年货币化补贴");

						if (staffMonetarySubService.getStaffMonetarySubByStaffNoAndYear(staffNo, year).size() > 0) {
							staffMonetarySubService.updateStaffMonetarySubByStaffNoAndYear(staffMonetarySub, staffNo, year);
						}else{
							staffMonetarySubService.add(staffMonetarySub);
						}
						
						staffMonetarySubs.add(staffMonetarySub);
					}
				}
			}
		} catch (Exception e) {
			return Msg.error("导入失败,可能有数据在数据库中不存在或删除");
		}

		// 保存数据
		// setHouseList(houses);
		return Msg.success("导入数据成功").add("data", staffMonetarySubs);
	}

	/**
	 * 导入职工数据，并保存
	 * 
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "staffDataImport", method = RequestMethod.POST)
	public Msg staffDataImport(@RequestParam("staffFile") MultipartFile multipartFile) {

		System.out.println("访问成功");
		// 用于存放导入的对象集
		List<Staff> staffs = new ArrayList<Staff>();

		try {
			Workbook workBook = null;
			System.out.println(multipartFile.getOriginalFilename());

			if (!ExcelUtils.validateExcel(multipartFile.getOriginalFilename())) {
				return Msg.error("请上传Excel格式的文件");
			}
			// System.out.println();
			if (ExcelUtils.isExcel2003(multipartFile.getOriginalFilename())) {
				// 获取上传的Excel表
				System.out.println("2003");
				System.out.println(multipartFile.getInputStream());
				workBook = new HSSFWorkbook(multipartFile.getInputStream());
				System.out.println("2003获取成功");
			}
			if (ExcelUtils.isExcel2007(multipartFile.getOriginalFilename())) {
				// 获取上传的Excel表
				System.out.println("2007");
				workBook = new XSSFWorkbook(multipartFile.getInputStream());
			}
			System.out.println("AA");
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
								break;
							default:
								result += ",";
								break;
							}
						}else{
							result += ",";
						}
					}

					System.out.println("result:" + result);
					
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
					Integer title = dataImportService.getStaffParamId(val[4], 7);
					Integer post = dataImportService.getStaffParamId(val[5], 6);
					Integer type = dataImportService.getStaffParamId(val[6], 8);
					Integer status = dataImportService.getStaffParamId(val[7], 9);
					Integer dept = dataImportService.getStaffParamId(val[8], 5);
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
					staff.setCode(code);

					String eduQualification = val[10];
					staff.setEduQualifications(eduQualification);

					// 来校工作时间
					String joinTimeStr = val[11];
//					Date joinTime = DateConversionUtils.stringToDate(joinTimeStr, "yyyy/MM/dd");
					try {
//						Date joinTime = DateConversionUtils.stringToDate(joinTimeStr, "yyyy.MM");
						Date joinTime = DateUtil.parseDate(joinTimeStr, "yyyy.MM");
						staff.setJoinTime(joinTime);
					} catch (Exception e) {
						// TODO: handle exception
						staff.setJoinTime(null);
					}
				
					// 离退休时间
					String retireTimeStr = val[12];
//					Date retireTime = DateConversionUtils.stringToDate(retireTimeStr, "yyyy/MM/dd");
					try {
//						Date retireTime = DateConversionUtils.stringToDate(retireTimeStr, "yyyy.MM");
						Date retireTime = DateUtil.parseDate(retireTimeStr, "yyyy.MM");
						staff.setRetireTime(retireTime);
					} catch (Exception e) {
						// TODO: handle exception
						staff.setRetireTime(null);
					}
					
//					if (joinTime == null) {
//						System.out.println("来校工作时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
//					} else if (retireTime == null) {
//						System.out.println("离退休时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
//					} else {
//						staff.setJoinTime(joinTime);
//						// staff.setGoUniversityTime(goUniversityTime);
//						staff.setRetireTime(retireTime);
//					}

					// 联系电话
					String tel = val[13];
					staff.setTel(tel);

					// 备注
					staff.setRemark(val[14]);
					System.out.println("val[14]:" + val[14]);
					// 配偶姓名
					staff.setSpouseName(val[15]);
					System.out.println("val[15]:" + val[15]);
					
					// 配偶身份证号
					String spouseCode = val[16];
					staff.setSpouseCode(spouseCode);
					
					// 配偶职称
					Integer spouseTitle = dataImportService.getStaffParamId(val[17], 7);
					System.out.println("val[17]:" + val[17]);
					
					// 配偶职务
					Integer spousePost = dataImportService.getStaffParamId(val[18], 6);
					System.out.println("val[18]:" + val[18]);
					
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
					Integer spouseKind = dataImportService.getStaffParamId(val[20], 10);
					if (spouseKind == null) {
						System.out.println("该员工配偶单位性质参数不存在或已删除");
					} else {
						staff.setSpouseKind(spouseKind);
					}
					
					System.out.println("val[20]:" + val[20]);
					
					// 购房金额
					String buyAccount = val[21];
					if (buyAccount.indexOf('.') != -1) {
						buyAccount = buyAccount.substring(0, buyAccount.indexOf('.'));
					}
					staff.setBuyAccount((long) Integer.parseInt(buyAccount));
					System.out.println("val[21]:" + val[21]);
					
					
					// 维修基金
					String fixFund = val[22];
					if (fixFund.indexOf('.') != -1) {
						fixFund = fixFund.substring(0, fixFund.indexOf('.'));
					}
					staff.setFixFund((long) Integer.parseInt(fixFund));
					System.out.println("val[22]:" + val[22]);
					
					//设置配偶职工号
					String familyCodeStr = val[23];
					if (familyCodeStr.indexOf('.') != -1) {
						familyCodeStr = familyCodeStr.substring(0, familyCodeStr.indexOf('.'));
					}
					staff.setFamilyCode(Integer.valueOf(familyCodeStr));
					
					// 设置一些默认值，数据库字段Relation不能为空
					staff.setRelation("active");
					staff.setStaffPassword("123");
					staff.setRoleId(4);

					staffs.add(staff);

					System.out.println("导入一个数据");
					
					if (staffService.getByStaffNo(no).size() > 0) {
						dataImportService.updateStaff(staff, no);
					} else {
						// 将封装好的数据插入数据库
						dataImportService.insertStaff(staff);
					}

				}
			}
		} catch (Exception e) {
			return Msg.error("导入失败,可能有数据在数据库中不存在或删除");
		}

		// 保存数据
		// setStaffList(staffs);
		// for (Staff staff : staffs){
		// dataImportService.insertStaff(staff);
		// }
		return Msg.success("导入数据成功").add("data", staffs);
	}

	/**
	 * 导入楼栋数据，并保存
	 * 
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "regionImport", method = RequestMethod.POST)
	public Msg regionDataImport(@RequestParam("regionFile") MultipartFile multipartFile) {

		System.out.println("CC");
		// 用于存放导入的对象集
		List<Region> regions = new ArrayList<Region>();

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

					// 将数据封装为Region
					String val[] = result.split(",");
					
					Region region = new Region();
					region.setName(val[0]);
					region.setDescription(val[1]);
					
					Integer campusId = campusService.getIdByName(val[2]);
					
					
					region.setCampusId(campusId);

					regionService.add(region);
					regions.add(region);
				}
			}
		} catch (Exception e) {
			return Msg.error("导入失败,可能有数据在数据库中不存在或删除");
		}

		// 保存数据
		// setHouseList(houses);
		return Msg.success("导入数据成功").add("data", regions);
	}

	/**
	 * 导入区域数据，并保存
	 * 
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "buildingImport", method = RequestMethod.POST)
	public Msg buildingDataImport(@RequestParam("buildingFile") MultipartFile multipartFile) {

		System.out.println("DD");
		// 用于存放导入的对象集
		List<Building> buildings = new ArrayList<Building>();

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
								break;
							default:
								result += ",";
								break;
							}
						}else{
							result += ",";
						}
					}

					// 将数据封装为Building
					String val[] = result.split(",");
					System.out.println("result:" + result);
					
					Building building = new Building();
					//楼栋名称
					building.setName(val[0]);
					System.out.println("val[0]:" + val[0]);
//					竣工时间
					String finishTimeStr = val[1];
					// System.out.println(finishTimeStr);
					try {
//						Date finishTime = DateConversionUtils.stringToDate(finishTimeStr, "yyyy/MM/dd");
						Date finishTime = DateUtil.parseDate(finishTimeStr, "yyyy");
						building.setFinishTime(finishTime);
					} catch (Exception e) {
						// TODO: handle exception
						building.setFinishTime(null);
					}
					
//					if (finishTime == null) {
//						System.out.println("竣工时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
//					} else {
//						building.setFinishTime(finishTime);
//					}
					System.out.println("val[1]:" + val[1]);
					//占地面积
					Float floorArea = Float.valueOf(val[2]);
					building.setFloorArea(floorArea);
					System.out.println("val[2]:" + val[2]);
					//使用面积
					Float usedArea = Float.valueOf(val[3]);
					building.setUsedArea(usedArea);
					System.out.println("val[3]:" + val[3]);
					//楼层数
//					System.out.println(val[4]);
					String floorCountStr = val[4];
					if (floorCountStr.indexOf('.') != -1) {
						floorCountStr = floorCountStr.substring(0, floorCountStr.indexOf('.'));
					}
					Integer floorCount = Integer.valueOf(floorCountStr);
//					System.out.println(floorCount);
					building.setFloorCount(floorCount);
					System.out.println("val[4]:" + val[4]);
					//区域
					String regionName = val[5];
					Integer regionId = regionService.getAllByName(regionName).get(0).getId();
					building.setRegionId(regionId);
					System.out.println("val[5]:" + val[5]);
					//描述
					building.setDescription(val[6]);
					System.out.println("val[6]:" + val[6]);
					//维修基金
					Double supportFund = Double.valueOf(val[7]);
					building.setSupportFund(new BigDecimal(supportFund));
					System.out.println("val[7]:" + val[7]);
					//楼栋负责人
					if(val[8] != null || !val[8].trim().equals("")){	
						building.setManager(val[8]);
					}
					System.out.println("val[8]:" + val[8]);
					//单元数
					String unitCountStr = val[9];
					
					if (unitCountStr.indexOf('.') != -1) {
						unitCountStr = unitCountStr.substring(0, unitCountStr.indexOf('.'));
					}
					Integer unitCount = Integer.valueOf(unitCountStr);
					building.setUnitCount(unitCount);
					System.out.println("val[9]:" + val[9]);
					
					buildingService.add(building);
					
					buildings.add(building);
				}
			}
		} catch (Exception e) {
			return Msg.error("导入失败,可能有数据在数据库中不存在或删除");
		}

		// 保存数据
		// setHouseList(houses);
		return Msg.success("导入数据成功").add("data", buildings);
	}
	
	/**
	 * 导入住户数据，并保存
	 * 
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "residentDataImport", method = RequestMethod.POST)
	public Msg residentDataImport(@RequestParam("residentFile") MultipartFile multipartFile) {

		System.out.println("AA");
		// 用于存放导入的对象集
		List<Resident> residents = new ArrayList<Resident>();

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
								break;
							default:
								result += ",";
								break;
							}
						}else{
							result += ",";
						}
					}

					System.out.println("result:" + result);
					// 将数据封装为Resident
					String val[] = result.split(",");
					Resident resident = new Resident();
					// 若Excel单元格为数字型，则末尾会多出“.0”，需要去除
					String staffNo = val[0];
					String staffName = val[1];
					System.out.println(staffNo + staffName);
					// System.out.println(no.indexOf('.'));
					// 判断是否包含“.0”，若不包含则会返回-1，此时不需要截取字符串
					if (staffNo.indexOf('.') != -1) {
						staffNo = staffNo.substring(0, staffNo.indexOf('.'));
					}
					System.out.println("val[0]:" + val[0]);
					Integer staffId = staffService.getStaffIdByStaffNoAndStaffName(staffNo, staffName);
					if (staffId != null) {
						resident.setStaffId(staffId);
					} else {
//						return Msg.error("职工编号或职工姓名有误");
						continue;
					}

					System.out.println("CC");
					// 住房编号
					String houseNo = val[2];
					String address = val[3];

					if (houseNo.indexOf('.') != -1) {
						houseNo = houseNo.substring(0, houseNo.indexOf('.'));
					}
					Integer houseId = houseService.getHouseIdByHouseNoAndAddress(houseNo, address);
					if (houseId != null) {
						resident.setHouseId(houseId);
					} else {
//						return Msg.error("住房编号或地址有误");
						continue;
					}

					System.out.println("DD");
					// 住房关系
					Integer houseRel = dataImportService.getHouseParamId(val[4], 3);
					if (houseRel != null) {
						resident.setHouseRel(houseRel);
					} else {
						return Msg.error("住房关系有误");
					}

					// 登记时间
					String bookTimeStr = val[5];
					// System.out.println(finishTimeStr);
					try {
						Date bookTime = DateConversionUtils.stringToDate(bookTimeStr, "yyyy/MM");
						resident.setBookTime(bookTime);
					} catch (Exception e) {
						// TODO: handle exception
						resident.setBookTime(null);
					}
//					if (bookTime == null) {
//						System.out.println("登记时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
//					} else {
//						resident.setBookTime(bookTime);
//						;
//					}

					// System.out.println(val[6].equals(""));
					// System.out.println(val[6]);
					// System.out.println(val[6].equals(""));
					// houseService.add(house);
//					resident.setRentType(val[6]);
					String payTypeStr = val[6];
					Integer payType = Integer.valueOf(payTypeStr);
					resident.setPayType(payType);

//					String familyCode = val[7];
//
//					if (familyCode.indexOf('.') != -1) {
//						familyCode = familyCode.substring(0, familyCode.indexOf('.'));
//					}
//					resident.setFamilyCode(familyCode);

					resident.setIsDelete(false);
//					System.out.println(familyCode);

					residents.add(resident);
//					System.out.println("add");
					
					// 导入住房关系时同时修改house的状态
					houseService.updateHouseStatus(houseId, houseRel);
					
					if (dataImportService.getResidentByStaffIdAndHouseId(staffId, houseId).size() > 0) {
						dataImportService.updateResidentByStaffIdAndHouseId(resident, staffId, houseId);
					} else {
						dataImportService.insertResident(resident);
					}

					System.out.println("end");

				}
			}
		} catch (Exception e) {
			return Msg.error("导入失败,可能有数据在数据库中不存在或删除");
		}

		// 保存数据
		// setHouseList(houses);
		return Msg.success("导入数据成功").add("data", residents);
	}

	/**
	 * 职工模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("staffDownLoad")
	public void staffDownLoad(HttpServletResponse response) {
		try {
//			DownloadUtils.downloadSolve("D:\\staffImport.xlsx", "职工模板.xlsx", response);
			DownloadUtils.downloadSolve("E:\\DataImportTemplate\\staffImport.xlsx", "职工模板.xlsx", response);
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
//			DownloadUtils.downloadSolve("D:\\houseImport.xlsx", "住房模板.xlsx", response);
			DownloadUtils.downloadSolve("E:\\DataImportTemplate\\houseImport.xlsx", "住房模板.xlsx", response);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 导入住房数据，并保存
	 * 
	 * @param multipartFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "houseDataImport", method = RequestMethod.POST)
	public Msg houseDataImport(@RequestParam("houseFile") MultipartFile multipartFile) {

		System.out.println("AA");
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
								break;
							default:
								result += ",";
								break;
							}
						}else{
							result += ",";
						}
					}
					
					System.out.println("result:" + result);
					
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
					
					System.out.println("val[0]:" + val[0]);
					System.out.println("val[1]:" + val[1]);
					System.out.println("val[2]:" + val[2]);
					
					// 住房类型
					Integer type = dataImportService.getHouseParamId(val[1], 1);
					System.out.println("val[1]:" + val[1]);
					System.out.println(type);
					// 户型
					Integer layout = dataImportService.getHouseParamId(val[2], 2);
					System.out.println("val[2]:" + val[2]);
					// 住房结构
					Integer struct = dataImportService.getHouseParamId(val[3], 4);
					System.out.println("val[3]:" + val[3]);
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
					
					System.out.println("val[1]:" + val[1]);
					System.out.println(house);

					// 建筑面积
					Double buildArea = Double.valueOf(val[4]);
					house.setBuildArea(buildArea);

					// 使用面积
					Double usedArea = Double.valueOf(val[5]);
					house.setUsedArea(usedArea);

					// 地下室面积
					Double basementArea = Double.valueOf(val[6]);
					house.setBasementArea(basementArea);

					// 地址
					house.setAddress(val[7]);
					
					System.out.println("val[7]:" + val[7]);
					
					// 所属楼栋
					Integer buildingId = dataImportService.getBuildingParamId(val[8]);
					if (buildingId == null) {
						System.out.println("该住房所属楼栋名称不存在");
					} else {
						house.setBuildingId(buildingId);
					}
					
					System.out.println("val[8]:" + val[8]);
					
					// 房屋产权证号
					// 若Excel单元格为数字型，则末尾会多出“.0”，需要去除
					String proId = val[9];
					// System.out.println(no.indexOf('.'));
					// 判断是否包含“.0”，若不包含则会返回-1，此时不需要截取字符串
					if (proId.indexOf('.') != -1) {
						proId = proId.substring(0, proId.indexOf('.'));
					}
					house.setProId(proId);

					System.out.println("val[9]:" + val[9]);
					
					// // 租金
					// Double rental = Double.valueOf(val[10]);
					// house.setRental(rental);

					// 备注
					house.setRemark(val[10]);

					// 竣工时间
					String finishTimeStr = val[11];
					// System.out.println(finishTimeStr);
					try {
						Date finishTime = DateUtil.parseDate(finishTimeStr, "yyyy");
						house.setFinishTime(finishTime);
					} catch (Exception e) {
						house.setFinishTime(null);
					}
//					Date finishTime = DateConversionUtils.stringToDate(finishTimeStr, "yyyy/MM/dd");
//					if (finishTime == null) {
//						System.out.println("竣工时间日期字符串格式不对，请检查Excel表中是否改为文本模式或是否输入正确");
//					} else {
//						house.setFinishTime(finishTime);
//					}

					// 设置一些默认值
					house.setRecordStatus(0);

					if (houseService.getHouseByNo(no).size() > 0) {
						houseService.updateByStaffNo(house, no);
					} else {
						houseService.add(house);
					}

					houses.add(house);
				}
			}
		} catch (Exception e) {
			return Msg.error("导入失败,可能有数据在数据库中不存在或删除");
		}

		// 保存数据
		// setHouseList(houses);
		return Msg.success("导入数据成功").add("data", houses);
	}
	

	/**
	 * 住户模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("residentDownLoad")
	public void residentDownLoad(HttpServletResponse response) {
		try {
//			DownloadUtils.downloadSolve("D:\\residentImport.xlsx", "住户模板.xlsx", response);
			DownloadUtils.downloadSolve("E:\\DataImportTemplate\\residentImport.xlsx", "住户模板.xlsx", response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 住户模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("salaryDownLoad")
	public void salaryDownLoad(HttpServletResponse response) {
		try {
//			DownloadUtils.downloadSolve("D:\\salaryImport.xlsx", "工资模板.xlsx", response);
			DownloadUtils.downloadSolve("E:\\DataImportTemplate\\salaryImport.xlsx", "工资模板.xlsx", response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 区域模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("regionDownLoad")
	public void regionDownLoad(HttpServletResponse response) {
		try {
//			DownloadUtils.downloadSolve("D:\\salaryImport.xlsx", "工资模板.xlsx", response);
			DownloadUtils.downloadSolve("E:\\DataImportTemplate\\RegionData.xlsx", "区域模板.xlsx", response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 楼栋模板下载
	 * 
	 * @param response
	 */
	@RequestMapping("buildingDownLoad")
	public void buildingDownLoad(HttpServletResponse response) {
		try {
//			DownloadUtils.downloadSolve("D:\\salaryImport.xlsx", "工资模板.xlsx", response);
			DownloadUtils.downloadSolve("E:\\DataImportTemplate\\BuildingData.xlsx", "楼栋模板.xlsx", response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

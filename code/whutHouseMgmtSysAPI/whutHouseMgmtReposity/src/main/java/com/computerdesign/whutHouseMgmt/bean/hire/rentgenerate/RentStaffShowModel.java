package com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RentStaffShowModel {
	
	private String staffNo;

	private String staffName;

	// 入住时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date bookTime;

	// 到期时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date expireTime;

	// 来校工作时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date joinTime;

	private String sex;

	private String marriageState;

	// 职称
	private String titleName;

	// 职务
	private String postName;

	// 职工类别
	private String typeName;

	// 工作状态
	private String statusName;

	// 工作部门
	private String deptName;

	// 身份证号
	@Pattern(regexp = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)", message = "身份证号码为18位或15位，最后一位为校验位，可以为数字或字母X")
	private String code;

	// 参加工作时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date firstJobTime;

	// 上大学时间
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//	private Date goUniversityTime;

	// 离退休时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date retireTime;

	// 联系电话
	@Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "电话号码格式错误")
	private String tel;

	// 其他住房情况
	private String remark;

	// 配偶姓名
	private String spouseName;

	// 配偶身份证号
	@Pattern(regexp = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)", message = "身份证号码为18位或15位，最后一位为校验位，可以为数字或字母X")
	private String spouseCode;

	// 配偶职称
	private String spouseTitleName;

	// 配偶职务
	private String spousePostName;

	// 配偶单位
	private String spouseDeptName;

	// 配偶单位性质
	private String spouseKindName;

	private Integer houseId;
	
	// 住房号
	private String houseNo;

	// 住房类型
	private String houseTypeName;

	// 户型
	private String houseLayoutName;

	// 结构
	private String houseStructName;

	// 使用状态
	private String houseStatusName;

	// 建筑面积
	private Double houseBulidArea;

	// 使用面积
	private Double houseUsedArea;

	// 地下室面积
	private Double houseBasementArea;

	// 地址
	private String houseAddress;
	

	// 竣工时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date houseFinishTime;

	// 所属楼栋
	private String buildingName;

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMarriageState() {
		return marriageState;
	}

	public void setMarriageState(String marriageState) {
		this.marriageState = marriageState;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date bookTime) {
		this.bookTime = bookTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getFirstJobTime() {
		return firstJobTime;
	}

	public void setFirstJobTime(Date firstJobTime) {
		this.firstJobTime = firstJobTime;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

//	public Date getGoUniversityTime() {
//		return goUniversityTime;
//	}
//
//	public void setGoUniversityTime(Date goUniversityTime) {
//		this.goUniversityTime = goUniversityTime;
//	}

	public Date getRetireTime() {
		return retireTime;
	}

	public void setRetireTime(Date retireTime) {
		this.retireTime = retireTime;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseCode() {
		return spouseCode;
	}

	public void setSpouseCode(String spouseCode) {
		this.spouseCode = spouseCode;
	}

	public String getSpouseTitleName() {
		return spouseTitleName;
	}

	public void setSpouseTitleName(String spouseTitleName) {
		this.spouseTitleName = spouseTitleName;
	}

	public String getSpousePostName() {
		return spousePostName;
	}

	public void setSpousePostName(String spousePostName) {
		this.spousePostName = spousePostName;
	}

	public String getSpouseDeptName() {
		return spouseDeptName;
	}

	public void setSpouseDeptName(String spouseDeptName) {
		this.spouseDeptName = spouseDeptName;
	}

	public String getSpouseKindName() {
		return spouseKindName;
	}

	public void setSpouseKindName(String spouseKindName) {
		this.spouseKindName = spouseKindName;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getHouseLayoutName() {
		return houseLayoutName;
	}

	public void setHouseLayoutName(String houseLayoutName) {
		this.houseLayoutName = houseLayoutName;
	}

	public String getHouseStructName() {
		return houseStructName;
	}

	public void setHouseStructName(String houseStructName) {
		this.houseStructName = houseStructName;
	}

	public String getHouseStatusName() {
		return houseStatusName;
	}

	public void setHouseStatusName(String houseStatusName) {
		this.houseStatusName = houseStatusName;
	}

	public Double getHouseBulidArea() {
		return houseBulidArea;
	}

	public void setHouseBulidArea(Double houseBulidArea) {
		this.houseBulidArea = houseBulidArea;
	}

	public Double getHouseUsedArea() {
		return houseUsedArea;
	}

	public void setHouseUsedArea(Double houseUsedArea) {
		this.houseUsedArea = houseUsedArea;
	}

	public Double getHouseBasementArea() {
		return houseBasementArea;
	}

	public void setHouseBasementArea(Double houseBasementArea) {
		this.houseBasementArea = houseBasementArea;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public Date getHouseFinishTime() {
		return houseFinishTime;
	}

	public void setHouseFinishTime(Date houseFinishTime) {
		this.houseFinishTime = houseFinishTime;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
}

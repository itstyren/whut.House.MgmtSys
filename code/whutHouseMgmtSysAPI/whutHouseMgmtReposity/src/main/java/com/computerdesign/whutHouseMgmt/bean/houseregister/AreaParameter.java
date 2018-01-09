package com.computerdesign.whutHouseMgmt.bean.houseregister;

import java.util.ArrayList;
import java.util.List;

public class AreaParameter {

	// 面积参数名称
	// private List<String> areaParamName = new ArrayList<String>();
	private String areaParamName;

	// 最小面积
	private double minArea;

	// 最大面积
	private double maxArea;

	public String getAreaParamName() {
		return areaParamName;
	}

	public void setAreaParamName(String areaParamName) {
		this.areaParamName = areaParamName;
	}

	public double getMinArea() {
		return minArea;
	}

	public void setMinArea(double minArea) {
		this.minArea = minArea;
	}

	public double getMaxArea() {
		return maxArea;
	}

	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}

}

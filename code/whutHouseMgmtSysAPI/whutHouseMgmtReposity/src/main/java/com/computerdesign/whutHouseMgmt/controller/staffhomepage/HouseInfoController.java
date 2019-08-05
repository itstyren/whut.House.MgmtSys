package com.computerdesign.whutHouseMgmt.controller.staffhomepage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseVw;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouse;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouseShowInfo;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentOutshcoolHouseShow;
import com.computerdesign.whutHouseMgmt.service.houseregister.OutSchoolHouseService;
import com.computerdesign.whutHouseMgmt.service.staffhomepage.houseinfo.ResidentHouseInfoService;

/**
 * 职工个人信息模块，拥有的房屋信息
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/houseInfo/")
public class HouseInfoController {
	
	@Autowired
	private ResidentHouseInfoService residentHouseInfoService;
	
	@Autowired
	private OutSchoolHouseService outSchoolHouseService;
	
	@ResponseBody
	@RequestMapping(value="getResidentHouseByStaffId/{staffId}",method = RequestMethod.GET)
	public Msg getResidentHouseByStaffId(@PathVariable("staffId")Integer staffId){
		//校内房
		List<ResidentHouse> residentHouses = residentHouseInfoService.getHouseInfo(staffId);
//		System.out.println(residentHouses.get(0));
		List<ResidentHouseShowInfo> residentHouseShowInfos = new ArrayList<ResidentHouseShowInfo>();
		if(residentHouses != null){
			for (ResidentHouse residentHouse : residentHouses){
				ResidentHouseShowInfo residentHouseShowInfo = new ResidentHouseShowInfo();
				residentHouseShowInfo.setHouseId(residentHouse.getHouseId());
				residentHouseShowInfo.setAddress(residentHouse.getAddress());
				residentHouseShowInfo.setRegionName(residentHouse.getRegionName());
				residentHouseShowInfo.setStructName(residentHouse.getHouseStructName());
				residentHouseShowInfo.setLayoutName(residentHouse.getHouseLayoutName());
				residentHouseShowInfo.setHouseRelName(residentHouse.getHouseRelName());
				residentHouseShowInfo.setIsResidentHouse(true);
				residentHouseShowInfos.add(residentHouseShowInfo);
			}
		}
		
		//校外房
		List<OutSchoolHouseVw> outSchoolHouseVws = outSchoolHouseService.getOutSchoolHouseVwByStaffId(staffId);
//		List<ResidentOutshcoolHouseShow> residentOutshcoolHouseShows = new ArrayList<ResidentOutshcoolHouseShow>();
		if(outSchoolHouseVws != null){
			for (OutSchoolHouseVw outSchoolHouseVw : outSchoolHouseVws){
//				ResidentOutshcoolHouseShow residentOutshcoolHouseShow = new ResidentOutshcoolHouseShow();
//				residentOutshcoolHouseShow.setId(outSchoolHouseVw.getId());
//				residentOutshcoolHouseShow.setHouseRelName(outSchoolHouseVw.getHouseRelName());
//				residentOutshcoolHouseShow.setAddress(outSchoolHouseVw.getAddress());
//				residentOutshcoolHouseShows.add(residentOutshcoolHouseShow);
				ResidentHouseShowInfo residentHouseShowInfo = new ResidentHouseShowInfo();
				residentHouseShowInfo.setHouseId(outSchoolHouseVw.getId());
				residentHouseShowInfo.setAddress(outSchoolHouseVw.getAddress());
				residentHouseShowInfo.setHouseRelName(outSchoolHouseVw.getHouseRelName());
				residentHouseShowInfo.setIsResidentHouse(false);
				residentHouseShowInfos.add(residentHouseShowInfo);
			}
		}
		
		
		return Msg.success().add("data", residentHouseShowInfos);
	}
	
}

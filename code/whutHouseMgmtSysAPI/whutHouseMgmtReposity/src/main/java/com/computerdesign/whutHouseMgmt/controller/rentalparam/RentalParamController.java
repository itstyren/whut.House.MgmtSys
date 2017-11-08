package com.computerdesign.whutHouseMgmt.controller.rentalparam;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameter;
import com.computerdesign.whutHouseMgmt.service.rentalparam.RentalParamService;

@RequestMapping(value = "/rentalParam/")
@Controller
public class RentalParamController {

	@Autowired
	private RentalParamService rentalParamService;

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public Msg getRentalPresentOne() {
		List<RentalParameter> rentalParameters = rentalParamService.getPresentOne();
		if (rentalParameters.size() == 0) {
			return Msg.error("没有可显示的数据");
		} else if (rentalParameters.size() == 1) {
			RentalParameter rentalParameter = rentalParameters.get(0);
			return Msg.success().add("data", rentalParameter);
		} else {
			return Msg.error("查找出错");
		}
	}

	/**
	 * 将原有的数据的IsDelete设置为1，增添一条新记录
	 * @param rentalParameter
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	@ResponseBody
	public Msg updateRental(@RequestBody RentalParameter rentalParameter) {
		
		//补全为null的数据
		rentalParameter.setParamTypeId(17);
		rentalParameter.setParamTypeName("租金优惠选项");
		
		//要执行insert操作，其RentalParamId在数据库中为自增，在传入时必须为空
		if(rentalParameter.getRentalParamId()!=null){
			rentalParameter.setRentalParamId(null);
		}

		List<RentalParameter> rentalParameters = rentalParamService.getPresentOne();

		try {
			//如果之前有数据，则进行修改操作
			if (rentalParameters.size()==1) {
				RentalParameter rentalParameterPre = rentalParameters.get(0);	
				//将现在显示的一列的IsDelete设置为true，不直接删除原始数据
				rentalParameterPre.setIsDelete(true);
				rentalParamService.update(rentalParameterPre);
			}
			rentalParamService.add(rentalParameter);
			return Msg.success().add("data", rentalParameter);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("操作失败");
		}

		
	}
}

package com.computerdesign.whutHouseMgmt.controller.houseparam;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/houseParam/")
@Controller
public class HouseParameterController {

	@Autowired
	HouseParamService houseParamService;
	
	/**
	 * 
	 * 获取相应的房屋类别信息
	 * @param paramTypeId
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="get/{paramTypeId}",method = RequestMethod.GET)
	public Msg getHouseParameter(@PathVariable("paramTypeId")Integer paramTypeId,@RequestParam(value="page",defaultValue="1")Integer page,@RequestParam(value="size",defaultValue="10")Integer size){
		//分页查询
		PageHelper.startPage(page,size);
		//根据paramTypeId来查找
		List<HouseParameter> houseParams=houseParamService.getAll(paramTypeId);
		//
		PageInfo pageInfo=new PageInfo(houseParams);
		
		if(houseParams!=null){
			return Msg.success().add("PageInfo", pageInfo);
		}else{
			return Msg.error();
		}
	}
	
	/**
	 * 添加一条房屋参数
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public Msg addHouseParameter(@RequestBody HouseParameter houseParameter){
		//房屋参数名为空
		if(houseParameter.getHouseParamName()!=null){
			//房屋类别ID为空
			if(houseParameter.getParamTypeId()!=null){
				houseParamService.add(houseParameter);
				return  Msg.success().add("houseParameter", houseParameter);
			}else{
				return Msg.error("房屋类别ID为空");
			}
		}else{
			return Msg.error("房屋参数名为空");
		}
	}
	
	/**
	 * 根据houseParamId删除一条记录
	 * @param houseParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="delete/{houseParamId}",method=RequestMethod.DELETE)
	public Msg deleteHouseParam(@PathVariable("houseParamId")Integer houseParamId){
		//houseParamId不存在
		HouseParameter houseParameter = houseParamService.get(houseParamId);
		if(houseParameter!=null){
			try {
				houseParamService.delete(houseParamId);
				return Msg.success().add("houseParameter", houseParameter);
			} catch (Exception e) {
				// TODO: handle exception
				return Msg.error();
			}
			
		}else{
			return  Msg.error("houseParamId不存在");
		}
	}
	
	/**
	 * 修改一条记录
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="modify",method=RequestMethod.PUT)
	public Msg modifyHouseParam(@RequestBody HouseParameter houseParameter){
		try {
			houseParamService.update(houseParameter);
			return Msg.success().add("houseParameter", houseParameter);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error();
		}
	}
}

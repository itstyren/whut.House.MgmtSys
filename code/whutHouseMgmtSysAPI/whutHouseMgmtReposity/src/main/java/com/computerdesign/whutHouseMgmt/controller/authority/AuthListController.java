package com.computerdesign.whutHouseMgmt.controller.authority;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.authority.AuthList;
import com.computerdesign.whutHouseMgmt.service.authority.AuthListService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;

@RequestMapping("/auth/")
@Controller
public class AuthListController {
	
	@Autowired
	private AuthListService authListService;
	
//	@ResponseBody
//	@RequestMapping(value="authList", method = RequestMethod.GET)
//	public Msg getAuthListByGroupName(@RequestParam(value = "groupName") String groupName){
//		AuthList authList = authListService.getAuthListByGroupName(groupName);
//		return Msg.success("获取成功").add("data", authList);
//	}

	@ResponseBody
	@RequestMapping(value="authList", method = RequestMethod.GET)
	public Msg getAllAuthList(){
		List<AuthList> authLists = authListService.getAllAuthList();
		return Msg.success("获取成功").add("data", authLists);
	}
	
	@ResponseBody
	@RequestMapping(value="partAuthList", method = RequestMethod.GET)
	public Msg getPartAuthList(){
		List<AuthList> authLists = authListService.getAllAuthList();
		String[] fileds = { "id", "groupName"};
		List<Map<String, Object>> response = ResponseUtil.getResultMap(authLists, fileds);
		return Msg.success("获取成功").add("data", response);
	}
	
	
//	@ResponseBody
//	@RequestMapping(value="delAuthList", method = RequestMethod.DELETE)
//	public Msg deleteAuthListByGroupName(@RequestBody List<Integer> ids){
//		
//		Boolean status = authListService.deleteAuthListByGroupName(ids);
//		if (status){
//			return Msg.success("删除成功");
//		}else{
//			return Msg.error("列表为空");
//		}
//	}
	
	@ResponseBody
	@RequestMapping(value="delAuthList", method = RequestMethod.DELETE)
	public Msg deleteAuthListByGroupName(@RequestBody List<String> groupNames){
		
		Boolean status = authListService.deleteAuthListByGroupName(groupNames);
		if (status){
			return Msg.success("删除成功");
		}else{
			return Msg.error("列表为空");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="addAuth", method = RequestMethod.POST)
	public Msg addAuthList(@RequestBody AuthList authList){
		System.out.println(authList);
		Boolean status = authListService.addAuthList(authList);
		if (status){
			return Msg.success("新增成功");
		}else{
			return Msg.error("传入参数有误或用户组已存在");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="editAuth", method = RequestMethod.PUT)
	public Msg editAuthList(@RequestBody AuthList authList){
		Boolean status = authListService.editAuthList(authList);
//		System.out.println(authList);
		if (status){
			return Msg.success("修改成功");
		}else{
			return Msg.error("参数有误或列表为空");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="getOneAuth/{id}", method = RequestMethod.GET)
	public Msg getOneAuth(@PathVariable(value="id") Integer id){
		AuthList authList = authListService.getOneAuth(id);
		if (authList != null){
			return Msg.success("处理成功").add("data", authList);
		}else{
			return Msg.error("未找到该用户组");
		}
	}
	
	
}

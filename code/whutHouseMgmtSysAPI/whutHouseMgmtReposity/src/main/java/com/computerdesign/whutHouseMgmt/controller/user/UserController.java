package com.computerdesign.whutHouseMgmt.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.region.Region;
import com.computerdesign.whutHouseMgmt.bean.user.User;
import com.computerdesign.whutHouseMgmt.service.user.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value="/user/")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="get",method = RequestMethod.GET)
	public Msg getUsers(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size){
		//分页，下一条语句为查询语句
		PageHelper.startPage(page,size);
		List<User> users = userService.getAll();
		
		PageInfo pageInfo = new PageInfo(users);
		if(users == null){
			return Msg.error("查找不到数据");
		}else{
			return Msg.success().add("date", pageInfo);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="add",method = RequestMethod.POST)
	public Msg addUser(@RequestBody User user){
		List<User> userPres = userService.getUserByNo(user.getNo());
		if(!userPres.isEmpty()){
			return Msg.error("该房屋编号已经存在");
		}else{
			userService.add(user);
			return Msg.success();
		}
	}
	
	@ResponseBody
	@RequestMapping(value="delete/{id}",method = RequestMethod.DELETE)
	public Msg deleteUser(@PathVariable("id") Integer id){
		try {
			userService.delete(id);
			return Msg.success("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("删除失败");
		}
	}
}

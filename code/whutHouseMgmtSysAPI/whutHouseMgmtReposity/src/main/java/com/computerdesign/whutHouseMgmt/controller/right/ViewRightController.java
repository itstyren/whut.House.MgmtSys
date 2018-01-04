package com.computerdesign.whutHouseMgmt.controller.right;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.right.ClassWithRight;
import com.computerdesign.whutHouseMgmt.bean.right.Right;
import com.computerdesign.whutHouseMgmt.bean.right.RightClass;
import com.computerdesign.whutHouseMgmt.service.right.RightClassService;
import com.computerdesign.whutHouseMgmt.service.right.RightService;

@RequestMapping(value = "/right/")
@Controller
public class ViewRightController {

	
	@Autowired
	private RightService rightService;
	
	@Autowired
	private RightClassService rightClassService;
	
	@RequestMapping(value = "getClassWithRights/{classId}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getClassWithRights(@PathVariable("classId")Integer classId){
		RightClass rightClass = rightClassService.get(classId);
		List<Right> list = rightService.getRightsByClassId(classId);
		ClassWithRight classWithRight = new ClassWithRight(rightClass, list);
		return Msg.success().add("data", classWithRight);
	}

	@RequestMapping(value = "get",method = RequestMethod.GET)
	@ResponseBody
	public Msg getAll(){
		List<ClassWithRight> list = new ArrayList<ClassWithRight>();
		List<RightClass> rightClasses = rightClassService.get();
		for(RightClass rightClass:rightClasses){
			List<Right> rights = rightService.getRightsByClassId(rightClass.getId());
			ClassWithRight classWithRight = new ClassWithRight(rightClass, rights);
			list.add(classWithRight);
		}
		return Msg.success().add("data", list);
	}
}

package com.computerdesign.whutHouseMgmt.controller.staffhomepage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.fix.common.Fix;
import com.computerdesign.whutHouseMgmt.bean.fixratings.FixRatings;
import com.computerdesign.whutHouseMgmt.service.fix.FixService;
import com.computerdesign.whutHouseMgmt.service.fixratings.FixRatingsService;

@RequestMapping("/fixRatings/")
@Controller
public class FixRatingsController {
	
	@Autowired
	private FixRatingsService fixRatingsService;
	@Autowired
	private FixService fixService;
	
	@ResponseBody
	@RequestMapping(value="fixEvaluation",method=RequestMethod.PUT)
	public Msg fixEvaluation(@RequestBody FixRatings fixRatings){
		if(fixRatings != null){
			if(fixRatingsService.getByFixId(fixRatings.getFixId()) != null){
				return Msg.error("该维修记录已经评过分");
			}
			int ratings;
			try {
//				System.out.println(fixRatings.getRatings());
				ratings = Integer.parseInt(fixRatings.getRatings());
//				System.out.println(fixRatings.getRatings());
			} catch (NumberFormatException e) {
				return Msg.error("等级评价必须为数字");
			}
			
			if(ratings >= 0 && ratings <= 5){
				fixRatings.setSubmitTime(new Date());
				Fix fix = fixService.get(fixRatings.getFixId());
				fix.setFixState("已评价");
				fixService.update(fix);
				fixRatingsService.insert(fixRatings);
				return Msg.success("评价成功").add("data", fixRatings);
			}else{
				return Msg.error("等级评价的数字必须在0-5之间");
			}
		}else{			
			return Msg.error("字段传递有误");
		}
	}
	
}

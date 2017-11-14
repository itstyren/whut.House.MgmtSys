package com.computerdesign.whutHouseMgmt.controller.region;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

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
import com.computerdesign.whutHouseMgmt.dao.region.RegionMapper;
import com.computerdesign.whutHouseMgmt.service.region.RegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/region/")
@Controller
public class RegionController {

	@Autowired
	private RegionService regionService;

	@ResponseBody
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Msg getRegions(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		//分页，下一条语句为查询语句
		PageHelper.startPage(page, size);
		List<Region> regions = regionService.getAll();

		PageInfo pageInfo = new PageInfo(regions);

		if (regions == null) {
			return Msg.error("查找不到数据");
		} else {
			return Msg.success().add("date", pageInfo);
		}
	}

	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addRegion(@RequestBody Region region) {
		//区域名不能为空
		if (region.getName() == null) {
			return Msg.error("区域名不能为空");
		} else {
			regionService.add(region);
			return Msg.success().add("data", region);
		}
	}

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyRegion(@RequestBody Region region) {
		if (region.getId() == null) {
			return Msg.error("不存在该项");
		} else {
			//区域名不能为空
			if (region.getName() == null) {
				return Msg.error("区域名不能为空");
			} else {
				regionService.update(region);
				return Msg.success().add("data", region);
			}
		}
	}

	@ResponseBody
	@RequestMapping(value = "delete/{Id}", method = RequestMethod.DELETE)
	public Msg deleteRegion(@PathVariable("Id") Integer Id) {
		Region region = regionService.get(Id);

		if (region != null) {
			try {
				// 外键约束
				regionService.delete(Id);
				return Msg.success();
			} catch (Exception e) {
				// TODO: handle exception
				return Msg.error("请先删除该地区的所有楼栋").add("data", region);
			}
		} else {
			return Msg.error("找不到该Id");
		}
	}
}

package com.computerdesign.whutHouseMgmt.controller.campus;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.campus.Campus;
import com.computerdesign.whutHouseMgmt.controller.BaseController;
import com.computerdesign.whutHouseMgmt.service.campus.CampusService;
import com.computerdesign.whutHouseMgmt.service.region.ViewRegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

/**
 *
 * @author wanhaoran
 * @date 2018年4月1日 下午5:14:27
 * 
 */
@RestController
@RequestMapping(value = "/campus/")
public class CampusController extends BaseController {

	@Autowired
	private CampusService campusService;

	@Autowired
	private ViewRegionService viewRegionService;

	/**
	 * 获取该校区
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "{id}")
	public Msg getById(@PathVariable("id") Integer id) {
		Campus campus = campusService.getById(id);
		if (campus == null) {
			return Msg.error("查找不到该校区");
		}
		return Msg.success().add("data", campus);
	}

	/**
	 * 分页获取全部的校区
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping(value = "all")
	public Msg get(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<Campus> campuses = campusService.getAll();
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		PageInfo pageInfo = new PageInfo(campuses);
		return Msg.success().add("data", pageInfo);
	}

	@DeleteMapping(value = "{id}")
	public Msg deleteById(@PathVariable("id") Integer id) {
		if (!viewRegionService.getByCampusId(id).isEmpty()) {
			return Msg.error("存在区域属于该校区，无法删除");
		}
		campusService.delete(id);
		return Msg.success("删除成功");
	}

	@PutMapping(value = "update")
	public Msg update(@RequestBody Campus campus) {
		if (campusService.getById(campus.getId()) == null) {
			return Msg.error("找不到该项");
		}
		if (campus.getName() == null) {
			return Msg.error("校区名不能为空");
		}
		List<Campus> campusList = campusService.getAll();

		Iterator<Campus> iterator = campusList.iterator();
		while (iterator.hasNext()) {
			Campus campusAlready = iterator.next();
			if (campusAlready.getName().equals(campus.getName()) && campusAlready.getId() != campus.getId()) {
				return Msg.error("该房屋名称已经存在");
			}
		}
		campusService.update(campus);
		return Msg.success("修改成功");
	}

	/**
	 * 增加一个Campus
	 * 
	 * @param campus
	 * @return
	 */
	@PostMapping("add")
	@ApiOperation(notes = "不要传id", value = "添加campus")
	public Msg addCampus(@RequestBody Campus campus) {
		if (campusService.countByName(campus.getName()) > 0) {
			return Msg.error("该名称已经存在");
		}
		campusService.add(campus);
		return Msg.success("添加成功");
	}
}

package com.computerdesign.whutHouseMgmt.controller.house;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.computerdesign.whutHouseMgmt.utils.Arith;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

@RequestMapping(value = "/house/")
@RestController
public class HouseController {

	@Autowired
	private HouseService houseService;

	@Autowired
	private HouseParamService houseParamService;

	@Autowired
	private ViewHouseService viewHouseService;

	/**
	 * 根据houseNo获取一个House
	 * 
	 * @param houseNo
	 * @return
	 */
	@RequestMapping(value = "getByNo/{houseNo}", method = RequestMethod.GET)
	@ApiOperation(value = "根据house的houseNo获取一个house")
	public Msg get(@PathVariable("houseNo") String houseNo) {
		System.out.println(houseNo);
		if (viewHouseService.getByNo(houseNo).isEmpty()) {
			return Msg.error("查找不到数据");
		}
		ViewHouse viewHouse = viewHouseService.getByNo(houseNo).get(0);
		// 每平方米的价格
		double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
		// 每平方米的价格*面积
		viewHouse.setRental(Arith.mul(rentPer, viewHouse.getBuildArea()));
		return Msg.success().add("data", viewHouse);
	}
	
	/**
	 * 根据id获取一个House
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "根据house的id获取一个house")
	public Msg get(@PathVariable("id") Integer id) {
		if (viewHouseService.get(id).isEmpty()) {
			return Msg.error("查找不到数据");
		}
		ViewHouse viewHouse = viewHouseService.get(id).get(0);
		// 每平方米的价格
		double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
		// 每平方米的价格*面积
//		viewHouse.setRental(Arith.mul(rentPer, viewHouse.getBuildArea()));
		viewHouse.setRental(Arith.mul(rentPer, viewHouse.getUsedArea()));
		return Msg.success().add("data", viewHouse);
	}

	/**
	 * 获取全部的house并且不分页
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ApiOperation(value = "获取全部的house", notes = "不分页，并且除了根据id获取外，都不查找到校外的房屋")
	public Msg get(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouseList = viewHouseService.getAll();

		if (viewHouseList == null || viewHouseList.isEmpty()) {
			return Msg.success("没有房屋数据");
		}
		for (ViewHouse viewHouse : viewHouseList) {
			// 每平方米的价格
			double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
			// 每平方米的价格*面积
			viewHouse.setRental(Arith.mul(rentPer, viewHouse.getBuildArea()));
		}
		PageInfo pageInfo = new PageInfo(viewHouseList);

		return Msg.success().add("data", pageInfo);

	}

	/**
	 * 根据regionId查找属于某一地区的viewHouse
	 * 
	 * @param regionId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getViewHousesByRegionId/{regionId}", method = RequestMethod.GET)
	@ApiOperation(value = "查找某一区域的房屋信息")
	public Msg getViewHouseByRegionId(@PathVariable("regionId") Integer regionId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouseList = viewHouseService.getViewHousesByRegionId(regionId);

		for (ViewHouse viewHouse : viewHouseList) {
			// 每平方米的价格
			double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
			// 每平方米的价格*面积
//			viewHouse.setRental(Arith.mul(rentPer, viewHouse.getBuildArea())); 
//			20201127 修改
			viewHouse.setRental(Arith.mul(rentPer, viewHouse.getUsedArea()));
//			System.out.println(viewHouse.getUsedArea());
		}
		PageInfo pageInfo = new PageInfo(viewHouseList);

		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 根据buildingId查找属于某一栋的viewHouse
	 * 
	 * @param buildingId
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "getViewHousesByBuildingId/{buildingId}", method = RequestMethod.GET)
	@ApiOperation(value = "查找某一栋楼的房屋信息")
	public Msg getViewHousesByBuildingId(@PathVariable("buildingId") Integer buildingId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouseList = viewHouseService.getViewHousesByBuildingId(buildingId);

		for (ViewHouse viewHouse : viewHouseList) {
			// 每平方米的价格
			double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
			// 每平方米的价格*面积
//			viewHouse.setRental(Arith.mul(rentPer, viewHouse.getBuildArea()));
//			20201127 修改
			viewHouse.setRental(Arith.mul(rentPer, viewHouse.getUsedArea()));
//			System.out.println(viewHouse.getUsedArea());
		}
		PageInfo pageInfo = new PageInfo(viewHouseList);

		return Msg.success().add("data", pageInfo);
	}

	@GetMapping(value = "viewHouseByCampusId/{campusId}")
	public Msg getViewHouseByCampusId(@PathVariable("campusId")Integer campusId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "0") Integer size) {

		PageHelper.startPage(page, size);
		List<ViewHouse> viewHouseList = viewHouseService.getViewHouseByCampusId(campusId);

		for (ViewHouse viewHouse : viewHouseList) {
			// 每平方米的价格
			double rentPer = houseParamService.getRentalByStruce(viewHouse.getStruct());
			// 每平方米的价格*面积
//			viewHouse.setRental(Arith.mul(rentPer, viewHouse.getBuildArea()));
//			20201127 修改
			viewHouse.setRental(Arith.mul(rentPer, viewHouse.getUsedArea()));
//			System.out.println(viewHouse.getUsedArea());
		}
		PageInfo pageInfo = new PageInfo(viewHouseList);

		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 添加一个house
	 * 
	 * @param house
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ApiOperation(value = "添加一个房屋", notes = "IsOutSchoole用来表示校内还是校外")
	public Msg addHouse(@RequestBody House house) {

		if (house.getNo() == null) {
			return Msg.error("房屋编号不能为空");
		}
		if (house.getType() == null) {
			return Msg.error("房屋类型不能为空");
		}
		if (house.getLayout() == null) {
			return Msg.error("户型不能为空");
		}
		if (house.getStruct() == null) {
			return Msg.error("房屋结构不能为空");
		}
		if (house.getBuildingId() == null) {
			return Msg.error("房屋楼栋不能为空");
		}
		if(house.getUsedArea()==null){
			return Msg.error("使用面积不能为空");
		}
		if (house.getBuildArea()==null) {
			return Msg.error("建筑面积不能为空");
		}
		if (house.getAddress()==null) {
			return Msg.error("房屋地址不能为空");
		}
		

		List<House> housePres = houseService.getHouseByNo(house.getNo());
		if (!housePres.isEmpty()) {
			return Msg.error("该房屋编号已经存在").add("error-data", housePres);
		}
		// 1.住房类型
		// 2.户型
		// 3.使用状态
		// 4.住房结构
		List<Integer> houseTypeParamIds = houseParamService.getHouseParamId(1);
		if (!houseTypeParamIds.contains(house.getType())) {
			return Msg.error("不存在的住房类型");
		}
		List<Integer> houseLayoutParamIds = houseParamService.getHouseParamId(2);
		if (!houseLayoutParamIds.contains(house.getLayout())) {
			return Msg.error("不存在的住房类型");
		}
		List<Integer> houseStructParamIds = houseParamService.getHouseParamId(4);
		if (!houseStructParamIds.contains(house.getStruct())) {
			return Msg.error("不存在的住房类型");
		}

		// TODO 这个地方是房屋状态为空闲
		house.setStatus(24);
		houseService.add(house);
		return Msg.success().add("data", house);
	}

	/**
	 * 根据id删除某一house
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除一个房屋", notes = "删除失败可能是存在外键")
	public Msg deleteHouse(@PathVariable("id") Integer id) {
		// 不存在该id
		if (houseService.get(id) == null) {
			return Msg.error("删除失败");
		}
		// 删除失败可能是外键约束
		try {
			houseService.delete(id);
			return Msg.success("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("删除失败");
		}
	}

	/**
	 * 修改
	 * 
	 * @param house
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	@ApiOperation(value = "更改房屋信息", notes = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!非常重要，更改楼栋时，所有的信息请《手动输入》，你需要更改哪一项就输入哪一项，不填的默认不更改", response = com.computerdesign.whutHouseMgmt.bean.Msg.class)
	public Msg modifyHouse(@RequestBody House house) {
		// 基本不会出现这样的情况

		if (house.getNo() == null) {
			return Msg.error("房屋编号不能为空");
		} else if (house.getType() == null) {
			return Msg.error("房屋类型不能为空");
		} else if (house.getLayout() == null) {
			return Msg.error("户型不能为空");
		} else if (house.getStruct() == null) {
			return Msg.error("房屋结构不能为空");
		} else if (house.getBuildingId() == null) {
			return Msg.error("房屋楼栋不能为空");
		}
		
		// 根据传入的编号获取数据库中的该house
		List<House> housePres = houseService.getHouseByNo(house.getNo());
		// 根据传入的id获取数据库中的该house
		House housePre = houseService.get(house.getId());
		if (!housePres.isEmpty()) {
			// 根据id获取的house和根据编号获取的house不一样
//			if (housePre.getId() != housePres.get(0).getId()) {
			if (!housePre.getId().toString().equals(housePres.get(0).getId().toString())) {
//				System.out.println("aaa");
				return Msg.error("房屋已经存在");
			}
		}

		

		List<Integer> houseTypeParamIds = houseParamService.getHouseParamId(1);
		if (!houseTypeParamIds.contains(house.getType())) {
			return Msg.error("不存在的住房类型");
		}
		List<Integer> houseLayoutParamIds = houseParamService.getHouseParamId(2);
		if (!houseLayoutParamIds.contains(house.getLayout())) {
			return Msg.error("不存在的住房类型");
		}

		List<Integer> houseStructParamIds = houseParamService.getHouseParamId(4);
		if (!houseStructParamIds.contains(house.getStruct())) {
			return Msg.error("不存在的住房类型");
		}


//		图片保存与删除
		if(house.getImage() != null){
//			获取传来的路径
			String[] paths = house.getImage().split(",");
//			System.out.println("paths:" + paths);
			
//			获取数据库保存的路径
			String imagePath = houseService.get(house.getId()).getImage();
//			System.out.println("imagePath:" + imagePath );
//			若原来该住房有图片，则需要进行比对，是否删除
			if(imagePath != null && !imagePath.trim().equals("")){
				String[] originPaths = imagePath.split(",");
//				System.out.println("originPaths:" + originPaths);
//				将数据库中原保存的图片与现在上传的图片一一比对，若不存在则删除图片文件
				for (String originPath : originPaths){
					boolean flag = false;
					for (String path : paths){
//						System.out.println(originPath + ":" + path);
						if (originPath.equals(path)){
//							System.out.println("相等");
							flag = true;
							break;
						}
					}
					if (flag){
//						System.out.println("aaa");
						continue;
					}else{
						String fileName = originPath.substring(originPath.lastIndexOf("/"), originPath.length());
//						System.out.println(fileName);
						String filePathName = "E:\\WhutHouseSysStore\\images\\" + fileName;
						File file = new File(filePathName);
						if(file.delete()){
							System.out.println("图片删除成功");
						}else{
//							return Msg.error("重复图片删除失败");
							System.out.println("没有该图片");
						}
					}
				}
			}
			
		}
		
//		文件保存与删除
		if(house.getFiles() != null){
//			获取传来的路径
			String[] paths = house.getFiles().split(",");
//			System.out.println("paths:" + paths);
			
//			获取数据库保存的路径
			String filesPath = houseService.get(house.getId()).getFiles();
//			System.out.println("imagePath:" + imagePath );
//			若原来该住房有图片，则需要进行比对，是否删除
			if(filesPath != null && !filesPath.trim().equals("")){
				String[] originPaths = filesPath.split(",");
//				System.out.println("originPaths:" + originPaths);
//				将数据库中原保存的图片与现在上传的图片一一比对，若不存在则删除图片文件
				for (String originPath : originPaths){
					boolean flag = false;
					for (String path : paths){
//						System.out.println(originPath + ":" + path);
						if (originPath.equals(path)){
//							System.out.println("相等");
							flag = true;
							break;
						}
					}
					if (flag){
//						System.out.println("aaa");
						continue;
					}else{
						String fileName = originPath.substring(originPath.lastIndexOf("\\"), originPath.length());
//						System.out.println(fileName);
						String filePathName = "E:\\WhutHouseSysStore\\files\\" + fileName;
						File file = new File(filePathName);
						if(file.delete()){
							System.out.println("文件删除成功");
						}else{
//							return Msg.error("重复文件删除失败");
							System.out.println("没有该文件");
						}
					}
				}
			}
			
		}
		
		try {
			houseService.update(house);
			return Msg.success("修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("修改失败");
		}

	}
}

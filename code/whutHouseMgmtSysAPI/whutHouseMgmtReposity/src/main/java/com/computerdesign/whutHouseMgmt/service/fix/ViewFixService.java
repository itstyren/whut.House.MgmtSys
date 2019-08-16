package com.computerdesign.whutHouseMgmt.service.fix;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fix.FixGetCheck;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFixExample;
import com.computerdesign.whutHouseMgmt.bean.fix.common.ViewFixExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.fix.record.FixAllSelectModel;
import com.computerdesign.whutHouseMgmt.dao.fix.ViewFixMapper;

@Service
public class ViewFixService {

	@Autowired
	private ViewFixMapper viewFixMapper;

	/**
	 * 根据职工id获取所有维修信息
	 * 
	 * @param staffId
	 * @return
	 */
	public List<ViewFix> getByStaffId(Integer staffId) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("ApplyTime DESC");
		criteria.andStaffIdEqualTo(staffId);
		return viewFixMapper.selectByExample(example);
	}

	public List<ViewFix> getAll() {
		return viewFixMapper.selectByExample(null);
	}

	/**
	 * 根据id获取ViewFix
	 * 
	 * @param id
	 * @return
	 */
	public List<ViewFix> getById(Integer id) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		return viewFixMapper.selectByExample(example);
	}

	/**
	 * 根据起始时间和结束时间获取全部的维修信息 使用的ViewFix表
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<ViewFix> getByTime(Date startTime, Date endTime) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyTimeBetween(startTime, endTime);
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 根据起始时间和结束时间获取全部的维修信息 使用的ViewFix表，附带管理员权限
	 * @param startTime
	 * @param endTime
	 * @param campusIds
	 * @return
	 */
	public List<ViewFix> getByTimeWithMP(Date startTime, Date endTime, List<Integer> campusIds) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyTimeBetween(startTime, endTime);
		criteria.andCampusIdIn(campusIds);
		return viewFixMapper.selectByExample(example);
	}

	/**
	 * 根据条件查询 FixGetCheck中包括申请时间的起始和终止时间，维修内容属于哪一项
	 * 
	 * @param fixGetCheck
	 * @return
	 */
	public List<ViewFix> getByMultiCondition(FixGetCheck fixGetCheck) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("IsCheck");
		Date startTime = fixGetCheck.getStartTime();
		Date endTime = fixGetCheck.getEndTime();
		Integer conditionId = fixGetCheck.getConditionId();
		String conditionContent = fixGetCheck.getConditionContent();
		// 时间参数
		if (startTime != null && endTime != null) {
			// 时间在中间
			criteria.andApplyTimeBetween(startTime, endTime);
		} else if (startTime != null && endTime == null) {
			// 时间大于设置的起始时间
			criteria.andApplyTimeGreaterThanOrEqualTo(startTime);
		} else if (startTime == null && endTime != null) {
			// 时间小于设置的终止时间
			criteria.andApplyTimeLessThanOrEqualTo(endTime);
		}

		// 强制参数
		if (conditionContent != null) {
			if (conditionId == 1) {
				criteria.andIdEqualTo(Integer.parseInt(conditionContent));
			} else if (conditionId == 2) {
				criteria.andStaffNoEqualTo(conditionContent);
			} else if (conditionId == 3) {
				criteria.andHouseNoEqualTo(conditionContent);
			} else if (conditionId == 4) {
				criteria.andStaffNameEqualTo(conditionContent);
			}
		}
		criteria.andIsOverEqualTo(true);
		criteria.andAgreeStateEqualTo("通过");
		return viewFixMapper.selectByExample(example);

	}
	

	/**
	 * 维修结算
	 * 根据条件查询 FixGetCheck中包括申请时间的起始和终止时间，维修内容属于哪一项，附带管理员权限
	 * @param fixGetCheck
	 * @param campusIds
	 * @return
	 */
	public List<ViewFix> getByMultiConditionWithMP(FixGetCheck fixGetCheck, List<Integer> campusIds) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
//		example.setOrderByClause("");
		example.setOrderByClause("IsCheck, ApplyTime DESC");
		Date startTime = fixGetCheck.getStartTime();
		Date endTime = fixGetCheck.getEndTime();
		Integer conditionId = fixGetCheck.getConditionId();
		String conditionContent = fixGetCheck.getConditionContent();
		
		criteria.andCampusIdIn(campusIds);
		
		// 时间参数
		if (startTime != null && endTime != null) {
			// 时间在中间
			criteria.andApplyTimeBetween(startTime, endTime);
		} else if (startTime != null && endTime == null) {
			// 时间大于设置的起始时间
			criteria.andApplyTimeGreaterThanOrEqualTo(startTime);
		} else if (startTime == null && endTime != null) {
			// 时间小于设置的终止时间
			criteria.andApplyTimeLessThanOrEqualTo(endTime);
		}

		// 强制参数
		if (conditionContent != null) {
			if (conditionId == 1) {
				criteria.andIdEqualTo(Integer.parseInt(conditionContent));
			} else if (conditionId == 2) {
				criteria.andStaffNoEqualTo(conditionContent);
			} else if (conditionId == 3) {
				criteria.andHouseNoEqualTo(conditionContent);
			} else if (conditionId == 4) {
				criteria.andStaffNameEqualTo(conditionContent);
			}
		}
		criteria.andIsOverEqualTo(true);
		criteria.andAgreeStateEqualTo("通过");
		return viewFixMapper.selectByExample(example);

	}
	

	/**
	 * 根据条件查询维修信息
	 * isRating为true则表示要求评价后的数据，如何为false则表示不做评价要求
	 * @param fixAllSelectModel
	 * @param isRating
	 * @return
	 */
	public List<ViewFix> multiConditionQuery(FixAllSelectModel fixAllSelectModel,boolean isRating) {
		Date startTime = fixAllSelectModel.getStartTime();
		Date endTime = fixAllSelectModel.getEndTime();
		ViewFixExample viewFixExample = new ViewFixExample();
		Criteria criteria = viewFixExample.createCriteria();
		if (isRating == true) {
			criteria.andRatingsIsNotNull();
		}
		if (fixAllSelectModel.getCampusId() != null) {
			criteria.andCampusIdEqualTo(fixAllSelectModel.getCampusId());
		}
		if (fixAllSelectModel.getRegionId() != null) {
			criteria.andRegionIdEqualTo(fixAllSelectModel.getRegionId());
		}
		if (fixAllSelectModel.getBuildingId() != null) {
			criteria.andBuildingIdEqualTo(fixAllSelectModel.getBuildingId());
		}
		if (fixAllSelectModel.getFixContentId() != null) {
			criteria.andFixContentIdEqualTo(fixAllSelectModel.getFixContentId());
		}

		// 时间设定
		if (startTime != null && endTime != null) {
			// 时间在中间
			criteria.andApplyTimeBetween(startTime, endTime);
		} else if (startTime != null && endTime == null) {
			// 时间大于设置的起始时间
			criteria.andApplyTimeGreaterThanOrEqualTo(startTime);
		} else if (startTime == null && endTime != null) {
			// 时间小于设置的终止时间
			criteria.andApplyTimeLessThanOrEqualTo(endTime);
		}
		
		return viewFixMapper.selectByExample(viewFixExample);
	}
	
	/**
	 * 根据条件查询维修信息，附带管理员权限
	 * isRating为true则表示要求评价后的数据，如何为false则表示不做评价要求
	 * @param fixAllSelectModel
	 * @param isRating
	 * @param campusIds
	 * @return
	 */
	public List<ViewFix> multiConditionQueryWithMP(FixAllSelectModel fixAllSelectModel,boolean isRating, List<Integer> campusIds) {
		Date startTime = fixAllSelectModel.getStartTime();
		Date endTime = fixAllSelectModel.getEndTime();
		ViewFixExample viewFixExample = new ViewFixExample();
		Criteria criteria = viewFixExample.createCriteria();
		
		criteria.andCampusIdIn(campusIds);
		
		if (isRating == true) {
			criteria.andRatingsIsNotNull();
		}
		if (fixAllSelectModel.getCampusId() != null) {
			criteria.andCampusIdEqualTo(fixAllSelectModel.getCampusId());
		}
		if (fixAllSelectModel.getRegionId() != null) {
			criteria.andRegionIdEqualTo(fixAllSelectModel.getRegionId());
		}
		if (fixAllSelectModel.getBuildingId() != null) {
			criteria.andBuildingIdEqualTo(fixAllSelectModel.getBuildingId());
		}
		if (fixAllSelectModel.getFixContentId() != null) {
			criteria.andFixContentIdEqualTo(fixAllSelectModel.getFixContentId());
		}

		// 时间设定
		if (startTime != null && endTime != null) {
			// 时间在中间
			criteria.andApplyTimeBetween(startTime, endTime);
		} else if (startTime != null && endTime == null) {
			// 时间大于设置的起始时间
			criteria.andApplyTimeGreaterThanOrEqualTo(startTime);
		} else if (startTime == null && endTime != null) {
			// 时间小于设置的终止时间
			criteria.andApplyTimeLessThanOrEqualTo(endTime);
		}
		
		return viewFixMapper.selectByExample(viewFixExample);
	}

	
	/**
	 * 给定一个ViewFix集合，求拒绝量
	 * @param list
	 * @return
	 */
	public Long getTotalCountRefused(List<ViewFix> list) {
		long count = 0;
		for (ViewFix viewFix : list) {
			if (viewFix.getIsOver() == true ) {
				if ("受理拒绝".equals(viewFix.getFixState())||"审核拒绝".equals(viewFix.getFixState())) {
					count++;
				}
			}
		}
		return count;
	}
	/**
	 * 给定一个ViewFix集合，求处理量
	 * @param list
	 * @return
	 */
	public Long getTotalCountHandle(List<ViewFix> list) {
		long count = 0;
		for (ViewFix viewFix : list) {
			if (viewFix.getIsOver() == true ) {				
					count++;
			}
		}
		return count;
	}
	
	/**
	 * 根据维修类型来获取全部的数据
	 * @param list
	 * @param fixContentName
	 * @return
	 */
	public List<ViewFix> getFixDateByType(List<ViewFix> list,String fixContentName) {
		List<ViewFix> listViewFix = new ArrayList<>();
		for (ViewFix viewFix : list) {
			if (fixContentName.equals(viewFix.getFixContentName())) {
				listViewFix.add(viewFix);
			}
		}
		return listViewFix;
	}
	/**
	 * 获取全部待受理的维修信息 获取条件为IsOver为0，FixState为"待受理"
	 * 
	 * @return
	 */
	public List<ViewFix> getAcceptUntil() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();		
		criteria.andIsOverEqualTo(false);
		criteria.andFixStateEqualTo("待受理");
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部待受理的维修信息 获取条件为IsOver为0，FixState为"待受理"，附带管理员权限
	 * 
	 * @return
	 */
	public List<ViewFix> getAcceptUntilWithMP(List<Integer> campusIds) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();		
		criteria.andIsOverEqualTo(false);
		criteria.andCampusIdIn(campusIds);
		criteria.andFixStateEqualTo("待受理");
		return viewFixMapper.selectByExample(example);
	}
	

	/**
	 * 获取全部的已经受理的维修信息 获取条件为AcceptState不为空
	 * 
	 * @return
	 */
	public List<ViewFix> getAcceptHasBeen() {
		ViewFixExample example = new ViewFixExample();
		example.setOrderByClause("ApplyTime DESC");
		Criteria criteria = example.createCriteria();
		// 已经受理的信息在AcceptState不为空
		criteria.andAcceptStateIsNotNull();
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部的已经受理的维修信息 获取条件为AcceptState不为空，附带管理员权限
	 * 
	 * @return
	 */
	public List<ViewFix> getAcceptHasBeenWithMP(List<Integer> campusIds) {
		ViewFixExample example = new ViewFixExample();
		example.setOrderByClause("ApplyTime DESC");
		Criteria criteria = example.createCriteria();
		// 已经受理的信息在AcceptState不为空
		criteria.andAcceptStateIsNotNull();
		criteria.andCampusIdIn(campusIds);
		return viewFixMapper.selectByExample(example);
	}
	

	/**
	 * 获取全部待审核的维修信息 获取条件IsOver为0，FixState为“待审核”，AcceptState为“通过”
	 * 
	 * @return
	 */
	public List<ViewFix> getAgreeUntil() {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andFixStateEqualTo("待审核");
		criteria.andAcceptStateEqualTo("通过");
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部待审核的维修信息 获取条件IsOver为0，FixState为“待审核”，AcceptState为“通过”，附带管理员权限
	 * 
	 * @return
	 */
	public List<ViewFix> getAgreeUntilWithMP(List<Integer> campusIds) {
		ViewFixExample example = new ViewFixExample();
		Criteria criteria = example.createCriteria();
		criteria.andFixStateEqualTo("待审核");
		criteria.andAcceptStateEqualTo("通过");
		criteria.andCampusIdIn(campusIds);
		return viewFixMapper.selectByExample(example);
	}

	/**
	 * 获取全部的已审核的维修信息
	 * 
	 * @return
	 */
	public List<ViewFix> getAgreeHasBeen() {
		ViewFixExample example = new ViewFixExample();
		example.setOrderByClause("ApplyTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(true);
		// 已经审核的信息在AgreeState不为空
		criteria.andAgreeStateIsNotNull();
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 获取全部的已审核的维修信息，附带管理员权限
	 * 
	 * @return
	 */
	public List<ViewFix> getAgreeHasBeenWithMP(List<Integer> campusIds) {
		ViewFixExample example = new ViewFixExample();
		example.setOrderByClause("ApplyTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(true);
		// 已经审核的信息在AgreeState不为空
		criteria.andAgreeStateIsNotNull();
		criteria.andCampusIdIn(campusIds);
		return viewFixMapper.selectByExample(example);
	}

	/**
	 * 获取全部未定价，未结算的维修信息
	 * 
	 * @return
	 */
	public List<ViewFix> getManagement() {
		ViewFixExample example = new ViewFixExample();
		example.setOrderByClause("ApplyTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andIsCheckEqualTo(false);
		criteria.andPriceTimeIsNull();
		return viewFixMapper.selectByExample(example);
	}
	
	/**
	 * 维修申请管理
	 * 获取全部未定价，未结算的维修信息，附带管理员权限
	 * 
	 * @return
	 */
	public List<ViewFix> getManagementWithMP(List<Integer> campusIds) {
		ViewFixExample example = new ViewFixExample();
		example.setOrderByClause("ApplyTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andIsCheckEqualTo(false);
		criteria.andPriceTimeIsNull();
		criteria.andCampusIdIn(campusIds);
		return viewFixMapper.selectByExample(example);
	}
}

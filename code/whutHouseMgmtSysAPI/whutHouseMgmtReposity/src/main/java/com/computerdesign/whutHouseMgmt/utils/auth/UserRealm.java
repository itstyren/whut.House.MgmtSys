package com.computerdesign.whutHouseMgmt.utils.auth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.computerdesign.whutHouseMgmt.bean.authority.Permission;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.authority.PermissionService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.wf.etp.authz.IUserRealm;
import com.wf.etp.authz.SubjectUtil;

/**
 * UserRealm
 * 
 * @author 
 * @date 2018-1-22 上午8:30:17
 */
public class UserRealm extends IUserRealm {
	@Autowired
	private StaffService staffService;
	@Autowired
	private PermissionService permissionService;

	/**
	 * 根据staffId获取该员工的role
	 * 
	 * @param staffId
	 * @return
	 */
	@Override
	public Set<String> getUserRoles(String staffId) {
		Set<String> roles = new HashSet<String>();
		Staff staff = staffService.get(Integer.parseInt(staffId));

		if (staff != null) {
			roles.add(staff.getRoleId().toString());
		}
		return roles;
	}

	@Override
	public Set<String> getUserPermissions(String staffId) {
		Set<String> permissionValues = new HashSet<String>();
		List<String> staffRoles = SubjectUtil.getInstance().getUserRoles(staffId);
		if (staffRoles.size() > 0) {
			// 将String转成Integer
			Integer roleId = Integer.parseInt(staffRoles.get(0));
			List<Permission> permissions = permissionService.getPermissionsByRoleId(roleId);
			for (int i = 0; i < permissions.size(); i++) {
				String permissionValue = permissions.get(i).getValue();
				if (permissionValue != null && !permissionValue.isEmpty()) {
					permissionValues.add(permissionValue);
				}
			}
		}
		return permissionValues;
	}
}
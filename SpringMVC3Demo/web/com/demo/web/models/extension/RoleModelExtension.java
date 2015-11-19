package com.demo.web.models.extension;

import com.demo.model.models.Role;
import com.demo.service.models.RoleSearch;
import com.demo.web.models.RoleEditModel;
import com.demo.web.models.RoleSearchModel;

public class RoleModelExtension {
	public static RoleSearch toRoleSearch(RoleSearchModel searchModel){
		RoleSearch ret=new RoleSearch();
		ret.setName(searchModel.getName());
		
		return ret;
	}
	
	public static Role toRole(RoleEditModel editModel){
		Role role=new Role();
		role.setId(editModel.getId());
		role.setName(editModel.getName());
		return role;
	}
}

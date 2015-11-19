package com.demo.web.models.extension;

import com.demo.model.models.Role;
import com.demo.web.models.RoleBindModel;

public class RoleBindModelExtension {
	
	public static RoleBindModel toRoleBindModel(Role role){
		RoleBindModel ret=new RoleBindModel();
		ret.setName(role.getName());
		
		return ret;
	}
	
}

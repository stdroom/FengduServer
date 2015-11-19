package com.demo.service.interfaces;

import com.demo.dao.interfaces.IRoleDao;
import com.demo.model.models.Role;
import com.demo.service.models.RoleSearch;
import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;

public interface IRoleService extends IEnableEntityService<Integer, Role, IRoleDao> {

	public PageList<Role> listPage(RoleSearch search, int pageNo, int pageSize);
	public void saveAuthorize(Integer roleId, Integer[] authorityIds) throws ValidatException, EntityOperateException;

}
package com.demo.service.interfaces;

import com.demo.dao.interfaces.IOrganizationDao;
import com.demo.model.models.Organization;
import com.infrastructure.project.base.service.interfaces.IChainEntityService;
import com.infrastructure.project.common.utilities.PageList;

public interface IOrganizationService extends IChainEntityService<Integer, Organization, IOrganizationDao> {

	public PageList<Organization> listPage(String name, int pageNo, int pageSize);
	
}
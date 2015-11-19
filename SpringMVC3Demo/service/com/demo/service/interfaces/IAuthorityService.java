package com.demo.service.interfaces;

import com.demo.dao.interfaces.IAuthorityDao;
import com.demo.model.models.Authority;
import com.demo.service.models.AuthoritySearch;
import com.infrastructure.project.base.service.interfaces.IChainEntityService;
import com.infrastructure.project.common.utilities.PageList;

public interface IAuthorityService extends IChainEntityService<Integer, Authority, IAuthorityDao> {

	public PageList<Authority> listPage(AuthoritySearch search, int pageNo, int pageSize);
	
}
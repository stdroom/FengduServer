package com.demo.service.services;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.demo.model.models.Organization;
import com.demo.service.interfaces.IOrganizationService;
import com.demo.dao.interfaces.IOrganizationDao;
import com.infrastructure.project.base.service.services.ChainEntityService;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.utilities.PageList;
import com.infrastructure.project.common.utilities.PageListUtil;

@Service("OrganizationService")
public class OrganizationService extends ChainEntityService<Integer, Organization, IOrganizationDao> implements IOrganizationService {
	
	@Autowired
	public OrganizationService(@Qualifier("OrganizationDao")IOrganizationDao organizationDao){
		super(organizationDao);
	}
	
	@Override
	public void update(Organization model) throws ValidatException, EntityOperateException{
		Organization dbModel=super.get(model.getId());
		dbModel.setName(model.getName());
		dbModel.setPosition(model.getPosition());
		dbModel.setTheValue(model.getTheValue());
		dbModel.setParent(model.getParent());
		super.update(dbModel);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PageList<Organization> listPage(String name, int pageNo, int pageSize) {		
		Criteria countCriteria = entityDao.getCriteria();
		Criteria listCriteria = entityDao.getCriteria();
		
        if(name!=null && !name.isEmpty()){
        	countCriteria.add(Restrictions.eq("name", name)); 
    		listCriteria.add(Restrictions.eq("name", name));
        }
          	
        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<Organization> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
    }

}

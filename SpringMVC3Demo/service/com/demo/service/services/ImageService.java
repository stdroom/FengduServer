/**
 * 工程名: SpringMVC3Demo
 * 文件名: ImageService.java
 * 包名: com.demo.service.services
 * 日期: 2015年11月20日下午2:02:05
 * QQ: 378640336
 *
*/

package com.demo.service.services;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.dao.interfaces.IImageDao;
import com.demo.model.models.Account;
import com.demo.model.models.Image;
import com.demo.service.interfaces.IImageService;
import com.infrastructure.project.base.service.services.EnableEntityService;
import com.infrastructure.project.common.utilities.PageList;
import com.infrastructure.project.common.utilities.PageListUtil;

/**
 * 类名: ImageService <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月20日 下午2:02:05 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Service("ImageService")
public class ImageService extends EnableEntityService<Integer, Image, IImageDao> implements IImageService{

	@Autowired
	public ImageService(@Qualifier("ImageDao")IImageDao dao) {
		super(dao);
	}

	@Override
	public PageList<Image> listPage(String name, int pageNo, int pageSize) {
		Criteria countCriteria = entityDao.getCriteria();	
		Criteria listCriteria = entityDao.getCriteria();
		
//		if(name!=null && !name.isEmpty()){
//			countCriteria.add(Restrictions.eq("name", name)); 
//    		listCriteria.add(Restrictions.eq("name", name)); 
//		}

        listCriteria.setFirstResult((pageNo-1)*pageSize);  
        listCriteria.setMaxResults(pageSize);
        List<Image> items = listCriteria.list();
        countCriteria.setProjection(Projections.rowCount());
        Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
        
        return PageListUtil.getPageList(count, pageNo, items, pageSize);
	}

	
}


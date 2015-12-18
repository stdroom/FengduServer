/**
 * 工程名: Zblog
 * 文件名: ImageService.java
 * 包名: com.zblog.service
 * 日期: 2015年11月25日下午5:02:16
 * QQ: 378640336
 *
*/

package com.zblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zblog.core.dal.entity.Image;
import com.zblog.core.dal.mapper.BaseMapper;
import com.zblog.core.dal.mapper.ImageMapper;
import com.zblog.core.plugin.PageModel;

/**
 * 类名: ImageService <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月25日 下午5:02:16 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Service
public class ImageService extends BaseService{

	@Autowired
	private ImageMapper imageMapper;
	
	
	public PageModel<Image> list(int pageIndex, int pageSize){
	    PageModel<Image> page = new PageModel<>(pageIndex, pageSize);
	    super.list(page);
	    return page;
	  }
	
	@Override
	protected BaseMapper getMapper() {
		
		return imageMapper;
	}
	
	public ArrayList<Image> getImageListByColumn(PageModel<Image> model){
		ArrayList<Image> list = imageMapper.getImageListByColumn(model);
		model.setContent(list);
		return list;
	}
	
	public ArrayList<Image> getImageListBySearch(PageModel<Image> model){
		ArrayList<Image> list = imageMapper.getImageListBySearch(model);
		model.setContent(list);
		return list;
	}
	
	public ArrayList<Image> getFavorImageList(PageModel<Image> model){
		ArrayList<Image> list = imageMapper.getFavorImageList(model);
		model.setContent(list);
		return list;
	}
	

}


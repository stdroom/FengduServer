/**
 * ������: spmvc03
 * �ļ���: ImageController.java
 * ����: com.sxt.action
 * ����: 2015��11��18������7:42:30
 * Copyright (c) 2015, �����ֵ� All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.demo.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.model.models.Image;
import com.demo.service.interfaces.IImageService;
import com.demo.service.services.ImageService;
import com.infrastructure.project.common.utilities.PageList;

import utils.StringCompress;

/**
 * ����: ImageController <br/>
 * ����: TODO ��ӹ�������. <br/>
 * ����: 2015��11��18�� ����7:42:30 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController extends BaseController{
	@Autowired
	@Qualifier("ImageService")
	protected IImageService imageService;
	
	@RequestMapping(value="/getImage", method = {RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String getImages(@RequestParam("page") int page,@RequestParam("cataid") int cataid,@RequestParam("pageSize") int pageSize){
		
		PageList<Image> items = imageService.listPage(cataid,0, page, pageSize);
		ArrayList<Image> list= (ArrayList<Image>) items.getItems();
		Map<String,Object> map = new HashMap<String,Object>();
		for(Image ben:list){
			System.out.println(ben.getTitle());
		}
		map.put("status", 1);
		if(list== null || list.size()==0){
			map.put("size", 0);
		}else{
			map.put("size", list.size());
		}
		map.put("data", list);
		return StringCompress.compress(JSON.toJSONString(map));
	}
	
}


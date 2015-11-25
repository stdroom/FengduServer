/**
 * 工程名: Zblog
 * 文件名: ImageController.java
 * 包名: com.zblog.web.backend.controller
 * 日期: 2015年11月25日下午5:05:08
 * QQ: 378640336
 *
*/

package com.zblog.web.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zblog.core.dal.entity.Image;
import com.zblog.core.plugin.PageModel;
import com.zblog.core.util.StringCompress;
import com.zblog.service.ImageService;

/**
 * 类名: ImageController <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月25日 下午5:05:08 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Controller
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/getImage", method = {RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String getImages(@RequestParam("page") int page,@RequestParam("cataid") int cataid,@RequestParam("pageSize") int pageSize){
		PageModel<Image> pageModel = imageService.list(page, pageSize);
		imageService.list(pageModel);
		ArrayList<Image> list= (ArrayList<Image>) pageModel.getContent();
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

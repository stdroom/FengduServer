/**
 * 工程名: SpringMVC3Demo
 * 文件名: ImageController.java
 * 包名: com.demo.web.controllers.api
 * 日期: 2015年11月19日下午3:54:16
 * QQ: 378640336
 *
*/

package com.demo.web.controllers.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.demo.model.models.Image;

/**
 * 类名: ImageController <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月19日 下午3:54:16 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Controller
public class ImageController {

	@RequestMapping(value="/getimages")
	@ResponseBody
	public String getImages(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize) throws Exception{
		ArrayList<Image> list= imageService.getImages(page, pageSize);
		Map<String,Object> map = new HashMap<String,Object>();
		for(Image ben:list){
			System.out.println(new String(ben.getTitle().getBytes("GB2312"),"UTF8"));
		}
		map.put("status", 1);
		if(list== null || list.size()==0){
			map.put("size", 0);
		}else{
			map.put("size", list.size());
		}
		map.put("data", list);
		return JSON.toJSONString(map);
	}
}


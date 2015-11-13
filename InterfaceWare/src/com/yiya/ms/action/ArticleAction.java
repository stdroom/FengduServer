package com.yiya.ms.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiya.common.BaseAction;
import com.yiya.model.ArticalModel;
import com.yiya.ms.service.ArticalService;
import com.yiya.utils.HtmlUtil;

@Controller
@RequestMapping("/artical")
public class ArticleAction extends BaseAction{
	private final static Logger log= Logger.getLogger(ArticleAction.class);
	@Autowired(required=false) 
	private ArticalService<T> articalService; 
	

	 @RequestMapping ( "/getList" )  
	 public void getArticalList(ArticalModel articalModel,HttpServletResponse response,
				HttpServletRequest request) {
		 Map<String, Object> context = new HashMap<String, Object>();
		 List data=null;
		 try {	
			 data=articalService.queryByList(articalModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 context.put("data", data);
		 HtmlUtil.writerJson(response, context);
	    }  
}

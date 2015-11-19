package com.demo.web.controllers;

import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.demo.web.auth.AuthPassport;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;

@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController {  

	//@AuthPassport
    @RequestMapping(value = "/hello")
    public ModelAndView hello() throws EntityOperateException, ValidatException, SQLException { 

    	//UserService userService=new UserService();
    	
    	//userService.delete(2);
    	throw new SQLException("数据库链接错误。");
    	
        //1、收集参数  
        //2、绑定参数到命令对象  
        //3、调用业务对象  
        //4、选择下一个页面  
        /*ModelAndView mv = new ModelAndView();  
        //添加模型数据 可以是任意的POJO对象  
        mv.addObject("message", "Hello World!");  
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面,如果不指定具体得视图，则会根据URL寻找对应的视图
        mv.setViewName("home/hello");  
        return mv;*/
    }  
    
    @AuthPassport
    @RequestMapping(value = "/index")
    public String index() { 	

        return "home/index";
    }  
    
    @RequestMapping(value = "/notfound")
    public ModelAndView notfound() { 
    	
    	ModelAndView mv = new ModelAndView();  
    	mv.setViewName("404");  
    	
    	return mv;  
    }
}  

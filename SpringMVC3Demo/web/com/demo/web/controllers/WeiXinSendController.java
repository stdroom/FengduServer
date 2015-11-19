package com.demo.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.web.auth.AuthPassport;
import com.demo.web.jsonmodels.AccessTokenModel;
import com.demo.web.jsonmodels.ClickBtn;
import com.demo.web.jsonmodels.ViewBtn;
import com.demo.web.models.WXCreateMenuModel;
import com.weixinapi.sender.DefaultSender;
import com.demo.web.jsonmodels.BaseBtn;

@Controller
@RequestMapping(value = "/weixinsend")
public class WeiXinSendController extends BaseController {
	
	@RequestMapping(value="/test", method = {RequestMethod.GET})
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		final DefaultSender defaultSender = DefaultSender.newInstance(); 
		String appid="wx468d07762e99c0d5";
		String secret="040068131817b2661ff50975a9896eb4";
		String ret=defaultSender.getAccessTokenJson(appid, secret);
	}
	
	@AuthPassport
	@RequestMapping(value="/createmenu", method = {RequestMethod.GET})
	public String createMenu(HttpServletRequest request, Model model){
		if(!model.containsAttribute("contentModel")){
            model.addAttribute("contentModel", new WXCreateMenuModel());
        }
        return "weixinsend/createmenu";
	}
	
	@AuthPassport
	@RequestMapping(value="/createmenu", method = {RequestMethod.POST})
	public String createMenu(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") WXCreateMenuModel wxCreateMenuModel, BindingResult result) throws IOException{
		if(result.hasErrors())
            return createMenu(request, model);
		
		String appid="wx468d07762e99c0d5";
		String secret="040068131817b2661ff50975a9896eb4";
		final DefaultSender defaultSender = DefaultSender.newInstance(); 
		String accessTokenJson=defaultSender.getAccessTokenJson(appid, secret);
		
		JSONObject jsonObject = JSONObject.fromObject(accessTokenJson);
		AccessTokenModel accessTokenModel = (AccessTokenModel) JSONObject.toBean(jsonObject, AccessTokenModel.class);
		
		String ret=defaultSender.createMenu(accessTokenModel.getAccess_token(), wxCreateMenuModel.getContent());
		
		return "weixinsend/createmenu";
	}
	
	@AuthPassport
	@RequestMapping(value="/getmenu", method = {RequestMethod.GET})
	public String getMenu(HttpServletRequest request, Model model) throws IOException{
		
		List<BaseBtn> btns=new ArrayList<BaseBtn>();
		
		ClickBtn clickBtn=new ClickBtn();
		clickBtn.setType("click");
		clickBtn.setName("Test clickBtn");
		clickBtn.setKey("a001");
		
		ViewBtn viewBtn=new ViewBtn();
		viewBtn.setType("view");
		viewBtn.setName("Test viewBtn");
		viewBtn.setUrl("www.baidu.com");
		
		btns.add(clickBtn);
		btns.add(viewBtn);
		
		String ret=JSONArray.fromObject(btns, new JsonConfig()).toString();
		model.addAttribute("contentModel", ret);
		
        return "weixinsend/getmenu";
	}
	
}

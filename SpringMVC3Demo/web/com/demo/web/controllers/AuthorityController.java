package com.demo.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import com.demo.model.models.Authority;
import com.demo.web.auth.AuthPassport;
import com.demo.web.models.AuthorityEditModel;
import com.demo.web.models.TreeModel;
import com.demo.web.models.extension.AuthorityModelExtension;
import com.demo.web.models.extension.TreeModelExtension;
import com.infrastructure.project.common.exception.EntityOperateException;
import com.infrastructure.project.common.exception.ValidatException;
import com.infrastructure.project.common.extension.StringHelper;

@Controller
@RequestMapping(value = "/authority")
public class AuthorityController extends BaseController { 
	
	@AuthPassport
	@RequestMapping(value = "/chain", method = {RequestMethod.GET})
	public String chain(HttpServletRequest request, Model model){		
		if(!model.containsAttribute("contentModel")){		
			String expanded = ServletRequestUtils.getStringParameter(request, "expanded", null);
			List<TreeModel> children=TreeModelExtension.ToTreeModels(authorityService.listChain(), null, null, StringHelper.toIntegerList( expanded, ","));		
			List<TreeModel> treeModels=new ArrayList<TreeModel>(Arrays.asList(new TreeModel("0","0","根节点",false,false,false,children)));	
			
			String jsonString  = JSONArray.fromObject(treeModels, new JsonConfig()).toString();
			model.addAttribute("contentModel", jsonString);
		}	
		
		model.addAttribute("requestUrl", request.getServletPath());
		model.addAttribute("requestQuery", request.getQueryString());
		
        return "authority/chain";		
	}
	
	@AuthPassport
	@RequestMapping(value = "/add/{id}", method = {RequestMethod.GET})
	public String add(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id){	
		if(!model.containsAttribute("contentModel")){
			AuthorityEditModel authorityEditModel=new AuthorityEditModel();
			authorityEditModel.setParentId(id);
			model.addAttribute("contentModel", authorityEditModel);
		}
		
		List<TreeModel> treeModels;
		String expanded = ServletRequestUtils.getStringParameter(request, "expanded", null);
		if(id!=null && id>0){
			List<TreeModel> children=TreeModelExtension.ToTreeModels(authorityService.listChain(), id, null, StringHelper.toIntegerList( expanded, ","));
			treeModels=new ArrayList<TreeModel>(Arrays.asList(new TreeModel("0","0","根节点",false,false,false,children)));
		}
		else{
			List<TreeModel> children=TreeModelExtension.ToTreeModels(authorityService.listChain(), null, null, StringHelper.toIntegerList( expanded, ","));
			treeModels=new ArrayList<TreeModel>(Arrays.asList(new TreeModel("0","0","根节点",false,true,false,children)));
		}
		model.addAttribute(treeDataSourceName, JSONArray .fromObject(treeModels, new JsonConfig()).toString());
		
        return "authority/edit";	     
	}
	
	@AuthPassport
	@RequestMapping(value = "/add/{id}", method = {RequestMethod.POST})
    public String add(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AuthorityEditModel editModel, @PathVariable(value="id") Integer id, BindingResult result) throws EntityOperateException, ValidatException {
        if(result.hasErrors())
            return add(request, model, id);
		
        String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
        Authority authority=AuthorityModelExtension.toAuthority(editModel);
        authorityService.save(authority);
        if(returnUrl==null)
        	returnUrl="authority/chain";
    	return "redirect:"+returnUrl;      	
    }
	
	@AuthPassport
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
	public String edit(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws ValidatException{	
		if(!model.containsAttribute("contentModel")){
			AuthorityEditModel authorityEditModel=AuthorityModelExtension.toAuthorityEditModel(authorityService.get(id));
			model.addAttribute("contentModel", authorityEditModel);
		}

		List<TreeModel> treeModels;
		AuthorityEditModel editModel=(AuthorityEditModel)model.asMap().get("contentModel");
		String expanded = ServletRequestUtils.getStringParameter(request, "expanded", null);
		if(editModel.getParentId()!=null && editModel.getParentId()>0){
			List<TreeModel> children=TreeModelExtension.ToTreeModels(authorityService.listChain(), editModel.getParentId(), null, StringHelper.toIntegerList( expanded, ","));
			treeModels=new ArrayList<TreeModel>(Arrays.asList(new TreeModel("0","0","根节点",false,false,false,children)));
		}
		else{
			List<TreeModel> children=TreeModelExtension.ToTreeModels(authorityService.listChain(), null, null, StringHelper.toIntegerList( expanded, ","));
			treeModels=new ArrayList<TreeModel>(Arrays.asList(new TreeModel("0","0","根节点",false,true,false,children)));
		}
		model.addAttribute(treeDataSourceName, JSONArray.fromObject(treeModels, new JsonConfig()).toString());
		
        return "authority/edit";	
	}
	
	@AuthPassport
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.POST})
    public String edit(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AuthorityEditModel editModel, @PathVariable(value="id") Integer id, BindingResult result) throws EntityOperateException, ValidatException {
        if(result.hasErrors())
            return edit(request, model, id);
        
        String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
        Authority authority=AuthorityModelExtension.toAuthority(editModel);
        authority.setId(id);
        authorityService.update(authority);
        if(returnUrl==null)
        	returnUrl="authority/chain";
    	return "redirect:"+returnUrl;      	
    }
	
	@AuthPassport
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET})
	public String delete(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) throws ValidatException, EntityOperateException{	
		authorityService.delete(id);
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		if(returnUrl==null)
        	returnUrl="authority/chain";
        return "redirect:"+returnUrl;	
	}
	
}  

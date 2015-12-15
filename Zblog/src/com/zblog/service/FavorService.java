package com.zblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zblog.core.dal.entity.Favor;
import com.zblog.core.dal.entity.User;
import com.zblog.core.dal.mapper.BaseMapper;
import com.zblog.core.dal.mapper.FavorMapper;
import com.zblog.core.dal.mapper.UserMapper;
import com.zblog.core.plugin.PageModel;

@Service
public class FavorService{
  @Autowired
  private FavorMapper favorMapper;

  public PageModel<Favor> list(int pageIndex, int pageSize){
    PageModel<Favor> page = new PageModel<>(pageIndex, pageSize);
    return page;
  }
  
 
  public void insertFavor(Favor favor){
	  favorMapper.insertFavor(favor);
  }
  
  public void updateFavor(Favor favor){
	  favorMapper.updateFavor(favor);
  }
  
  public Favor findFavorByImeiImgId(Favor favor){
	 return favorMapper.findFavorByImeiImgId(favor);
  }

}

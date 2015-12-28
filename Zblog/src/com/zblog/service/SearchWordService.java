/**
 * 工程名: Zblog
 * 文件名: SearchWordService.java
 * 包名: com.zblog.service
 * 日期: 2015年12月26日下午12:43:00
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.zblog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zblog.core.dal.entity.SearchWord;
import com.zblog.core.dal.mapper.BaseMapper;
import com.zblog.core.dal.mapper.SearchWordMapper;

/**
 * 类名: SearchWordService <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年12月26日 下午12:43:00 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Service
public class SearchWordService extends BaseService{

	@Autowired
	private SearchWordMapper searchWordMapper;

	@Override
	protected BaseMapper getMapper() {
		return searchWordMapper;
	}
	
	public ArrayList<SearchWord> getSearchWords(int appid){
		return searchWordMapper.getSearchWords(appid);
	}
	
	public void insertSearch(SearchWord search){
		searchWordMapper.insertSearch(search);
	}
}


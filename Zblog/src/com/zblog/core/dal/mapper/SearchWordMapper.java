/**
 * 工程名: Zblog
 * 文件名: SearchWordMapper.java
 * 包名: com.zblog.core.dal.mapper
 * 日期: 2015年12月26日下午12:40:42
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.mapper;

import java.util.ArrayList;

import com.zblog.core.dal.entity.SearchWord;
import com.zblog.core.plugin.PageModel;

/**
 * 类名: SearchWordMapper <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年12月26日 下午12:40:42 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface SearchWordMapper extends BaseMapper{

	ArrayList<SearchWord> getSearchWords(int appid);
	void insertSearch(SearchWord search);
}


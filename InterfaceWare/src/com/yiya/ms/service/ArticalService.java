package com.yiya.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.common.BaseMapper;
import com.yiya.common.BaseService;
import com.yiya.ms.mapper.ArticalMapper;

@Service("articalService")
public class ArticalService<T> extends BaseService<T>{
	@Autowired
	private ArticalMapper<T> articalMapper;

	@Override
	public ArticalMapper<T> getMapper() {
		return articalMapper;
	}


}

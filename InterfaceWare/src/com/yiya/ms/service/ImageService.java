package com.yiya.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiya.common.BaseService;
import com.yiya.ms.mapper.ImageMapper;

@Service("imageService")
public class ImageService<T> extends BaseService<T>{
	@Autowired
	private ImageMapper<T> imageMapper;

	@Override
	public ImageMapper<T> getMapper() {
		return imageMapper;
	}


}

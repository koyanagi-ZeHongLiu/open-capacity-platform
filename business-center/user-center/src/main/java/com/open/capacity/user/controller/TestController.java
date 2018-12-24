package com.open.capacity.user.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.ApplicationInfoManager;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
* @version 创建时间：2017年11月12日 上午22:57:51
 */
@RestController
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
	@Resource
	private ApplicationInfoManager  applicationInfoManager ;
	
	@Resource
	private ObjectMapper objectMapper; // springmvc启动时自动装配json处理类
	
	@GetMapping("/test111")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/invoke")
	public String invoke() throws JsonProcessingException{
		return objectMapper.writeValueAsString(applicationInfoManager.getInfo().getMetadata()) ;
	}

	 
}

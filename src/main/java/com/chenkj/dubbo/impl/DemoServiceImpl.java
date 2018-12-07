package com.chenkj.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chenkj.dubbo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "hello "+name;
	}

}

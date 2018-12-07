package com.chenkj.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chenkj.dubbo.service.DemoService2;

@Service
public class DemoServiceImpl2 implements DemoService2 {

	@Override
	public String sayHello(String name) {
		return "hello "+name;
	}

}

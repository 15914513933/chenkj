package com.chenkj.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;

public class ShiroUtil {
	//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
	private static Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    //2、得到SecurityManager实例 并绑定给SecurityUtils   
	private static org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
	static{
		SecurityUtils.setSecurityManager(securityManager);
	}
	
}

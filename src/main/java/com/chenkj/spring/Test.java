package com.chenkj.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	private static final Log log = LogFactory.getLog(Test.class); 
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		HelloWorld h = (HelloWorld)context.getBean("helloWorld");
		System.out.println(h.hello());
		log.debug("chenkj");
	}
}

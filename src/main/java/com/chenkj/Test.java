package com.chenkj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chenkj.dubbo.service.DemoService;

import redis.clients.jedis.Jedis;

public class Test {
	public static void main(String[] args) throws Exception {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService");
        String hello = demoService.sayHello("world");
        System.out.println(hello);*/
        //context.close();
        
        
        Jedis jedis = new Jedis("192.168.164.128", 22121);
        jedis.set("name2", "chenkj2");
        System.out.println(jedis.get("name2"));
        jedis.close();
    }
}

package com.chenkj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenkj.ehcache.EhcacheService;
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })  
@RunWith(SpringJUnit4ClassRunner.class)  
public class JunitTest extends AbstractJUnit4SpringContextTests {
	@Autowired 
	private EhcacheService ehcacheService;
	
	@Test
    public void testTimestamp() throws InterruptedException{
		System.out.println("第一次调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehcacheService.getTimestamp("param"));
    }
	
}

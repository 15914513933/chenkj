package com.chenkj;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenkj.model.User;
import com.chenkj.util.RedisUtil;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })  
@RunWith(SpringJUnit4ClassRunner.class)  
public class JunitTest extends AbstractJUnit4SpringContextTests {
	@Autowired 
	private RedisTemplate<String,Object> redisTemplate;
	
/*	@Test
    public void testTimestamp() throws InterruptedException{
		RedisUtil redis = new RedisUtil();
		//redis.setRedisTemplate(redisTemplate);
		redis.set("name", new User("22","33"));
    }
*/	
	@Test
	public void testHelloworld() {
	    //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
		Factory<org.apache.shiro.mgt.SecurityManager> factory =
	            new IniSecurityManagerFactory("classpath:shiro.ini");
	    //2、得到SecurityManager实例 并绑定给SecurityUtils   
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
	    Subject subject = SecurityUtils.getSubject();
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1223");
	    try {
	        //4、登录，即身份验证
	        subject.login(token);
	        System.out.println("success");
	    } catch (AuthenticationException e) {
	    	System.out.println("fail");
	        //5、身份验证失败
	    }
	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
	    //6、退出
	    subject.logout();
	}
	
	
}

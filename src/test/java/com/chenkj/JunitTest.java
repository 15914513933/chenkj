package com.chenkj;

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
	
	@Test
    public void testTimestamp() throws InterruptedException{
		RedisUtil redis = new RedisUtil();
		redis.setRedisTemplate(redisTemplate);
		redis.set("name", new User("22","33"));
    }
	
}

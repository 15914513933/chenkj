package com.chenkj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chenkj.model.User;
import com.chenkj.result.ResultBean;
import com.chenkj.service.impl.UserServiceImpl;
import com.chenkj.util.CheckCodeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {
	private static Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
	private static SecurityManager securityManager = factory.getInstance();
	static{
		SecurityUtils.setSecurityManager(securityManager);
	}
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/public/login")
	public String login(HttpServletRequest req,HttpServletResponse resp){
		
		/*Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies){
			System.out.println(c.getValue());;
		}*/
		
		HttpSession session = req.getSession(true);
		System.out.println(session.getId());
		
		return "admin/login";
	}
	
	@RequestMapping(value = "/public/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> doLogin(User user,HttpSession session,HttpServletResponse resp,String checkCode){
		ResultBean<String> result = new ResultBean<String>("success");
		String session_checkcode = (String)session.getAttribute(CheckCodeUtil.CHECKCODE_SESSION);
		/*if(!session_checkcode.equals(checkCode)){
			result.setMsg("验证码错误！");
			return result;
		}*/
		/*User loginUser = userService.checkUser(user);
		if(loginUser==null||user.getPassword().equals(DigestUtils.sha256Hex(session_checkcode)+loginUser.getPassword())){
			result.setMsg("账号或密码错误！");
			return result;
		}else if(loginUser.getStatus()==-1){
			result.setMsg("账号已被冻结，请联系管理员！");
			return result;
		}else{
			session.setAttribute("USER_SESSION",loginUser);
			session.removeAttribute(CheckCodeUtil.CHECKCODE_SESSION);
		}*/
	    Subject subject = SecurityUtils.getSubject();
	    UsernamePasswordToken token = new UsernamePasswordToken(user.getUserid(), user.getPassword());
	    try {
	        subject.login(token);
	    } catch (AuthenticationException e) {
	    	result.setMsg("账号或密码错误！");
			return result;
	    }
	    session.setAttribute("USER_SESSION",user);
		session.removeAttribute(CheckCodeUtil.CHECKCODE_SESSION);
		
		Map<Object,Object> map = new HashMap<>();
		Map<Object,Object> map2 = new HashMap<>(map);
		
		return result;
	}
	
	@RequestMapping("/user/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/public/login";
	}
	
	@RequestMapping("/user/list")
	public String userlist(){
		return "admin/user/userlist";
	}
	
	@RequestMapping("/page/user/add")
	public String addUser(){
		return "admin/user/useradd";
	}
	
	@RequestMapping("/page/user/myInfo")
	public String myInfo(@RequestParam(value = "userid") String userid,HttpServletRequest req){
		List<User> users = userService.getUsers(new User(userid));
		req.setAttribute("myInfo", users.get(0));
		return "admin/user/myinfo";
	}
	
	@RequestMapping("/page/user/edit")
	public String editUser(@RequestParam(value = "userid") String userid,HttpServletRequest req){
		List<User> users = userService.getUsers(new User(userid));
		req.setAttribute("userInfo", users.get(0));
		return "admin/user/useredit";
	}
	@RequestMapping("/page/user/import")
	public String importUser(){
		return "admin/user/userimport";
	}
	
	@RequestMapping(value = "/user/addUser",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> addUser(User user){
		ResultBean<String> result = new ResultBean<String>();
		try{
			if(userService.checkUser(user)!=null){
				result.setMsg("账号已存在！");
			}else{
				boolean isSuccess = userService.addUser(user);
				if(!isSuccess){
					result.setMsg("保存失败！");
				}
			}
		}catch(Exception e){
			result.setMsg(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/user/editUser",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> editUser(User user){
		ResultBean<String> result = new ResultBean<String>();
		try{
			if(!userService.editUser(user)){
				result.setMsg("保存失败！");
			}
		}catch(Exception e){
			result.setMsg(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/user/delUsers",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> delUsers(@RequestParam(value = "userids[]") String[] userids){
		ResultBean<String> result = new ResultBean<String>();
		try{
			if(!userService.delUsers(userids)){
				result.setMsg("删除失败！");
			}
		}catch(Exception e){
			result.setMsg(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/user/getUsers")
	@ResponseBody
	public ResultBean<List<User>> getUsers(String params,int pageNum,int pageSize){
		JSONObject paramsObject = JSONObject.parseObject(params);
		String userid = null;
		String name = null;
		int sex = -1;
		if(paramsObject!=null){
			if(paramsObject.containsKey("userid")){
				userid = paramsObject.getString("userid");
			}
			if(paramsObject.containsKey("name")){
				name = paramsObject.getString("name");
			}
			if(paramsObject.containsKey("sex")){
				sex = paramsObject.getIntValue("sex");
			}
		}
		PageHelper.startPage(pageNum, pageSize);
		User user = new User();
		user.setUserid(userid);
		user.setName(name);
		user.setSex(sex);
		List<User> users = userService.getUsers(user);
		PageInfo<User> pageInfo =new PageInfo<User>(users);
		return new ResultBean<List<User>>(pageInfo.getList(),pageInfo.getTotal());
	}
	
}

package com.chenkj.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenkj.model.User;
import com.chenkj.result.ResultBean;
import com.chenkj.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/login")
	public String login(HttpSession session){
		return "admin/login";
	}
	
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> doLogin(User user,HttpSession session,HttpServletResponse resp){
		ResultBean<String> result = new ResultBean<String>("success");
		User loginUser = userService.checkUser(user);
		if(loginUser==null){
			result.setMsg("账号或密码错误！");
		}else{
			session.setAttribute("USER_SESSION",loginUser);
		}
		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/user/login";
	}
	
	@RequestMapping("/list")
	public String userlist(){
		return "admin/user/userlist";
	}
	
	@RequestMapping("getUsers")
	@ResponseBody
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
}

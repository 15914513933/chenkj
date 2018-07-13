package com.chenkj.controller;

import java.util.List;

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
import com.chenkj.util.CheckCodeUtil;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/public/login")
	public String login(HttpSession session){
		return "admin/login";
	}
	
	@RequestMapping(value = "/public/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> doLogin(User user,HttpSession session,HttpServletResponse resp,String checkCode){
		ResultBean<String> result = new ResultBean<String>("success");
		String session_checkcode = (String)session.getAttribute(CheckCodeUtil.CHECKCODE_SESSION);
		if(!session_checkcode.equals(checkCode)){
			result.setMsg("验证码错误！");
		}else{
			User loginUser = userService.checkUser(user);
			if(loginUser==null){
				result.setMsg("账号或密码错误！");
			}else{
				session.setAttribute("USER_SESSION",loginUser);
				session.removeAttribute(CheckCodeUtil.CHECKCODE_SESSION);
			}
		}
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
	
	@RequestMapping("/usergetUsers")
	@ResponseBody
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
}

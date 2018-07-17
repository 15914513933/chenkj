package com.chenkj.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		/*if(!session_checkcode.equals(checkCode)){
			result.setMsg("验证码错误！");
			return result;
		}*/
		User loginUser = userService.checkUser(user);
		if(loginUser==null||user.getPassword().equals(DigestUtils.sha256Hex(session_checkcode)+loginUser.getPassword())){
			result.setMsg("账号或密码错误！");
			return result;
		}else if(loginUser.getStatus()==-1){
			result.setMsg("账号已被冻结，请联系管理员！");
			return result;
		}else{
			session.setAttribute("USER_SESSION",loginUser);
			session.removeAttribute(CheckCodeUtil.CHECKCODE_SESSION);
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
	
	@RequestMapping("/page/user/add")
	public String addUser(){
		return "admin/user/useradd";
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
	
	@RequestMapping(value = "/user/delUsers",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<String> delUsers(String userid){
		ResultBean<String> result = new ResultBean<String>();
		try{
			String[] userids = new String[]{userid};
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

package com.chenkj.controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenkj.util.CheckCodeUtil;

@Controller
public class CheckCodeController {
	@RequestMapping("/public/checkCode")
	public void login(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		ImageIO.write(CheckCodeUtil.createImage(req.getSession()), "JPG", resp.getOutputStream()); 
	}
}

package com.chenkj.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenkj.mapper.UserMapper;
import com.chenkj.model.User;
import com.chenkj.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User insertUser(User user) {
		userMapper.insertUser(user);
		return user;
	}
	
	@Override
	public List<User> getUsers() {
		return userMapper.getUsers();
	}

	@Override
	public User checkUser(User user) {
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
		return userMapper.checkUser(user);
	}

}

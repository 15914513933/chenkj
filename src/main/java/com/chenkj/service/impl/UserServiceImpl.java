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
	public boolean addUser(User user) throws Exception{
		if(userMapper.insertUser(user)>0){
			return true;
		}
		return false;
	}
	
	@Override
	public List<User> getUsers(User user) {
		return userMapper.getUsers(user);
	}

	@Override
	public User checkUser(User user) {
		return userMapper.checkUser(user);
	}

	@Override
	public boolean delUsers(String[] userids) throws Exception {
		return userMapper.delUsers(userids);
	}

	@Override
	public boolean editUser(User user) throws Exception {
		return userMapper.editUser(user);
	}

}

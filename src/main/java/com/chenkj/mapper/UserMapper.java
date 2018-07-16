package com.chenkj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chenkj.model.User;

@Component
public interface UserMapper {
	void insertUser(User user);
	List<User> getUsers(User user);
	User checkUser(User user);
}

package com.chenkj.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chenkj.model.User;

@Component
public interface UserMapper {
	int insertUser(User user);
	List<User> getUsers(User user);
	User checkUser(User user);
	boolean delUsers(String[] userids);
	boolean editUser(User user);
}

package com.chenkj.service;

import java.util.List;

import com.chenkj.model.User;

public interface UserService {
	boolean addUser(User user) throws Exception;
	boolean editUser(User user) throws Exception;
	List<User> getUsers(User user);
	User checkUser(User user);
	boolean delUsers(String[] userids) throws Exception;
}

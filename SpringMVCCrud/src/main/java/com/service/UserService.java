package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	
	public boolean RegisterUser(User users);
	public List<User> LoginUser(User users);
	public User sendMail(String from, User users, String subject, String msg);

}

package com.dao;

import java.util.List;

import com.entity.User;

public interface UserServiceDao {
	public boolean saveorupdate(User users);
    public List<User> LoginUser(User users);
}

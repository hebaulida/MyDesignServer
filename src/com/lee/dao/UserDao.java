package com.lee.dao;

import com.lee.bean.User;

public abstract class UserDao {
	User user;
	public abstract void save();
	public abstract void select();
	public abstract void delete();
	public abstract void update();
}

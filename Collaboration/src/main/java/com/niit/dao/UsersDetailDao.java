package com.niit.dao;

import java.util.List;

import com.niit.model.UsersDetail;

public interface UsersDetailDao {

	public void addUser(UsersDetail usersDetail);

	public boolean deleteUser(UsersDetail usersDetail);

	
	public UsersDetail getUserById(int userId);

	public UsersDetail getUserByUsername(String username);

	public List<UsersDetail> getAllUsers();

	public int validateUser(String username, String password);
	
	public boolean isValidUser(String name);
}
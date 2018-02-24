package com.MavenProject.SmartBookBorrow.service;

import com.MavenProject.SmartBookBorrow.dao.UserDAO;
import com.MavenProject.SmartBookBorrow.model.User;

public class UserService {
	private UserDAO userDAO;
	
	public UserService()
	{
		userDAO = UserDAO.getInstance();
	}
	
	public User getUser(int id) {
		return userDAO.getUser(id);
	}
	
	public User addUser(User user) {
		int id =  userDAO.addUser(user);
		user.setUserId(id);
		return user;
	}
}

package com.feedback.app.service;

import java.util.List;

import com.feedback.app.model.User;

public interface UserService {
	public List<User> getUsers();
	public User getUserById(String userid);
	public int save(User user);
	public User login(String userid,String password);
}

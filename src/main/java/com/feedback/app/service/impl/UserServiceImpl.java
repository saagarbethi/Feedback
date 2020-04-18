package com.feedback.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.app.dao.UserDao;
import com.feedback.app.model.User;
import com.feedback.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	
	@Override
	public List<User> getUsers() {
		return dao.getUsers();
	}
	
	@Override
	public User getUserById(String userid) {
		return dao.getUserById(userid);
	}

	@Override
	public int save(User user) {
		if(user.getUserid()==null) {
			String userid = dao.generateUserId();
			user.setUserid(userid);
			return dao.save(user);
		}else {
			return dao.update(user);
		}
	}

	@Override
	public User login(String userid, String password) {
		 return dao.login(userid, password);
	}
	

}

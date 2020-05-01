package com.feedback.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.app.helper.SuccessMessage;
import com.feedback.app.model.EmptyJson;
import com.feedback.app.model.User;
import com.feedback.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService user;
	
	@Autowired
	SuccessMessage message;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Feedback Solutions";
	}
	
	@GetMapping("/user")
	public List<User> getUsers(){
		return user.getUsers();
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<Object> getUserById(@PathVariable("userid") String userid){
		User users =  user.getUserById(userid);
		if(users==null) {
			return new ResponseEntity<>(new EmptyJson(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(users,HttpStatus.OK);
		}
	}
	
	@PostMapping(path="/user/save",consumes = "application/json")
	public ResponseEntity<Object> save(@RequestBody User users){
		int save = user.save(users);
		return new ResponseEntity<>(message.success(users.getUserid()),HttpStatus.OK);
	}
	
	@PostMapping(path="/user/login",consumes = "application/json")
	public ResponseEntity<Object> login(@RequestBody User loginuser){
		User users = user.login(loginuser.getUserid(), loginuser.getPassword());
		if(users==null) {
			return new ResponseEntity<>(new EmptyJson(),HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(users,HttpStatus.OK);
		}
	}
}

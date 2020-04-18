package com.feedback.app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	private String first_name;
	
	private String last_name;
	
	private String middle_name;
	
	private String mobile;
	
	private String emailid;
	
	private String userid;
	
	private String password;
	
	public User(String first_name,String last_name,String middle_name,String mobile,String emailid,String userid) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.middle_name = middle_name;
		this.mobile = mobile;
		this.emailid = emailid;
		this.userid = userid;
	}
	
}

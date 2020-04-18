package com.feedback.app.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.app.model.SuccessModel;

@Service
public class SuccessMessage {

	
	@Autowired
	HelperService service;
	
	public SuccessModel success(String id) {
		return new SuccessModel(service.getDateTime(),"Record Saved Successfully","200",id);
	}
	
}

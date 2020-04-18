package com.feedback.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SuccessModel {
	
	private String timestamp;

	private String message;
	
	private String statusCode;
	
	private String id;

}

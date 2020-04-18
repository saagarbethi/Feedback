package com.feedback.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Patient {
	
	private String uhid;   
	
	private String admissionno;      
	
	private String patientname ;   
	
	private String age;          
	
	private String gender;       
	
	private String address;      
	
	private String mobileno1;       
	
	private String mobileno2 ;     
	
	private String relativenm;    
	
	private String bedno     ;  
	
	private String roomno    ;  
	
	private String floorno   ;   
}

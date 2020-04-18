package com.feedback.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.app.service.PatientService;
import com.feedback.app.helper.SuccessMessage;
import com.feedback.app.model.EmptyJson;
import com.feedback.app.model.Patient;

@RestController
public class PatientController {
	
	@Autowired
	PatientService patService;
	
	@Autowired
	SuccessMessage message;
	
 
	@GetMapping("/patient")
	public ResponseEntity<Object> getPatients(){
		List<Patient> patients = patService.getPatients();
		if(patients.isEmpty()) {
			return new ResponseEntity<>(new EmptyJson(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(patients,HttpStatus.OK);
			
		}
	}
	
	@GetMapping("/patient/{key}/{value}")
	public ResponseEntity<Object> getPatientById(@PathVariable("key") String key,@PathVariable("value") String value){
		List<Patient> patients = patService.getPatientById(key, value);
		if(patients.isEmpty()) {
			return new ResponseEntity<>(new EmptyJson(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(patients,HttpStatus.OK);
		}
	}
	
	@PostMapping(path="/patient/save", consumes = "application/json")
	public ResponseEntity<Object> save(@RequestBody Patient patient){
		int res = patService.save(patient);
		return new ResponseEntity<>(message.success(patient.getUhid()),HttpStatus.OK);
	}
	
}

package com.feedback.app.service;

import java.util.List;

import com.feedback.app.model.Patient;

public interface PatientService {
	public List<Patient> getPatients();
	public List<Patient> getPatientById(String key,String value);
	public int save(Patient patient);
}

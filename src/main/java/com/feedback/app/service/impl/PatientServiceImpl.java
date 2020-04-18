package com.feedback.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.app.dao.PatientDao;
import com.feedback.app.model.Patient;
import com.feedback.app.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientDao patDao;

	@Override
	public List<Patient> getPatients() {
		return patDao.getPatients();
	}

	@Override
	public List<Patient> getPatientById(String key, String value) {
		return patDao.getPatientById(key, value);
	}

	@Override
	public int save(Patient patient) {
		return patDao.save(patient);
	}

}

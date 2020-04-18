package com.feedback.app.dao;

import java.util.List;

import com.feedback.app.model.Patient;

public interface PatientDao {
 List<Patient> getPatients();
 List<Patient> getPatientById(String key,String value);
 int save(Patient patient);
}

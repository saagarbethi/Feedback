package com.feedback.app.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.feedback.app.dao.PatientDao;
import com.feedback.app.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Patient> getPatients() {
		String sql = "select * from Admission_info ";
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		List<Patient> ls_patient = new ArrayList<>();
		for(Map<String, Object> row : rows) {
			Patient patient = new Patient();
			patient.setUhid((String)row.get("uhid"));
			patient.setAdmissionno((String)row.get("admissionno"));
			patient.setPatientname((String)row.get("patientname"));
			patient.setAge((String)row.get("age"));
			patient.setGender((String)row.get("gender"));
			patient.setAddress((String)row.get("address"));
			patient.setMobileno1((String)row.get("mobileno1"));
			patient.setMobileno2((String)row.get("mobileno2"));
			patient.setRelativenm((String)row.get("relativenm"));
			patient.setBedno((String)row.get("bedno"));
			patient.setFloorno((String)row.get("floorno"));
			patient.setRoomno((String)row.get("roomno"));
			ls_patient.add(patient);
			
		}
		return ls_patient;
	}

	@Override
	public List<Patient> getPatientById(String key,String value) {
		String sql = "select * from Admission_info where "+key+" like '%"+value+"%'";
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		List<Patient> ls_patient = new ArrayList<>();
		for(Map<String, Object> row : rows) {
			Patient patient = new Patient();
			patient.setUhid((String)row.get("uhid"));
			patient.setAdmissionno((String)row.get("admissionno"));
			patient.setPatientname((String)row.get("patientname"));
			patient.setAge((String)row.get("age"));
			patient.setGender((String)row.get("gender"));
			patient.setAddress((String)row.get("address"));
			patient.setMobileno1((String)row.get("mobileno1"));
			patient.setMobileno2((String)row.get("mobileno2"));
			patient.setRelativenm((String)row.get("relativenm"));
			patient.setBedno((String)row.get("bedno"));
			patient.setFloorno((String)row.get("floorno"));
			patient.setRoomno((String)row.get("roomno"));
			ls_patient.add(patient);
			
		}
		return ls_patient;
	}

	@Override
	public int save(Patient patient) {
		String sql = "insert into Admission_info(UHID,ADMISSIONNO, PATIENTNAME ,  AGE, GENDER , ADDRESS,MOBILENO1,  MOBILENO2,  RELATIVENM,BEDNO,ROOMNO,FLOORNO)" + 
				" values(?,?,?,?,?,?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql,
				patient.getUhid(),
				patient.getAdmissionno(),
				patient.getPatientname(),
				patient.getAge(),
				patient.getGender(),
				patient.getAddress(),
				patient.getMobileno1(),
				patient.getMobileno2(),
				patient.getRelativenm(),
				patient.getBedno(),
				patient.getRoomno(),
				patient.getFloorno());
		return result;
	}

}

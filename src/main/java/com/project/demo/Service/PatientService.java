package com.project.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.project.demo.Entity.Patient;
import com.project.demo.Repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public Patient getByid(int pid) {

		return patientRepository.getById(pid);
	}

	public Patient save(Patient patient) {
		return patientRepository.save(patient);

	}

	public int deleteById(int pid) {
		patientRepository.deleteById(pid);
		return pid;

	}

	
}

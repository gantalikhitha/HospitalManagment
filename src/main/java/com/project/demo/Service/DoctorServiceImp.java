package com.project.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.Patient;
import com.project.demo.Entity.UserEntity;
import com.project.demo.Repository.DoctorRepository;

@Service
public class DoctorServiceImp{
	
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor getByid(int did) {
		return doctorRepository.getById(did);
	}

	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
		}

	public int deleteByDid(int did) {
		 doctorRepository.deleteById(did);
		 return did;
	
	}

	
	
	
	  
	 

	

	
	

}

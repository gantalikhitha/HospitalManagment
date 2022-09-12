package com.project.demo.Service;

import java.util.List;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.demo.Domain.UserDomain;
import com.project.demo.Entity.Appointment;
import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.Patient;
import com.project.demo.Entity.UserEntity;

@Service
public interface HospitalService  {

	UserDomain save(UserDomain hospital);
	UserEntity getByhid(int hid);
    List<UserDomain> getall();
    ResponseEntity<UserDomain> updateHospitalDetails(UserEntity hos);
    String deleteByid(int hid);
	UserEntity getByHname(String hname);
	Doctor save(Doctor doctor);
	Patient save(Patient patient);
	Appointment save(Appointment appo);
	
	 // UserEntity getByemail(String email); 
	 UserEntity findByemail(String email);
	 // UserEntity getByEmail(String email);
	 
	
	
	
	
	
	
	
	

	

	

}

package com.project.demo.Service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.demo.Domain.UserDomain;
import com.project.demo.Entity.Appointment;

import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.Patient;
import com.project.demo.Entity.UserEntity;
import com.project.demo.Repository.AppointmentRepository;
import com.project.demo.Repository.DoctorRepository;
import com.project.demo.Repository.HospitalRepository;
import com.project.demo.Repository.PatientRepository;

@Service
public class HospitalserviceImp implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	ModelMapper modelMapper = new ModelMapper();

	public UserDomain save(UserDomain domain) {
		
		// Convert domain to entity
		UserEntity request = modelMapper.map(domain, UserEntity.class);
		
		/*
		 * Doctor obj= request.getDoctor(); obj.setHospital(request);
		 * 
		 * Patient pa=request.getPatient(); pa.setHospital(request);
		 * 
		 * Appointment ap=request.getAppointment(); ap.setHospital(request);
		 */
		 
		UserEntity entity = hospitalRepository.save(request);
		// Convert entity to domain
		UserDomain h = modelMapper.map(entity, UserDomain.class);
		//new ResponseEntity<HospitalDomain>(h, HttpStatus.CREATED);
		return h;
		
	
		
			
	}

	@Override
	public UserEntity getByhid(int hid)  {
		
		return hospitalRepository.getByhid(hid);
	}

	@Override
	public List<UserDomain> getall() {
		
			List<UserEntity> h5=hospitalRepository.findAll();
			return h5.stream().map(x->modelMapper.map(x,UserDomain.class)).collect(Collectors.toList());
					
		

		 
	}

	@Override
	public ResponseEntity<UserDomain> updateHospitalDetails(UserEntity hos) {
		
		
			
		UserEntity request = modelMapper.map(hos, UserEntity.class);
		UserEntity entity = hospitalRepository.save(request);
		// convert entity to domain
		UserDomain hospitalDomain = modelMapper.map(entity, UserDomain.class);
		return ResponseEntity.ok().body(hospitalDomain);
	}

	@Override
	public String deleteByid(int hid) {
		hospitalRepository.deleteById(hid);
		return "delete";
	}

	
	/*
	 * @Override public UserDomain getByHname(String hname) { UserEntity
	 * request=hospitalRepository.findByHname(hname); UserDomain
	 * domain=modelMapper.map(request, UserDomain.class); return domain; }
	 */

	@Override
	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
		
	}

	@Override
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Appointment save(Appointment appo) {
		return appointmentRepository.save(appo);
	}

	
	
	  @Override 
	  public UserEntity getByHname(String hname) {
	  
	  return hospitalRepository.findByname(hname);
	  }

		
		  @Override public UserEntity findByemail(String email) { 
		  return hospitalRepository.findByemail(email); }
		 
		
		/*
		 * @Override public UserEntity getByEmail(String email) {
		 * 
		 * return hospitalRepository.findByEmail(email); }
		 */

	
	
	
	
	

	
	
	}

	

	

	
	

	
	



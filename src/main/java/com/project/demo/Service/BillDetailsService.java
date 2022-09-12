package com.project.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Entity.BillDetails;
import com.project.demo.Entity.Patient;
import com.project.demo.Repository.BillDetailsRepository;

@Service
public class BillDetailsService {
	@Autowired 
	private HospitalService hospitalService;
	
	@Autowired
	private PatientService patientservice;
	
	@Autowired private BillDetailsRepository billDetailsRepository;
	  

	public BillDetails save(BillDetails billDetails) {
		Patient patient=patientservice.getByid(1);
		billDetails.setPatient(patient);
		return billDetailsRepository.save(billDetails);
		
	}


	public BillDetails getByid(int bid) {
		
		return billDetailsRepository.getById(bid);
	}

}

package com.project.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.Entity.Appointment;
import com.project.demo.Entity.Patient;
import com.project.demo.Repository.AppointmentRepository;
import com.project.demo.Repository.PatientRepository;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@GetMapping("/doctorhome")
	public String doctor() {
		return "Doctor_home";
	}
	
	
	
	@GetMapping("/patientdetails")
	public String allPatients(Model model) {
		List<Patient> patient=patientRepository.findAll();
		model.addAttribute("pat", patient);
		return "allpatients";
		
	}
	@GetMapping("/appointmentdetails")
	public String getAllAppointments(Model model) {
		List<Appointment> hospital = appointmentRepository.findAll();
		model.addAttribute("appo", hospital);
		return "allappointments";
	}
	
	

}

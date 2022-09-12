package com.project.demo.Controller;

import java.security.Principal;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.Email.EmailSenderService;
import com.project.demo.Entity.Appointment;
import com.project.demo.Entity.Patient;

import com.project.demo.Entity.UserEntity;
import com.project.demo.Repository.AppointmentRepository;
import com.project.demo.Repository.PatientRepository;
import com.project.demo.Service.AppointmentService;
import com.project.demo.Service.HospitalService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private AppointmentRepository appointmentRepository;
	

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/userhome")
	public String get() {
		return "user_home";
	}

	@GetMapping("/appo")
	public String appointment() {
		return "appointment";
	}

	@PostMapping("/add")
	public String appointment(@ModelAttribute Appointment appointment, Principal principal) {
		UserEntity user = hospitalService.findByemail(principal.getName());
		List<Patient> pp = patientRepository.findAll();
		for (Patient p : pp) {
			patientRepository.getById(p.getPid());
			appointment.setPatient(p);
			appointment.setHospital(user);
			appointment.setAppointmentstatus("pending");
			appointmentService.save(appointment);
		}
		
		return "redirect:/user/allappointments";

	}

	@GetMapping("/allappointments")
	public String getAllAppointments(Model model) {
		List<Appointment> hospital = appointmentRepository.findAll();
		model.addAttribute("appo", hospital);
		return "allappointments";
	}
	
}

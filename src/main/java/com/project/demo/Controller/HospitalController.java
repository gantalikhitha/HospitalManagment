package com.project.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.Domain.UserDomain;
import com.project.demo.Email.EmailSenderService;
import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.UserEntity;
import com.project.demo.Repository.DoctorRepository;
import com.project.demo.Repository.HospitalRepository;
import com.project.demo.Service.HospitalService;

@Controller
@RequestMapping("/hos")
public class HospitalController {

	@Autowired
	private HospitalService hospitalservice;
	@Autowired
	private HospitalRepository hospitalRepository;
	

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailSenderService emailSenderService;

	@RequestMapping("/hit")
	public String get() {
		return "welcome";
	}

	@RequestMapping("/home")
	public String Home() {
		return "home";
	}

	@RequestMapping("/user")
	public String reg() {
		return "registration";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/admin")
	public String Admin() {
		return "admin_signup";
	}

	@RequestMapping("/admin_login")
	public String adminlogin() {
		return "admin_login";
	}

	@RequestMapping("/doctorsignup")
	public String signup() {
		return "doctorsignup";
	}

	@RequestMapping("/doctorlogin")
	public String doctorlogin() {
		return "doctorlogin";
	}

	@PostMapping("/usersave")
	public String addHospital(@ModelAttribute UserDomain hospital) {
		hospital.setRole("ROLE_USER");
		hospital.setPassword(passwordEncoder.encode(hospital.getPassword()));
		if(hospitalRepository.existsByemail(hospital.getEmail())) {
			throw new RuntimeException("email is already exists");
		}
	
		hospitalservice.save(hospital);
		emailSenderService.sendEmail(hospital.getEmail(), "subject", "Successfully Registred");
		return "redirect:/hos/login";

	}

	@PostMapping("/adminpost")
	public String save(@ModelAttribute UserDomain hospital) {
		hospital.setRole("ROLE_ADMIN");
		hospital.setPassword(passwordEncoder.encode(hospital.getPassword()));
		hospitalservice.save(hospital);
		return "redirect:/hos/admin_login";

	}

	@PostMapping("/doctorsave")
	public String saveDoctor(@ModelAttribute UserDomain hospital) {
		hospital.setRole("ROLE_DOCTOR");
		hospital.setPassword(passwordEncoder.encode(hospital.getPassword()));
		hospitalservice.save(hospital);
		return "redirect:/hos/doctorlogin";

	}

	@GetMapping("/get/{hid}")
	public UserEntity getByhid(@PathVariable int hid) {
		return hospitalservice.getByhid(hid);
	}

	@PutMapping("/update/{hid}")
	public ResponseEntity<UserDomain> updatePatient(@PathVariable int hid, @RequestBody UserEntity hos) {
		return hospitalservice.updateHospitalDetails(hos);
	}

	@DeleteMapping("/delete/{hid}")
	public String deleteid(@PathVariable int hid) {
		return hospitalservice.deleteByid(hid);

	}

	@GetMapping("/getbyname/{hname}")
	public UserEntity getbyname(@PathVariable String hname) {
		return hospitalservice.getByHname(hname);
	}

}

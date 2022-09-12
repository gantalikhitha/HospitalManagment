package com.project.demo.Controller;

import java.security.Principal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.Email.EmailSenderService;
import com.project.demo.Entity.Appointment;
import com.project.demo.Entity.BillDetails;
import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.Patient;

import com.project.demo.Entity.UserEntity;
import com.project.demo.Repository.AppointmentRepository;
import com.project.demo.Repository.DoctorRepository;

import com.project.demo.Repository.PatientRepository;
import com.project.demo.Service.AppointmentService;
import com.project.demo.Service.BillDetailsService;
import com.project.demo.Service.DoctorServiceImp;
import com.project.demo.Service.HospitalService;
import com.project.demo.Service.PatientService;

@Controller

public class AdminController {
	@Autowired
	private HospitalService hospitalservice;

	@Autowired
	private DoctorServiceImp doctorService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;
	
   @Autowired 
   private BillDetailsService billDetailsService;
   
   @Autowired
   private EmailSenderService emailSenderService;
   
  

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/adminhome")
	public String get(Model model, Principal principal) {
		UserEntity uu = hospitalservice.findByemail(principal.getName());

		if (uu.getRole().equals("ROLE_USER")) {
			return "user_home";

		} else if (uu.getRole().equals("ROLE_DOCTOR")) {
			return "Doctor_home";
		}
		return "admin_home";
	}

	@GetMapping("/doctor")
	public String doctor() {

		return "Add_doctor";
	}

	@GetMapping("/patient")
	public String patient(Model model) {
		List<Doctor> doctor = doctorRepository.findAll();
		model.addAttribute("doctor", doctor);
		System.out.println(doctor);
		return "Add_patient";
	}

	@GetMapping("/appo")
	public String appointment() {
		return "Add_appointment";
	}
	
	@GetMapping("/billing")
	public String bill() {
		return"Add_bill";
	}
	
	

	// Doctor save Data and get all the doctors list

	@PostMapping("/post")
	public String doctor(@ModelAttribute Doctor doctor, Principal principal) {
		UserEntity entity = hospitalservice.findByemail(principal.getName());
		doctor.setHospital(entity);
		hospitalservice.save(doctor);
		return "redirect:/getdoctors";
	}

	@GetMapping("/getdoctors")
	public String fetchall(Model model) {
		List<Doctor> hospital = doctorRepository.findAll();
		model.addAttribute("hos", hospital);
		return "doctorslist";
	}

	// Patients save data and get all patients

	@PostMapping("/add")
	public String patient(@ModelAttribute Patient patient, Principal principal) {
		UserEntity entity = hospitalservice.findByemail(principal.getName());
		patient.setHospital(entity);
		hospitalservice.save(patient);
		return "redirect:/getpatients";
	}

	@GetMapping("/getpatients")
	public String getAllPatients(Model model) {
		List<Patient> hospital = patientRepository.findAll();
		model.addAttribute("pat", hospital);
		return "patientslist";
	}

	// appointment save data and get all Appointments

	@PostMapping("/move")
	public String Appointment(@ModelAttribute Appointment appointment, Principal principal) {
		UserEntity entity = hospitalservice.findByemail(principal.getName());
		List<Patient> pat=patientRepository.findAll();
		for(Patient p:pat) {
			patientRepository.getById(p.getPid());
			appointment.setPatient(p);
		appointment.setHospital(entity);
		hospitalservice.save(appointment);
		}
		return "redirect:/getappointments";
	}

	@GetMapping("/getappointments")
	public String getAllAppointments(Model model) {
		List<Appointment> hospital = appointmentRepository.findAll();
		model.addAttribute("appo", hospital);
		return "appointmentlist";
	}

	// Upadte doctors data

	@GetMapping("/update/{did}")
	public String update(@PathVariable int did, Model model) {
		Doctor doctor = doctorService.getByid(did);
		model.addAttribute("hos", doctor);
		return "updatedoctor";
	}

	@PostMapping("/saveDoctor")
	public String update(@ModelAttribute Doctor doctor) {
		doctorService.save(doctor);
		return "redirect:/getdoctors";
	}

	// Delete doctors data

	@GetMapping("/delete/{did}")
	public String deleteByDid(@PathVariable(value = "did") int did) {
		doctorService.deleteByDid(did);
		return "redirect:/getdoctors";
	}

//update and save patients data

	@GetMapping("/updatepatient/{pid}")
	public String updatePatient(@PathVariable(value = "pid") int pid, Model model) {
		Patient patient = patientService.getByid(pid);
		model.addAttribute("pat", patient);
		return "updatepatient";
	}

	@PostMapping("/savePatient")
	public String updatePatient(@ModelAttribute Patient patient) {
		patientService.save(patient);
		return "redirect:/getpatients";
	}

	@GetMapping("/deletepatient/{pid}")
	public String deletePatient(@PathVariable(value = "pid") int pid) {
		patientService.deleteById(pid);
		return "redirect:/getpatients";
	}

	// update and delete appointment

	@GetMapping("/updateappointment/{aid}")
	public String updateAppointment(@PathVariable(value = "aid") int aid, Model model) {
		Appointment appointment = appointmentService.getByid(aid);
		// System.out.println(appointment.getHospital().getHname());
		model.addAttribute("appo", appointment);
		return "updateappointment";
	}

	@PostMapping("/saveAppointment")
	public String updateAppo(@ModelAttribute Appointment appointment) {
		// System.out.println(appointment.getHospital().getHid());
		// System.out.println(appointment.getHospital().getHname());
		appointmentService.save(appointment);
		return "redirect:/getappointments";
	}

	@GetMapping("/deleteappointment/{aid}")
	public String deleteAppo(@PathVariable(value = "aid") int aid) {
		appointmentService.deleteByid(aid);
		return "redirect:/getappointments";
	}
	
	
	
	@RequestMapping("/getting/{aid}")
	public String Appointement(@PathVariable int aid) {
		Appointment appo=appointmentService.getByid(aid);
		String ss="Booked";
		appo.setAppointmentstatus(ss);
	    appointmentService.save(appo);
	    emailSenderService.sendEmail(appo.getEmail(),
	  		  "subject","Successfully booked your appointment");
	  		 
		return"redirect:/getappointments";
		
		
	}
	
	//bill details
	
	@GetMapping("/updatebilldetails/{bid}")
	public String updateBill(@PathVariable int bid, Model model) {
		BillDetails billDetails = billDetailsService.getByid(bid);
		model.addAttribute("pat", billDetails);
		return "updatebilling";
	}
	
	
	@PostMapping("/bill")
	public String bill(@ModelAttribute BillDetails billDetails) {
		billDetailsService.save(billDetails);
		return"redirect:/getpatients";
	}
	
	
	
	
}

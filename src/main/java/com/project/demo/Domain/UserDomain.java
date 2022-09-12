package com.project.demo.Domain;

import com.project.demo.Entity.Appointment;
import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.Patient;

public class UserDomain {

	private int hid;
	private String name;
	private String address;
	private String email;
	private String password;
	private String role;
	private Doctor doctor;
	private Patient patient;
	private Appointment appointment;
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "UserDomain [hid=" + hid + ", name=" + name + ", address=" + address + ", email=" + email + ", password="
				+ password + ", role=" + role + ", doctor=" + doctor + ", patient=" + patient + ", appointment="
				+ appointment + "]";
	}

	
}

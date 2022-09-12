package com.project.demo.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String patientname;
	private String doctorname;
	private long mobileno;
	private String email;
	private String time;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;
	private String Appointmentstatus;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name = "hid", referencedColumnName = "hid")
	private UserEntity hospital;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name="pid")
	private Patient patient;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public UserEntity getHospital() {
		return hospital;
	}

	public void setHospital(UserEntity hospital) {
		this.hospital = hospital;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAppointmentstatus() {
		return Appointmentstatus;
	}

	public void setAppointmentstatus(String appointmentstatus) {
		Appointmentstatus = appointmentstatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [aid=" + aid + ", patientname=" + patientname + ", doctorname=" + doctorname + ", mobileno="
				+ mobileno + ", email=" + email + ", time=" + time + ", date=" + date + ", Appointmentstatus="
				+ Appointmentstatus + ", hospital=" + hospital + ", patient=" + patient + "]";
	}

	

	
}

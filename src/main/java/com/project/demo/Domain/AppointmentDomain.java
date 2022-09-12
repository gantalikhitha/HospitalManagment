package com.project.demo.Domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDomain {
	private int aid;
	private String patientname;
	private String doctorname;
	private long mobileno;
	private String time;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date date;

	private UserDomain hospital;

	public UserDomain getHospital() {
		return hospital;
	}

	public void setHospital(UserDomain hospital) {
		this.hospital = hospital;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

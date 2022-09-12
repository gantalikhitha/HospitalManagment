package com.project.demo.Domain;

public class DoctorDomain {
	private int did;
	private String doctorname;
	private String specialization;
	private String mobileno;
	private String email;
	private String password;

	private UserDomain hospital;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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

	public UserDomain getHospital() {
		return hospital;
	}

	public void setHospital(UserDomain hospital) {
		this.hospital = hospital;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DoctorDomain [did=" + did + ", doctorname=" + doctorname + ", specialization=" + specialization
				+ ", mobileno=" + mobileno + ", email=" + email + ", password=" + password + ", hospital=" + hospital
				+ "]";
	}

}

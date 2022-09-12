package com.project.demo.Domain;

public class PatientDomain {
	private int pid;
	private String pname;
	private String mobileno;
	private String age;
	private String gender;
	private UserDomain hospital;

	public int getPid() {
		return pid;
	}

	public UserDomain getHospital() {
		return hospital;
	}

	public void setHospital(UserDomain hospital) {
		this.hospital = hospital;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

package com.project.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
    private String pname;
	private String mobileno;
	private String age;
	private String gender;
	private String email;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name = "hid")
	private UserEntity hospital;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="did")
	@JsonBackReference
	private Doctor doctor;
	
	@OneToMany(mappedBy = "patient")
	@JsonManagedReference
	private List<BillDetails> billdetails;

	public int getPid() {
		return pid;
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

	public UserEntity getHospital() {
		return hospital;
	}

	public void setHospital(UserEntity hospital) {
		this.hospital = hospital;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<BillDetails> getBilldetails() {
		return billdetails;
	}

	public void setBilldetails(List<BillDetails> billdetails) {
		this.billdetails = billdetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", mobileno=" + mobileno + ", age=" + age + ", gender="
				+ gender + ", email=" + email + ", hospital=" + hospital + ", doctor=" + doctor + ", billdetails="
				+ billdetails + "]";
	}

	

	
	

	

}

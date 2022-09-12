package com.project.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="bill")
public class BillDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;

	private int doctorid;
	private double totalamount;
	private String pname;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid")
	@JsonBackReference
	private Patient patient;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "BillDetails [bid=" + bid + ",  doctorid=" + doctorid + ", totalamount="
				+ totalamount + ", pname=" + pname + ", patient=" + patient + "]";
	}

	
	

}

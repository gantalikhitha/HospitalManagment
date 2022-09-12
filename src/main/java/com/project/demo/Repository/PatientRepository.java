package com.project.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.project.demo.Entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	


	

	

	

}

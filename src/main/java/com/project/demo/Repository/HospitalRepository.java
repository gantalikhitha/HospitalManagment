package com.project.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.project.demo.Domain.UserDomain;

import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.UserEntity;

@Repository
public interface HospitalRepository extends JpaRepository<UserEntity, Integer> {

	//String deleteById(int hid);

	

	UserEntity getByhid(int hid);
	UserEntity getByname(String name);

	UserEntity findByname(String username);

	Doctor save(Doctor doctor);

	UserEntity findByemail(String email);

	boolean existsByemail(String email);

	

	

	

	

}

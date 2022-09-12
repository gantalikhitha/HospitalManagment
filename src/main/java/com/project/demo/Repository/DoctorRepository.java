package com.project.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.project.demo.Entity.Doctor;
import com.project.demo.Entity.Patient;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	Object deleteByDid(int did);

	Patient save(int pid);

	

	

	



	

	
	

	

	

	

	

}

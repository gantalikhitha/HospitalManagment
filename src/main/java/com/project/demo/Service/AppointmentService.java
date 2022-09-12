package com.project.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Controller.UserController;
import com.project.demo.Entity.Appointment;
import com.project.demo.Repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public Appointment getByid(int aid) {

		return appointmentRepository.getById(aid);
	}

	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);

	}

	public int deleteByid(int aid) {
		appointmentRepository.deleteById(aid);
		return aid;

	}

	public Appointment findById(int aid) {
		// TODO Auto-generated method stub
		return appointmentRepository.getById(aid);
	}

}

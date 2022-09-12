package com.project.demo.Excel;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.Entity.Appointment;
import com.project.demo.Repository.AppointmentRepository;

@RestController
public class ExcelController {
	@Autowired
	private AppointmentRepository appo;

	public ExcelController(AppointmentRepository appo) {
		super();
		this.appo = appo;
	}
	
	@GetMapping("/download/appointment.xlsx")
	public ResponseEntity<InputStreamResource> excelAppointmentReport() throws IOException{
		List<Appointment> list=(List<Appointment>)appo.findAll();
		ByteArrayInputStream in=ExcelGenerator.AppointmentToExcel(list);
		
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.add("content-Disposition", "attachment; filename=Appointment.xlsx");
		return ResponseEntity
				.ok()
				.headers(headers)
				.body(new InputStreamResource(in));
	}

}

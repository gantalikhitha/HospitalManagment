package com.project.demo.Excel;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.project.demo.Entity.Appointment;

public class ExcelGenerator {
	public static ByteArrayInputStream AppointmentToExcel(List<Appointment> appointment)throws IOException{
		String[] columns= {"aid","patientname","doctorname","mobileno","time","date","appointmentstatus","hid"};
		try(
				Workbook workbook=new XSSFWorkbook();
				ByteArrayOutputStream out=new ByteArrayOutputStream();
				){
			Sheet sheet=workbook.createSheet("Appointment");
			Font headerFont=workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);
			
			//Row  for Header
			Row headerRow=sheet.createRow(0);
			//header
			
			for(int col=0;col<columns.length; col++) {
				
				Cell cell=headerRow.createCell(col);
				cell.setCellValue(columns[col]);
				cell.setCellStyle(headerCellStyle);
			}
				
				int rowIdx=1;
				for(Appointment appo:appointment) {
					Row row=sheet.createRow(rowIdx++);
					row.createCell(0).setCellValue(appo.getAid());
					row.createCell(1).setCellValue(appo.getPatientname());
					row.createCell(2).setCellValue(appo.getDoctorname());
					row.createCell(3).setCellValue(appo.getMobileno());
					row.createCell(4).setCellValue(appo.getTime());
					row.createCell(5).setCellValue(appo.getDate());
					row.createCell(6).setCellValue(appo.getAppointmentstatus());
					row.createCell(7).setCellValue(appo.getHospital().getHid());
				}
				workbook.write(out);
				return new ByteArrayInputStream(out.toByteArray());
				
			}
		}
		
		
	}



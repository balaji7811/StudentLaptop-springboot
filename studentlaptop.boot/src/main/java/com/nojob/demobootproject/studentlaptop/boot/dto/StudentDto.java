package com.nojob.demobootproject.studentlaptop.boot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
	
	private int studentId;
	private String studentName;
	private String studentEmail;

	private int laptopId;
	private String laptopbrand;
	private String laptopRam;
}

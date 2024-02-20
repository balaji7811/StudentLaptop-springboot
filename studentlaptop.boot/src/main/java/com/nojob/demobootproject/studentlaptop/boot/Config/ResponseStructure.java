package com.nojob.demobootproject.studentlaptop.boot.Config;

import java.util.List;

import com.nojob.demobootproject.studentlaptop.boot.entity.Student;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private String message;
	
	private int statusCode;
	
	private T data;

	

	
	
	
	

}


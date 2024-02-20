package com.nojob.demobootproject.studentlaptop.boot.Exception;

public class StudentListNotFound extends RuntimeException{

	
	String message;

	public String getMessage() {
		return message;
	}

	public StudentListNotFound(String message) {
		this.message = message;
	}
	
	
	
}

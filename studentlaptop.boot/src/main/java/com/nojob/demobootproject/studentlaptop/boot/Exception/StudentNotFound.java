package com.nojob.demobootproject.studentlaptop.boot.Exception;

public class StudentNotFound extends RuntimeException {
	
	String message;

	public String getMessage() {
		return message;
	}

	public StudentNotFound(String message) {
		this.message = message;
	}

	
}

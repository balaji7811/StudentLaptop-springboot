package com.nojob.demobootproject.studentlaptop.boot.Exception;

public class StudentDontHaveLaptop extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public StudentDontHaveLaptop(String message) {
		this.message = message;
	}

}

package com.nojob.demobootproject.studentlaptop.boot.Exception;

public class LaptopNotFound extends RuntimeException{

	
	String message;

	public String getMessage() {
		return message;
	}

	public LaptopNotFound(String message) {
		this.message = message;
	}
	

	
}

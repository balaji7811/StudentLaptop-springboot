package com.nojob.demobootproject.studentlaptop.boot.Exception;

public class LaptopListNotFound extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public LaptopListNotFound(String message) {
		this.message = message;
	}
	
	

}

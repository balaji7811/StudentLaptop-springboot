package com.nojob.demobootproject.studentlaptop.boot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nojob.demobootproject.studentlaptop.boot.Config.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> LaptopNotFoundException(LaptopNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
        structure.setMessage("laptop does not exist");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> StudentNotFoundException(StudentNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
        structure.setMessage("Student does not exist");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> StudentListNotFoundException(StudentListNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
        structure.setMessage("Student list does not exist");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> LaptopListNotFoundException(LaptopListNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
        structure.setMessage("Laptop list does not exist");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> StudentDontHaveLaptopException(StudentDontHaveLaptop ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(ex.getMessage());
        structure.setMessage("student does not have a laptop");
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}

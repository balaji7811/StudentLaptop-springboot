package com.nojob.demobootproject.studentlaptop.boot.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.*;

import com.nojob.demobootproject.studentlaptop.boot.Config.ResponseStructure;
import com.nojob.demobootproject.studentlaptop.boot.Exception.LaptopNotFound;
import com.nojob.demobootproject.studentlaptop.boot.Exception.StudentDontHaveLaptop;
import com.nojob.demobootproject.studentlaptop.boot.Exception.StudentListNotFound;
import com.nojob.demobootproject.studentlaptop.boot.Exception.StudentNotFound;
import com.nojob.demobootproject.studentlaptop.boot.dao.LaptopDao;
import com.nojob.demobootproject.studentlaptop.boot.dao.StudentDao;
import com.nojob.demobootproject.studentlaptop.boot.dto.StudentAndLaptopDto;
import com.nojob.demobootproject.studentlaptop.boot.dto.StudentDto;
import com.nojob.demobootproject.studentlaptop.boot.entity.Laptop;
import com.nojob.demobootproject.studentlaptop.boot.entity.Student;
import com.nojob.demobootproject.studentlaptop.boot.repo.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentDao dao;
    
    @Autowired
    LaptopDao ldao;
    
    
    
public ResponseEntity<ResponseStructure<StudentDto>> saveStudent(Student student) {
	     
	    Student stu=dao.saveStudent(student);
	    StudentDto dto=new StudentDto();
	    ModelMapper mapper=new ModelMapper();
	    mapper.map(stu, dto);
	
		ResponseStructure<StudentDto>structure = new ResponseStructure<StudentDto>();
		structure.setMessage("student saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dto);
		return  new ResponseEntity<ResponseStructure<StudentDto>>(structure, HttpStatus.CREATED);
}


    public ResponseEntity<ResponseStructure<StudentDto>> findstudent(int studentId)
	{
		Student student=dao.findStudent(studentId);
		if(student !=null)
		{
			
		    StudentDto dto=new StudentDto();
		    ModelMapper mapper=new ModelMapper();
		    mapper.map(student, dto);
		    
			ResponseStructure<StudentDto> structure=new ResponseStructure<>();
			structure.setMessage("Student found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StudentDto>>(structure, HttpStatus.FOUND);
		}
	//return new ResponseEntity<ResponseStructure<Laptop>>(structure, HttpStatus.NOT_FOUND);
	throw new 	StudentNotFound("student is not existed");
	}
    
    
    public ResponseEntity<ResponseStructure<Student>> deleteStudent(int studentId)
    {
    Student stu=dao.findStudent(studentId);
    if(stu!=null)
    {
		ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessage("Student  deleted");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(dao.deleteStudent(studentId));
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
    }
    throw new 	StudentNotFound("student is not existed");
    }   

    
    public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student,int studentId)
    
    {
    Student stu=dao.findStudent(studentId);
    if(stu!=null)
    {
    	ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessage("Student updated");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(dao.updateStudent(studentId, student));
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
    }
   throw new StudentNotFound("student does not exist");
    }
    
    public ResponseEntity<ResponseStructure<Student>> assignLaptopToStudent(int studentId,int laptopId)
    {
    Student stu=dao.findStudent(studentId);
    Laptop lap=ldao.findlaptop(laptopId);
    if(stu!=null)
    {
    	if(lap!=null)
    	{
    		stu.setStudentLaptop(lap);
        	ResponseStructure<Student> structure=new ResponseStructure<>();
    		structure.setMessage("Student updated");
    		structure.setStatusCode(HttpStatus.OK.value());
    		structure.setData(dao.updateStudent(studentId, stu));
    		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
    	}
    	 throw new StudentNotFound("student does not exist");
    }
    throw new LaptopNotFound("laptop not found ");		
    }
    
    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent()
    {
    
    List<Student> list=dao.getAllStudents();
    if(list!=null)
    {
    	ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		structure.setMessage("Student showed all");
		structure.setStatusCode(HttpStatus.FOUND.value());	
		structure.setData(dao.getAllStudents());
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.FOUND);
    }
    throw new StudentListNotFound("list is not found");
    }
    
    
    public ResponseEntity<ResponseStructure<Student>> removeConnection(int studentId)
    {
    	Student stu=dao.findStudent(studentId);
    	if(stu!=null) 
    	{
    		stu.setStudentLaptop(null);
    	ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessage("laptop deleted using student id");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(dao.updateStudent(studentId,stu));
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		
    	}
    	throw new StudentNotFound("student does not exist");
    	
    }
    
    
    public ResponseEntity<ResponseStructure<Student>> DeletLaptopUsingStudentId(int studentId)
    {
    	Student stu=dao.findStudent(studentId);
    	if(stu!=null) {
    		Laptop l=stu.getStudentLaptop();
    		stu.setStudentLaptop(null);
    	ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessage(" Connection Removed");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(dao.updateStudent(studentId, stu));
		ResponseStructure<Laptop> structure1=new ResponseStructure<>();
		structure1.setMessage("laptop deleted using student id");
		structure1.setStatusCode(HttpStatus.OK.value());
		structure1.setData(ldao.deletelaptop(l.getLaptopId()));
		return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		
    	}
    	throw new StudentDontHaveLaptop("Student does not contain laptopid");
    	
    }
    
    
    
    
    
}

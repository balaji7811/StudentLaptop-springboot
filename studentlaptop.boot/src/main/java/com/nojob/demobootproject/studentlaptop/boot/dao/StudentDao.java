package com.nojob.demobootproject.studentlaptop.boot.dao;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.nojob.demobootproject.studentlaptop.boot.entity.Laptop;
import com.nojob.demobootproject.studentlaptop.boot.entity.Student;
import com.nojob.demobootproject.studentlaptop.boot.repo.LaptopRepo;
import com.nojob.demobootproject.studentlaptop.boot.repo.StudentRepo;

@Repository
public class StudentDao {
	
	@Autowired
	StudentRepo studentRepo;
	
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
		
	}
	
	public Student findStudent(int id) 
	{
		Optional<Student> student= studentRepo.findById(id);
		if(student.isPresent())
		{
		return student.get();
		}
		return null;
	}

	public List<Student> getAllStudents() {
	
		return studentRepo.findAll();
	}

	public Student updateStudent(int id, Student student) {	
			Student	existudent=findStudent(id);
			if(existudent!=null)
			{
				student.setStudentId(id);
				 studentRepo.save(student);
				 return student;
			}
			return null;
	}

	public Student deleteStudent(int id) {
		      
		Student student = findStudent(id);
		studentRepo.delete(student);
		return student ;
	
}
	
	
}

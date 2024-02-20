package com.nojob.demobootproject.studentlaptop.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nojob.demobootproject.studentlaptop.boot.Config.ResponseStructure;
import com.nojob.demobootproject.studentlaptop.boot.dto.StudentAndLaptopDto;
import com.nojob.demobootproject.studentlaptop.boot.dto.StudentDto;
import com.nojob.demobootproject.studentlaptop.boot.entity.Laptop;
import com.nojob.demobootproject.studentlaptop.boot.entity.Student;
import com.nojob.demobootproject.studentlaptop.boot.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	
	@PostMapping("save")
	public ResponseEntity<ResponseStructure<StudentDto>> savestudent( @RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<StudentDto>> findstudent( @RequestParam int studentId)
	{
		return service.findstudent(studentId);
		
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Student>> deletestudent( @RequestParam int studentId)
	{
		return service.deleteStudent(studentId);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Student>> updatestudent(@RequestBody Student student, @RequestParam int studentId)
	{
		return service.updateStudent(student, studentId);
		
	}
	@PutMapping("assignLaptop")
	public ResponseEntity<ResponseStructure<Student>> assignLaptopToStudent (@RequestParam int studentId,@RequestParam int laptopId )
	{
		return service.assignLaptopToStudent(studentId,laptopId);
	}

	@GetMapping("getall")
		public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents ( )
		{
			return service.getAllStudent();
		}
	
	@DeleteMapping("removeConnection")
	public ResponseEntity<ResponseStructure<Student>> RemoveConnection(@RequestParam int studentId)
	{
		return service.removeConnection(studentId);
	}
	
	@DeleteMapping("delLap")
	public ResponseEntity<ResponseStructure<Student>> delLaptopUsindstuId(@RequestParam int studentId)
	{
		return service.DeletLaptopUsingStudentId(studentId);
	}
	
	

}

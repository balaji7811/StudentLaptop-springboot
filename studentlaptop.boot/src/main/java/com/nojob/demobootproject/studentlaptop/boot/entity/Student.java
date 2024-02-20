package com.nojob.demobootproject.studentlaptop.boot.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentPassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Laptop studentLaptop;

}

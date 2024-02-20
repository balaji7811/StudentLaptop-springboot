package com.nojob.demobootproject.studentlaptop.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Laptop {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int laptopId;
	private String laptopbrand;
	private String laptopRam;

}

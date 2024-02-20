package com.nojob.demobootproject.studentlaptop.boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

import com.nojob.demobootproject.studentlaptop.boot.entity.Laptop;
import com.nojob.demobootproject.studentlaptop.boot.entity.Student;
import com.nojob.demobootproject.studentlaptop.boot.repo.LaptopRepo;

@Repository
public class LaptopDao {
	@Autowired
	LaptopRepo repo;
	
	
	
	public Laptop saveLaptop(Laptop laptop)
	{
		return  repo.save(laptop);
	}
	
	public Laptop findlaptop(int laptopId)
	{
		Optional<Laptop> oplaptop=repo.findById(laptopId);
		if(oplaptop.isPresent())
		{
			return oplaptop.get();
		}
		return null;
	}
	
	public Laptop deletelaptop(int laptopId)
	{
	Laptop	laptop=findlaptop(laptopId);
	repo.delete(laptop);
	return laptop;
	}
	
	
	public Laptop updatelaptop(Laptop laptop,int laptopId)
	{
		Laptop	exilaptop=findlaptop(laptopId);
		if(exilaptop!=null)
		{
			laptop.setLaptopId(laptopId);
			 repo.save(laptop);
			 return laptop;
		}
		return null;
	}
	

	public List<Laptop> getAllLaptop() {
	
		return repo.findAll();
	}
}

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
import com.nojob.demobootproject.studentlaptop.boot.entity.Laptop;
import com.nojob.demobootproject.studentlaptop.boot.service.LaptopService;

@RestController
@RequestMapping("laptop")
public class LaptopController {
	
	@Autowired
	LaptopService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Laptop>> savelaptop( @RequestBody Laptop laptop)
	{
		return service.savelaptop(laptop);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Laptop>> findlaptop( @RequestParam int laptopId)
	{
		return service.findlaptop(laptopId);
		
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Laptop>> deletelaptop( @RequestParam int laptopId)
	{
		return service.deletelaptop(laptopId);
		
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Laptop>> updatelaptop(@RequestBody Laptop laptop, @RequestParam int laptopId)
	{
		return service.updatelaptop(laptop,laptopId);
		
	}
	@GetMapping("getalllaptop")
	public ResponseEntity<ResponseStructure<List<Laptop>>> getAllLaptop()
	{
		return service.getAllLaptop();
		
	}
	

}

package com.nojob.demobootproject.studentlaptop.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nojob.demobootproject.studentlaptop.boot.Config.ResponseStructure;
import com.nojob.demobootproject.studentlaptop.boot.Exception.LaptopListNotFound;
import com.nojob.demobootproject.studentlaptop.boot.Exception.LaptopNotFound;
import com.nojob.demobootproject.studentlaptop.boot.dao.LaptopDao;
import com.nojob.demobootproject.studentlaptop.boot.entity.Laptop;
import com.nojob.demobootproject.studentlaptop.boot.entity.Student;

@Service
public class LaptopService {
	
	@Autowired
	LaptopDao laptopdao;
	
	public ResponseEntity<ResponseStructure<Laptop>> savelaptop(Laptop laptop)
	{
	ResponseStructure<Laptop> structure=new ResponseStructure<>();
	structure.setMessage("data saved");
	structure.setStatusCode(HttpStatus.CREATED.value());
	structure.setData(laptopdao.saveLaptop(laptop));
	return new ResponseEntity<ResponseStructure<Laptop>>(structure, HttpStatus.CREATED);
	}

	
	public ResponseEntity<ResponseStructure<Laptop>> findlaptop(int laptopId)
	{
		Laptop laptop=laptopdao.findlaptop(laptopId);
		if(laptop !=null)
		{
			ResponseStructure<Laptop> structure=new ResponseStructure<>();
			structure.setMessage("laptop found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(laptopdao.findlaptop(laptopId));
			return new ResponseEntity<ResponseStructure<Laptop>>(structure, HttpStatus.FOUND);
		}
	throw new LaptopNotFound("laptop not found ");	
	}
	
	
	
	public ResponseEntity<ResponseStructure<Laptop>> deletelaptop(int laptopId)
	{
	Laptop l=laptopdao.findlaptop(laptopId);
	if(l!=null)
		{
			ResponseStructure<Laptop> structure=new ResponseStructure<>();
			structure.setMessage("laptop deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(laptopdao.deletelaptop(laptopId));
			return new ResponseEntity<ResponseStructure<Laptop>>(structure, HttpStatus.OK);
		}
	throw new LaptopNotFound("laptop is not here");
	}


	
	public ResponseEntity<ResponseStructure<Laptop> > updatelaptop(Laptop laptop,int laptopId)
	{
	Laptop l=laptopdao.findlaptop(laptopId);
	if(l!=null)
	{
		ResponseStructure<Laptop> structure=new ResponseStructure<>();
		structure.setMessage("laptop updated");
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setData(laptopdao.updatelaptop(laptop, laptopId));
		return new ResponseEntity<ResponseStructure<Laptop>>(structure, HttpStatus.OK);
	}
	throw new LaptopNotFound("laptop is not here");
  }
	
	
	
	   public ResponseEntity<ResponseStructure<List<Laptop>>> getAllLaptop()
	   {
		List<Laptop> laplist=laptopdao.getAllLaptop();   
	   if(!laplist.isEmpty())
	    {
	    	ResponseStructure<List<Laptop>> structure=new ResponseStructure<>();
			structure.setMessage("Laptop showed all");
			structure.setStatusCode(HttpStatus.FOUND.value());	
			structure.setData(laptopdao.getAllLaptop());
			return new ResponseEntity<ResponseStructure<List<Laptop>>>(structure, HttpStatus.FOUND);
	    }
	   throw new LaptopListNotFound("laptoplist not found");
	   }
	   
}

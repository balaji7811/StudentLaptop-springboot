package com.nojob.demobootproject.studentlaptop.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nojob.demobootproject.studentlaptop.boot.entity.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer>{

}

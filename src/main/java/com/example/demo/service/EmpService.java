package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.Emprepo;

import java.util.*;

@Service
public class EmpService {
@Autowired
	private Emprepo repo;
	public void addEmp(Employee e)
	{
		repo.save(e);
	}
	
	public List<Employee> getAllEmp(){
		return repo.findAll();
	}
	public Employee getEmpById(int id) {
		Optional<Employee> e=repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	


	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
}

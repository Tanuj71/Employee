package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
 public String home(Model m) {
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
	 return "index";
 }
	@GetMapping("/addemp")
	public String addEmployee() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		
		System.out.println(e);
		service.addEmp(e);
		session.setAttribute("msg", "Employee added succesfully...");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		
		Employee e= service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee Data Update......");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deletEmp(@PathVariable int id, HttpSession session) {
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee Data Delete Successfully....");
		
		
		return "redirect:/";
}
	
	
}
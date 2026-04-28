package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Employee;
import com.ecommerce.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	public EmployeeService empservice;
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp ){
		return new ResponseEntity<Employee>(empservice.saveEmployee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public List<Employee> getAllEmployees(){
		return empservice.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployyeByid(@PathVariable int id){
		return new ResponseEntity<Employee>(empservice.getEmpById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
	    	return new ResponseEntity<Employee>(empservice.updateEmployee(employee, id), HttpStatus.OK);
	}
	
}

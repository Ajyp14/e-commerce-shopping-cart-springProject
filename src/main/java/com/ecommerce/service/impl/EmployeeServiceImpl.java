package com.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Employee;
import com.ecommerce.repository.EmployeeRepository;
import com.ecommerce.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override 
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public Employee getEmpById(int id)
	{
//		Optional<Employee> op  = repo.findById(id);
//		if(op.isPresent())
//		  return op.get();
//		else
//		  throw new ResourceNotFoundException("Employee", "Id", id);
		
		return repo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Employee", "Id", id));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		
		Employee existingEmployee = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirst_name(employee.getFirst_name());
		existingEmployee.setLast_name(employee.getLast_name());
		existingEmployee.setEmail(employee.getEmail());
		
		repo.save(existingEmployee);
		
		return existingEmployee;
	}
}

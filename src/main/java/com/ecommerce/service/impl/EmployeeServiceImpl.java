package com.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.model.Employee;
import com.ecommerce.repository.EmployeeRepository;
import com.ecommerce.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	

}

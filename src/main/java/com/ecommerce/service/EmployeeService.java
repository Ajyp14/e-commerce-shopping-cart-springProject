package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmpById(int id);
}

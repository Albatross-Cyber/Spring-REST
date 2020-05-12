package com.vojtechruzicka.springfoxexample.services;

import java.util.List;

import com.vojtechruzicka.springfoxexample.domain.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

	void deleteEmployee(int id);
	
	void save(Employee employee);

}

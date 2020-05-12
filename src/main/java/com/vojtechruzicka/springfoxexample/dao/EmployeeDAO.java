package com.vojtechruzicka.springfoxexample.dao;

import java.util.List;

import com.vojtechruzicka.springfoxexample.domain.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public void save(Employee theEmployee);

	public void deleteById(int id);
	
}

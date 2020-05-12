package com.vojtechruzicka.springfoxexample.controllers;

import com.vojtechruzicka.springfoxexample.domain.Employee;
import com.vojtechruzicka.springfoxexample.exception.EmployeeNotFoundException;
import com.vojtechruzicka.springfoxexample.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Employees.")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// Endpoint for GET /v2/employees -- Get All Employees
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("${employeecontroller.getallemployees}")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    
    // Endpoint for GET /v2/employees/id -- Get Specific Employee
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("${employeecontroller.getemployeebyid}")
    public Employee getEmployeeById(@ApiParam("Id of the employee to be obtained. Cannot be empty.")
                                    @PathVariable int id) {
        
    	Employee theEmployee = employeeService.getEmployeeById(id);
    	
    	if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employee Id not found - " + id);
		}

		return theEmployee;
    }
    
    
    // Endpoint for DELETE /v2/employees -- Delete Specific Employee
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("${employeecontroller.deleteemployee}")
    public String deleteEmployee(@ApiParam("Id of the employee to be deleted. Cannot be empty.")
                                 @PathVariable int id) {
    	
    	Employee theEmployee = employeeService.getEmployeeById(id);
    	
    	if (theEmployee == null) {
			throw new EmployeeNotFoundException("Employee Id not found - " + id);
		}
    	
    	employeeService.deleteEmployee(id);
    	
        return "Deleted Employee Id - " + id;
    }

    // Endpoint for POST /v2/employees -- Create a new employee
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("${employeecontroller.createemployee}")
    public Employee createEmployee(@ApiParam("Employee information for a new employee to be created.")
                                   @RequestBody Employee employee) {
    	
    	// Also just in case they pass an id in JSON ... set id to 0, this is to force a save of new item ... instead of update.
    	employee.setId(0);
        employeeService.save(employee);
        return employee;
    }
    
    // Endpoint for PUT /v2/employees -- Update an existing employee
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation("${employeecontroller.updateemployee}")
   	public Employee updateEmployee(@ApiParam(value = "Employee information for updating an existing employee.")
   								   @RequestBody Employee employee) {
   		
   		employeeService.save(employee);
   		
   		return employee;
   	}
}

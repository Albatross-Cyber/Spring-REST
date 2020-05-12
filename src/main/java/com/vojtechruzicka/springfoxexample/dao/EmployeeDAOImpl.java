package com.vojtechruzicka.springfoxexample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vojtechruzicka.springfoxexample.domain.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		Query theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		@SuppressWarnings("unchecked")
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public void deleteById(int id) {
		
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
	}

}

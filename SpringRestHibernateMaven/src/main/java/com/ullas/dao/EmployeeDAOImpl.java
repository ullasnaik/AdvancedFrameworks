package com.ullas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ullas.entity.Employee;

@Service("employeeDAO")
@Transactional(propagation=Propagation.REQUIRED)
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public Employee addEmployee(Employee employee) {
		entityManager.merge(employee);
		return employee;
	}
	
	@Transactional(readOnly=true)
	public Employee getEmployee(int empId) {
		Query query=entityManager.createQuery("select emp from Employee emp where emp.empId=:empId");
		query.setParameter("empId", empId);
		return (Employee)query.getSingleResult();
	}
	
	@Transactional(readOnly=true)
	public Employee getEmployee(String email) {
		Query query=entityManager.createQuery("select emp from Employee emp where emp.email=:email");
		query.setParameter("email", email);
		return (Employee)query.getSingleResult();
	}
	@Transactional(readOnly=true)
	public List<Employee> getEmployee() {		
		 Query query  = entityManager.createQuery("select emp from Employee emp");
		 List<Employee> empList=(List<Employee>)query.getResultList();
		 return empList;
	}

}

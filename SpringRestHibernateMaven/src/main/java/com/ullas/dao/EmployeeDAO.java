package com.ullas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.ullas.entity.Employee;

@Repository("employeeDao")
public interface EmployeeDAO {
	public Employee addEmployee(Employee employee);

	public Employee getEmployee(int empId);

	public Employee getEmployee(String email);

	public List<Employee> getEmployee();
}

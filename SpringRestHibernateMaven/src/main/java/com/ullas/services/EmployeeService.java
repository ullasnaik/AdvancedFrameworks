package com.ullas.services;

import java.util.List;

import com.ullas.entity.Employee;

public interface EmployeeService {
	public Employee getEmployee(int empId);
	public Employee getEmployee(String email);
	public Employee addEmployee(int empId, String empName, String sex, String email, String address );
	public List<Employee> getEmployee();
}

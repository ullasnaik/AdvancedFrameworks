package com.ullas.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ullas.dao.EmployeeDAO;
import com.ullas.entity.Employee;

@Service("employeeService")
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired(required = true)
	private EmployeeDAO employeeDAO;

	public Employee getEmployee(int empId) {
		return employeeDAO.getEmployee(empId);
	}

	public Employee getEmployee(String email) {
		return employeeDAO.getEmployee(email);
	}

	public Employee addEmployee(int empId, String empName, String sex, String email, String address) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setSex(sex);
		emp.setEmail(email);
		emp.setAddress(address);
		emp.setCreateDate(new Date());
		emp.setUpdatedDate(new Date());
		return employeeDAO.addEmployee(emp);
	}

	public List<Employee> getEmployee() {
		return employeeDAO.getEmployee();
	}

}

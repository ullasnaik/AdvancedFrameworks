package com.ullas.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ullas.entity.Employee;
import com.ullas.rest.modal.EmployeeModal;
import com.ullas.rest.modal.EmployeeStatusModal;
import com.ullas.services.EmployeeService;

@Component
@Path("/Employee")
public class EmployeeRestResource {

	@Autowired(required = true)
	@Qualifier("employeeService")
	private EmployeeService employeeService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Employee-json-meta")
	public EmployeeModal getEmployee() {
		EmployeeModal modal = new EmployeeModal();
		modal.setEmpId(100);
		modal.setEmpName("ULLAS NAIK");
		modal.setEmail("naik.ullas@gmail.com");
		modal.setSex("MALE");
		modal.setAddress("BANGALORE");
		return modal;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create-emp")
	public EmployeeStatusModal createEmployee(EmployeeModal employeeModal) {
		System.out.println("Creating Employee with empId: " );
		Employee employee = null;
		EmployeeStatusModal statusModal = new EmployeeStatusModal();
		try {
			employee = employeeService.addEmployee(employeeModal.getEmpId(), employeeModal.getEmpName(),
					employeeModal.getSex(), employeeModal.getEmail(), employeeModal.getAddress());
			statusModal.setEmp(employeeModal);
			statusModal.setMessage("Employee Created Successfully");
		} catch (Exception e) {
			statusModal.setStatus(205);
			statusModal.setMessage("Error in Creating Employee ::::"+ e.getMessage());
			e.printStackTrace();
		}

		return statusModal;

	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/emp-info/{empId}")
	public EmployeeModal getEmployee(@PathParam("empId") int empId) {

		System.out.println("user-info:userId" + empId);

		EmployeeStatusModal employeeStatus = new EmployeeStatusModal();
		Employee employee = employeeService.getEmployee(empId);
		EmployeeModal employeeModal = new EmployeeModal();
		if (employee != null) {
			employeeStatus.setStatus(200);
			employeeStatus.setMessage("Employee info");
			employeeModal.setEmail(employee.getEmail());
			employeeModal.setEmpName(employee.getEmpName());
			employeeModal.setSex(employee.getSex());
			employeeModal.setEmpId(empId);
			employeeModal.setAddress(employee.getAddress());
			employeeStatus.setEmp(employeeModal);
		} else {
			employeeStatus.setStatus(205);
			employeeStatus.setMessage("employee info");
		}
		return employeeModal;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllEmp")
	public List<EmployeeModal> getAllEmployee() {

		EmployeeStatusModal employeeStatus = new EmployeeStatusModal();
		List<Employee> emplList = employeeService.getEmployee();
		
		List<EmployeeModal> empModList= new ArrayList<EmployeeModal>();
		if (emplList != null) {
			for (Employee employee : emplList) {
				EmployeeModal employeeModal = new EmployeeModal();
				employeeStatus.setStatus(200);
				employeeStatus.setMessage("Employee info");
				employeeModal.setEmail(employee.getEmail());
				employeeModal.setEmpName(employee.getEmpName());
				employeeModal.setSex(employee.getSex());
				employeeModal.setEmpId(employee.getEmpId());
				employeeModal.setAddress(employee.getAddress());
				employeeStatus.setEmp(employeeModal);
				empModList.add(employeeModal);
			}
			
		} else {
			employeeStatus.setStatus(205);
			employeeStatus.setMessage("employee info");
		}
		return empModList;
	}
}

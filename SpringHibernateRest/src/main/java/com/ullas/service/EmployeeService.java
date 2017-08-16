package com.ullas.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.ullas.bean.Employee;

@Component
@Path("/Employee")
public class EmployeeService {

	@GET
	@Path(value="/{name}/{empId}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee employeeProcess(@PathParam("name") String name,@PathParam("empId") String empId ) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	}
}

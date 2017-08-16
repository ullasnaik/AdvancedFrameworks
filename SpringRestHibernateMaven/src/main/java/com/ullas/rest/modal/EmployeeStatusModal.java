package com.ullas.rest.modal;


public class EmployeeStatusModal {
	private int status;
	private String message;
	private EmployeeModal emp;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmployeeModal getEmp() {
		return emp;
	}
	public void setEmp(EmployeeModal emp) {
		this.emp = emp;
	}
	

}

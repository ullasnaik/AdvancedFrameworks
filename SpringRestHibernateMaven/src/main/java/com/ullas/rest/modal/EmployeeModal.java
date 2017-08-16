package com.ullas.rest.modal;

public class EmployeeModal {

	private int empId;
	private String empName;
	private String sex;
	private String email;
	private String address;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeModal [empId=" + empId + ", empName=" + empName + ", sex=" + sex + ", email=" + email
				+ ", address=" + address + "]";
	}
	
}

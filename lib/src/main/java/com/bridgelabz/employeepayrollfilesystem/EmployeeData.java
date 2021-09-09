package com.bridgelabz.employeepayrollfilesystem;

public class EmployeeData {

	private int id;
	private String name;
	public double salary;	
		
	public EmployeeData(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeData [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}

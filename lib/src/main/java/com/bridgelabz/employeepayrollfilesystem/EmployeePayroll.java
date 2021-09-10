package com.bridgelabz.employeepayrollfilesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {

	public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
	private static List<EmployeeData> employeeList;
	
	public EmployeePayroll() {}
	
	public EmployeePayroll(List<EmployeeData> employeeList) {
		this.employeeList = employeeList;
	}
	
	public static void main(String[] args) {
		employeeList = new ArrayList<>();
		
		EmployeePayroll employeePayrollService = new EmployeePayroll(employeeList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeeData(consoleInputReader);
		employeePayrollService.writeEmployeeData(IOService.CONSOLE_IO);
	}

	private void readEmployeeData(Scanner consoleInputReader) {

        System.out.println("Enter Employee ID: ");
        int id= consoleInputReader.nextInt();

        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();

        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();

        employeeList.add(new EmployeeData(id, name, salary));
		
	}
	
public void writeEmployeeData(IOService ioService) {
		//System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeeList);
		if(ioService.equals(IOService.CONSOLE_IO)) {
			System.out.println(employeeList);
		}
		else if(ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeeList);
		}
	}
	
	public void printData(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().printData();
		}
	}
	
	public long countEnteries(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			return new EmployeePayrollFileIOService().countEnteries();
		}
		return  0;
	}
}

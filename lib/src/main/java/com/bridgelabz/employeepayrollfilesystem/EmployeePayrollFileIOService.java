package com.bridgelabz.employeepayrollfilesystem;

import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class EmployeePayrollFileIOService {

	public static String PAYROLL_FILE_NAME = "payroll-file.txt";
	
	public void writeData(List<EmployeeData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printData() {
		try {
			Files.lines(new File("payroll-file.txt").toPath()).forEach(System.out::println);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public long countEnteries() {
		long enteries = 0;
		try {
			enteries=Files.lines(new File("payroll-file.txt").toPath()).count();
		}
		catch(IOException e) {
            e.printStackTrace();
        }
        return enteries;
	}
}

package com.bridgelabz.employeepayrolltest;

import java.util.Arrays;
import org.junit.Test;
import com.bridgelabz.employeepayrollfilesystem.EmployeeData;
import com.bridgelabz.employeepayrollfilesystem.EmployeePayroll;
import com.bridgelabz.employeepayrollfilesystem.EmployeePayroll.IOService;
import org.junit.Assert;

public class EmployeePayrollServiceTest {

	@Test
	public void givenEmployeeWhenWrittenToFileShouldMatchEmployeeEnterires() {
		EmployeeData[] arrayOfEmps = {
				new EmployeeData(1, "Jeff Bezoz", 100000),
				new EmployeeData(2, "Bill Gates", 200000),
				new EmployeeData(3, "Mark Zuckerberge", 300000)
		};
		
		EmployeePayroll employeePayroll;
		employeePayroll = new EmployeePayroll(Arrays.asList(arrayOfEmps));
		employeePayroll.writeEmployeeData(IOService.FILE_IO);
		employeePayroll.printData(IOService.FILE_IO);
		long enteries = employeePayroll.countEnteries(IOService.FILE_IO);
		System.out.println(enteries);
		Assert.assertEquals(3, enteries);
	}
}

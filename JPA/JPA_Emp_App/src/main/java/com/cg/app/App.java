package com.cg.app;

import com.cg.entity.Employee;
import com.cg.exception.NoSuchEmployeeException;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EmployeeService eService = new EmployeeServiceImpl();

		// create
		Employee emp1 = new Employee(101, "E1", "IT", 30000);
		eService.add(emp1);

		Employee emp2 = new Employee(121, "E2", "Accounts", 50000);
		eService.add(emp2);

		Employee emp3 = new Employee(124, "E34", "L&D", 23000);
		eService.add(emp3);

		Employee emp4 = new Employee(1243, "E43", "R&D", 42000);
		eService.add(emp4);
		
		System.out.println("Created");
//		
		// update
		Employee emp = eService.update(new Employee(101, "Rohit","IT", 28000));
		System.out.println(emp.toString());
		
		System.out.println("Updated");
//
		// find
		try {
			emp = eService.find(101);
			System.out.println(emp.toString());
			System.out.println("Search: found");
		} catch (NoSuchEmployeeException ex) {
			ex.printStackTrace();
		}
		
		//delete
		eService.delete(emp4);
		
		System.out.println("Deleted");
	}

}

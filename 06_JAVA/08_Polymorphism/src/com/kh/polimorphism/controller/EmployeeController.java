package com.kh.polimorphism.controller;

import com.kh.polimorphism.model.Employee;
import com.kh.polimorphism.model.Engineer;

public class EmployeeController {

	public Employee findEmployee(Employee[] emp, String name) {
		for (Employee employee : emp) {
			if (employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}

	public int getAnnualSalary(Employee findEmployee) {
		if(findEmployee ==null) return -1;
		
		if (findEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) findEmployee;
			return engineer.getSalary() * 12 + engineer.getBonus();
		}
		return findEmployee.getSalary() * 12;
	}

	public int totalSalary(Employee[] emp) {
		int sum = 0;
		for (Employee employee : emp) {
			sum += employee.getSalary();
		}
		return sum;
	}

}

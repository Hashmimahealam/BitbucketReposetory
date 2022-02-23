package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeDao employeeDao;
	
	public Employee getEmployeeByNameInService(String name)
	{
		System.out.println("called service");
		return employeeDao.getEmployeeByNameDao(name);
	}
}

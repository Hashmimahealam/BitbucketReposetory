package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		System.out.println("called controller we have to give name(any String) at url like /Aalam or /a");
		
		Employee employeeByNameInService = employeeService.getEmployeeByNameInService(name);
		if(employeeByNameInService.getName() !=null) {
			System.out.println(employeeByNameInService.getName().toUpperCase());	
		}else {
			System.out.println("employee name does not exist for"+name);
		}
		
		return employeeByNameInService;
	}
}

package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	public Map<String,Employee> employees = new HashMap<>();
	
	public EmployeeDao() {
		employees.put("Aalam",new Employee("Aalam", "Bandra"));
		employees.put("Ahmed",new Employee("Ahmed", "Kurla"));
	}

	public Employee getEmployeeByNameDao(String name)
	{
		System.out.println("called DAO");
		return employees.get(name);
	}
}

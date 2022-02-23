package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Mock
	EmployeeDao employeeDao;
	
	@Test
	public void testService()
	{
		when(employeeDao.getEmployeeByNameDao(Mockito.anyString())).thenReturn(new Employee("ZTYZ", "BBB"));
		assertEquals("ZTYZ",employeeService.getEmployeeByNameInService("KK").getName());
	}
}

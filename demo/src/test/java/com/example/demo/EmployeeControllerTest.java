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
public class EmployeeControllerTest {

	
	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	@Test
	public void testEmployeeCotroller()
	{
		when(employeeService.getEmployeeByNameInService(Mockito.anyString())).thenReturn(new Employee(null, "Test"));
//		assertThrows(NullPointerException.class,() -> employeeService.getEmployeeByNameInService
		assertEquals(Employee.class, employeeController.getEmployeeByName("Ahmed").getClass());
	}
	
	
}

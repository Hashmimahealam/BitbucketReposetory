package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class VoidMethodMockTest {

	@Mock
	Emp4 emp4;
	
	@Test
	public void testVoidMethod() {
		doNothing().when(emp4).add(anyString(), anyString());
		emp4.add("KK", "LL");
		verify(emp4, times(1)).add("KK", "LL");
		System.out.println(emp4.getMeaning("KK"));
	}

	@Test
	public void testVoidMethodSpyRealCallMethod() {
		Emp4 emp42 = spy(Emp4.class);
		doCallRealMethod().when(emp42).add(anyString(), anyString());
		emp42.add("KK", "LL");
		verify(emp42, times(1)).add("KK", "LL");
		System.out.println(emp42.getMeaning("KK"));
	}

	@Test
	public void testVoidMethodMockException() {
		Emp4 emp42 = mock(Emp4.class);
		doThrow(NullPointerException.class).when(emp42).add(anyString(), anyString());
		assertThrows(NullPointerException.class, () -> emp42.add("d", "dd"));

	}
}

class Emp4 implements Employee4 {

	private Map<String, String> wordMap;

	public Emp4() {
		wordMap = new HashMap<String, String>();
	}

	public void add(String word, String meaning) {
		wordMap.put(word, meaning);
	}

	public String getMeaning(String word) {
		return wordMap.get(word);
	}
}

interface Employee4 {
	void add(String word, String meaning);

	String getMeaning(String word);
}

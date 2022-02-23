package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class MockitoExceptionHandling {

	@Mock
	Emp1 emp1;

//	https://www.youtube.com/watch?v=6-gj2W2ycMI&list=PLzS3AYzXBoj9Gpuo_EpyaZ8mGKExfLM8c&index=12
	@Test
	public void testException() {

		doThrow(new NullPointerException()).when(emp1).getMeaning(Mockito.anyString());
		assertThrows(NullPointerException.class, () -> emp1.getMeaning("s"));
	}
}

class Emp1 implements Employee1 {

	private Map<String, String> wordMap;

	public Emp1() {
		wordMap = new HashMap<String, String>();
	}

	public void add(String word, String meaning) {
		wordMap.put(word, meaning);
	}

	public String getMeaning(String word) {
		return wordMap.get(word);
	}
}

interface Employee1 {
	void add(String word, String meaning);

	String getMeaning(String word);
}

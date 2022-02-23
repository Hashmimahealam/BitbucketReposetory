package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class InjectMockExample {

	@InjectMocks
	private Employee emp = new Emp();

	@Mock
	private Map<String, String> wordMap;

	@Test
	public void testInjectMock() {
		when(wordMap.get(Mockito.anyString())).thenReturn("Good");
		assertEquals("Good", emp.getMeaning("kk"));
	}
}

class Emp implements Employee {

	private Map<String, String> wordMap;

	public Emp() {
		wordMap = new HashMap<String, String>();
	}

	public void add(String word, String meaning) {
		wordMap.put(word, meaning);
	}

	public String getMeaning(String word) {
		return wordMap.get(word);
	}
}

interface Employee {
	void add(String word, String meaning);

	String getMeaning(String word);
}

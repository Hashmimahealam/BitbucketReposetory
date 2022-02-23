package com.spring.boot.jpa;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class VerifyMockMethod {

	@Mock
	Emp3 emp3;

	@Test
	public void testVerfyMethod() {

		emp3.add("A", "A");
		verify(emp3).add("A", "A");
		verify(emp3, times(1)).add("A", "A");
		verify(emp3, atLeast(1)).add("A", "A");

	}

	@Test
	public void testVerfyNoInterAction() {

		Emp3 emp32 = mock(Emp3.class);
		Emp3 emp33 = mock(Emp3.class);

//		emp32.add("A", "A");

		verifyNoInteractions(emp32, emp33);

	}

}

class Emp3 implements Employee3 {

	private Map<String, String> wordMap;

	public Emp3() {
		wordMap = new HashMap<String, String>();
	}

	public void add(String word, String meaning) {
		wordMap.put(word, meaning);
	}

	public String getMeaning(String word) {
		return wordMap.get(word);
	}
}

interface Employee3 {
	void add(String word, String meaning);

	String getMeaning(String word);
}
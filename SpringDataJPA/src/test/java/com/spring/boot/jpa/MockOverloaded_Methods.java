package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.withSettings;

import java.util.AbstractList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(value = MockitoExtension.class)
public class MockOverloaded_Methods {

	@Mock
	private MyList myList;

	@Test
	public void mockOverloadedTest() {

		boolean added = myList.add("hello");
//		when(myList.add(Mockito.anyString())).thenReturn(false);
		verify(myList).add(Mockito.anyString());
		assertEquals(false, added);
	}

	@Test
	public void mockOverloadedTestArgument() {

		MyList myList2 = mock(MyList.class, "Mock Setting is called");
		boolean added = myList2.add("hello");
//		when(myList.add(Mockito.anyString())).thenReturn(false);
		verify(myList2).add(Mockito.anyString());
		assertEquals(false, added);
	}

	@Test
	public void mockOverloadedTestArgumentAnswer() {

		MyList myList2 = mock(MyList.class, new MyAnswer());
		boolean added = myList2.add("hello");
//		when(myList.add(Mockito.anyString())).thenReturn(false);
		verify(myList2).add(Mockito.anyString());
		assertEquals(false, added);
	}

	@Test
	public void mockOverloadedTestArgumentSetting() {

		MockSettings defaultAnswer = withSettings().defaultAnswer(new MyAnswer());
		MyList myList2 = mock(MyList.class, defaultAnswer);
		boolean added = myList2.add("hello");
//		when(myList.add(Mockito.anyString())).thenReturn(false);
		verify(myList2).add(Mockito.anyString());
		assertEquals(false, added);
	}
}

class MyList extends AbstractList<String> {

	@Override
	public String get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}

class MyAnswer implements Answer<Boolean> {

	@Override
	public Boolean answer(InvocationOnMock invocation) throws Throwable {
		return false;
	}

}

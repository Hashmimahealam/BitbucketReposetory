package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.boot.jpa.model.Topic;
import com.spring.boot.jpa.rest.controller.TopicController;
import com.spring.boot.jpa.service.TopicDao;
import com.spring.boot.jpa.service.TopicService;

@ExtendWith(value = MockitoExtension.class)
@TestInstance(value = Lifecycle.PER_CLASS)
public class ArgumentCaptorClassTest {

	@InjectMocks
	public TopicController topicController;

	@Captor
	ArgumentCaptor<String> argumentCaptor;

	@Captor
	ArgumentCaptor<String> argumentCaptor1;

	@Mock
	public TopicService topicService;

	@Mock
	public TopicDao topicDao;
	
	@Mock
	public ArrayList<String> mockList;

	@Test
	public void testVerifyCaptor() {

		when(topicService.getTopic(Mockito.anyString())).thenReturn(new Topic("Java", "IT", "Java 8"));
		assertEquals(Topic.class, topicController.getTopic("java").getBody().getClass());
		verify(topicService).getTopic(argumentCaptor.capture());
		assertEquals("java", argumentCaptor.getValue());
		
		mockList.add("A");
		mockList.add("B");
		mockList.add("C");
		verify(mockList, times(3)).add(argumentCaptor1.capture());
		List<String> allValues = argumentCaptor1.getAllValues();
		assertEquals("A", allValues.get(0));


	}
}

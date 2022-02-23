package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.boot.jpa.model.Topic;
import com.spring.boot.jpa.rest.controller.TopicController;
import com.spring.boot.jpa.service.TopicDao;
import com.spring.boot.jpa.service.TopicService;

@ExtendWith(value = { MockitoExtension.class })
@TestInstance(value = Lifecycle.PER_CLASS)
public class Mockito5JunitTopicTest {

	@InjectMocks
	public TopicController topicController;

	@Mock
	public TopicService topicService;

	@Mock
	public TopicDao topicDao;

//	@BeforeAll
	public void setUp() {
		topicService = mock(TopicService.class);
	}

	@Test
	public void testFetchTopic() {

//		when(topicService.getTopic(Mockito.anyString())).thenReturn(new Topic("Java", "IT", "Java 8"));
		when(topicService.getAllTopics()).thenReturn(Arrays.asList(new Topic("Java", "IT", "Java 8")));
//		when(topicDao.getAllTopics()).thenReturn(Arrays.asList(new Topic("Java", "IT", "Java 8")));
		assertEquals(1, topicController.getAllTopics().size());
	}

	@Test
	public void testFetchTopic1() {

		when(topicService.getTopic(Mockito.anyString())).thenReturn(new Topic("Java", "IT", "Java 8"));
//		when(topicService.getAllTopics()).thenReturn(Arrays.asList(new Topic("Java", "IT", "Java 8")));
//		when(topicDao.getAllTopics()).thenReturn(Arrays.asList(new Topic("Java", "IT", "Java 8")));
		assertEquals(Topic.class, topicController.getTopic("MW").getBody().getClass());
	}

//	https://www.youtube.com/watch?v=3IbdOGahtk8&list=PLzS3AYzXBoj9Gpuo_EpyaZ8mGKExfLM8c&index=9
	@Test
	public void testArrayList() {

		ArrayList arrayList = mock(ArrayList.class);
		arrayList.add("a");
		arrayList.add("ab");
		assertEquals(0, arrayList.size()); // true mock does not call actual add method

		ArrayList arrayList1 = spy(new ArrayList<String>());
		arrayList1.add("h1");
		arrayList1.add("h2");
		assertEquals(2, arrayList1.size());
		doReturn(3).when(arrayList1).size();
		assertEquals(3, arrayList1.size());

	}

}

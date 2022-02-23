package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.boot.jpa.dao.TopicRepository;
import com.spring.boot.jpa.model.Topic;
import com.spring.boot.jpa.service.TopicService;

//https://www.youtube.com/watch?v=kXhYu939_5s&t=391s
//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SpringDataJpaApplicationTests {

	@InjectMocks
	public TopicService topicService;

	@Mock
	TopicRepository topicRepository;

	@Test
	public void getTopic() {
		when(topicRepository.findAll()).thenReturn(Arrays.asList(new Topic("Java", "MW", "Java Programming")));
		assertEquals(1, topicService.getAllTopics().size());
	}

//	@Test
	public void getTopicById() {
		when(topicRepository.findById("java")).thenReturn(Optional.of(new Topic("JAVA", "JAVA", "Java Descriptin")));
		assertEquals("java", topicService.getTopic("java").getId());
	}
}

package com.spring.boot.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.spring.boot.jpa.dao.TopicRepository;
import com.spring.boot.jpa.model.Topic;
import com.spring.boot.jpa.service.TopicService;

@RunWith(MockitoJUnitRunner.class)
public class TestTopicRepositoryTest {

	@InjectMocks
	public TopicService topicService;

	@Mock
//	@Autowired
	TopicRepository topicRepository;

	@Test
	public void getTopic() {
		when(topicRepository.findAll()).thenReturn(Arrays.asList(new Topic("Java", "MW", "Java Programming")));
		assertEquals(1, topicService.getAllTopics().size());
	}
}

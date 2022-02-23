package com.spring.boot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.jpa.dao.TopicRepository;
import com.spring.boot.jpa.model.Topic;

@Component
public class TopicDao {

	@Autowired
	TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		System.out.println("getting all topics in TopicDao");
		Iterable<Topic> findAll = topicRepository.findAll();
		List<Topic> topic = (List<Topic>) findAll;
		System.out.println(topic);
		return topic;
	}
}

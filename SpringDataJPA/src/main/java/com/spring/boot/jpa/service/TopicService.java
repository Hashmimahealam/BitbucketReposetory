package com.spring.boot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.jpa.dao.TopicRepository;
import com.spring.boot.jpa.model.Topic;

@Service
public class TopicService
{
	@Autowired
	TopicRepository topicRepository;

	@Autowired
	TopicDao topicDao;
	
	public List<Topic> getAllTopics() {
		System.out.println("getting all topics in TopicService");
		return topicDao.getAllTopics();
	}

	public Topic getTopic(String id) {
		System.out.println("getting topic by id");
		return topicRepository.findById(id).orElse(new Topic());
	}

	public void addTopic(Topic topic) {
		System.out.println("adding topic");
		      topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		System.out.println("updating topic");
		 topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		System.out.println("deleting topic");
		topicRepository.deleteById(id);
	}
}

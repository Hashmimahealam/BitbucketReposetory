package com.spring.boot.jpa.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jpa.exceptions.BadRequestException;
import com.spring.boot.jpa.model.Topic;
import com.spring.boot.jpa.service.TopicService;

@RequestMapping("topics")
@RestController
public class TopicController {

	@Autowired
	TopicService topicService;
	
	@GetMapping
	public List<Topic> getAllTopics()
	{
		System.out.println("getAll topic in Topic Controller");
		return topicService.getAllTopics();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Topic> getTopic(@PathVariable String id) // ,@RequestHeader Map<String, String> headers
	{
		System.out.println("topic getAll controller");
//		headers.forEach((x,y) -> System.out.println(x+" "+y));
		
		Topic topic = null;
			if(id.isEmpty())
				throw new NullPointerException();	
			topic = topicService.getTopic(id);
			if(topic.getDescription() == null)
			{
				throw new BadRequestException("bade Request");
			}
		return ResponseEntity.ok().header("Custom-Header", "Topic-Custom").header("AAAA", "AAA").body(topic);
	}
	
	@PostMapping
	public Topic addTopic(@RequestBody Topic topic)
	{
		System.out.println("topic controller addTopic");
		topicService.addTopic(topic);
		return topic;
	}
	
	@PutMapping("/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		System.out.println("topic update controller");
	}
	
	@DeleteMapping("/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		System.out.println("delete topic controller");
		topicService.deleteTopic(id);
	}
}

package com.spring.boot.jpa.rest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jpa.model.Course;
import com.spring.boot.jpa.model.Topic;
import com.spring.boot.jpa.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	ResourceLoader resourceLoader;

	@Value("${user.home}")
	public String homePath;

	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId)
	{
		return courseService.getAllCourses(topicId);
	}
	
	@GetMapping("/topics/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String id)
	{
		return courseService.getCourse(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public Course addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return course;
	}
	
	@PutMapping("/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String courseId,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/topics/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId)
	{
		courseService.deleteCourse(courseId);
	}

	@GetMapping("/read")
	public void readFile() throws IOException {

//		String path = new ClassPathResource("classpath:abc.txt").getURI().toString();
//		System.out.println(path);
//
//		String url = new ClassPathResource("classpath:abc.txt").getURL().toString();
//		System.out.println(url);

		String path = resourceLoader.getResource("classpath:files/abc.txt").getFile().getAbsolutePath();
		System.out.println("path is " + path);
		String string = new String(Files.readAllBytes(Paths.get(path)));
		System.out.println(string);
		System.out.println(path);

		String homeDir = System.getProperty("user.home");
		System.out.println(homeDir);

		System.out.println("home path is " + homePath);
	}
}

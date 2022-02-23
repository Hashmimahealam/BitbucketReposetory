package com.spring.boot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.jpa.dao.CourseRepository;
import com.spring.boot.jpa.model.Course;

@Service
public class CourseService
{
	
	@Autowired
	CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courseList = new ArrayList<Course>();
		 courseRepository.findByTopicId(topicId).forEach(t -> courseList.add(t));
		 return courseList;
	}

	public Course getCourse(String courseId) 
	{
		return courseRepository.findById(courseId).orElse(new Course());
	}

	public void addCourse(Course course) 
	{
		      courseRepository.save(course);
	}

	public void updateCourse(Course course)
	{
		 courseRepository.save(course);
	}

	public void deleteCourse(String courseId) 
	{
		courseRepository.deleteById(courseId);
	}
}

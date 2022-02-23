package com.spring.boot.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.jpa.model.Course;

public interface CourseRepository extends CrudRepository<Course, String>
{
     public List<Course> findByTopicId(String toicId);
}

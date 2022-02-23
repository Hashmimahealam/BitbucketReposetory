package com.spring.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.jpa.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String>
{

}

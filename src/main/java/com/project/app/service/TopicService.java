package com.project.app.service;

import java.util.List;

import com.project.app.entities.Topic;

public interface TopicService {

	Topic getTopicById(Integer topicId);

	List<Topic> getAllTopics();

	boolean addTopic(Topic topic);

	void updateTopic(Topic topic);

	void deleteTopicById(Integer topicId);

}

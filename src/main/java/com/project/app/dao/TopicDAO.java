package com.project.app.dao;

import java.util.List;

import com.project.app.entities.Topic;

public interface TopicDAO {

	Topic getTopic(Integer topicId);

	List<Topic> getAllTopics();

	Topic addNewTopic(Topic topic);

	boolean isTopicExist(String title, String category);

	void updateTopic(Topic topic);

	void deleteTopic(Integer topicId);
	

	
}

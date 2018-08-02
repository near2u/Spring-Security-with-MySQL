package com.project.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.dao.TopicDAO;
import com.project.app.entities.Topic;
import com.project.app.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	TopicDAO topicDao;
	
	
	@Override
	public Topic getTopicById(Integer topicId) {
		return topicDao.getTopic(topicId);
	}


	@Override
	public List<Topic> getAllTopics() {
		return topicDao.getAllTopics();
	}


	
	@Override
	public boolean addTopic(Topic topic) {
		if(topicDao.isTopicExist(topic.getTitle(), topic.getCategory())) {
			return false;
		}else {
			topicDao.addNewTopic(topic);
			return true;
		}
		 
	}


	@Override
	public void updateTopic(Topic topic) {
		topicDao.updateTopic(topic);
	}


	@Override
	public void deleteTopicById(Integer topicId) {
		topicDao.deleteTopic(topicId);
	}

}

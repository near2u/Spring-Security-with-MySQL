package com.project.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.app.dao.TopicDAO;
import com.project.app.entities.Topic;

@Transactional
@Repository
public class TopicDaoImpl implements TopicDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Topic getTopic(Integer topicId) {
		return entityManager.find(Topic.class, topicId);
	}

	@Override
	public List<Topic> getAllTopics() {
		
		Query query = entityManager.createQuery("FROM Topic t");
		List resultList = query.getResultList();
		return resultList;
	}

	@Override
	public Topic addNewTopic(Topic topic) {
		entityManager.persist(topic);
		return null;
	}

	@Override
	public boolean isTopicExist(String title, String category) {
		int count = entityManager.createQuery("from Topic as t where t.title =? and t.category=?")
				.setParameter(1, title).setParameter(2, category).getResultList().size();
		return count > 0? true:false;
	}

	@Override
	public void updateTopic(Topic topic) {
		Topic fromDB = entityManager.find(Topic.class, topic.getTopicId());
		if(fromDB!=null) {
			fromDB.setTitle(topic.getTitle());
			fromDB.setCategory(topic.getCategory());
			
			entityManager.flush();
			
		} else {
			System.out.println("Topic cant find which you want to uopdate");
		}
		
	}

	@Override
	public void deleteTopic(Integer topicId) {
		Topic fromDB = entityManager.find(Topic.class, topicId);
		entityManager.remove(fromDB);
		
	}

}

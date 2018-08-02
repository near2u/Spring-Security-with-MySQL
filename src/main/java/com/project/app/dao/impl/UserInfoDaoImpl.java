package com.project.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.app.entities.UserInfo;
import com.project.app.service.UserInfoDao;

@Transactional
@Repository
public class UserInfoDaoImpl implements UserInfoDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	short ENABLED = 1;
	@Override
	public UserInfo getActiveUser(String userName) {
		
		UserInfo userInfo =  new UserInfo();
		List list = entityManager.createQuery("from UserInfo as u where u.userName=? and enabled=?").setParameter(1, userName).setParameter(2, ENABLED).getResultList();
		
		if(list!=null){
			userInfo = (UserInfo) list.get(0);
		}
		return userInfo;
	}

}

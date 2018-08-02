package com.project.app.service;

import com.project.app.entities.UserInfo;


public interface UserInfoDao {

	UserInfo getActiveUser(String userName);

}

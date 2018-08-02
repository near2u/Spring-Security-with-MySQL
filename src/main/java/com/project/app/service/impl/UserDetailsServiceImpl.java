package com.project.app.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.app.entities.UserInfo;
import com.project.app.service.UserInfoDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserInfo  userInfo = userInfoDao.getActiveUser(userName);
		GrantedAuthority auth = new SimpleGrantedAuthority(userInfo.getRole());
		
		User user =new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(auth));
		
		UserDetails userDetails =(UserDetails) user;
		
		return userDetails;
	}

}

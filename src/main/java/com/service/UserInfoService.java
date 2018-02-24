package com.service;

import java.util.List;

import com.domain.UserInfo;

public interface UserInfoService {

	String getOne();
	
	List<UserInfo> getAll();
	
	public UserInfo findByUsername(String username);
}

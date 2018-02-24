package com.dao;

import java.util.List;

import com.domain.UserInfo;

public interface UserInfoDao {
	
	String getOne();

	List<UserInfo> getAll();
	
	UserInfo findByUsername(String username);
}

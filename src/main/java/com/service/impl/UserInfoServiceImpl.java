package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserInfoDao;
import com.domain.UserInfo;
import com.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public String getOne() {
		return userInfoDao.getOne();
	}

	@Override
	public List<UserInfo> getAll() {
		return userInfoDao.getAll();
	}

}

package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SysPermissionDao;
import com.domain.SysPermission;
import com.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysPermissionDao sysPermissionDao;
	
	@Override
	public String getOne() {
		return sysPermissionDao.getOne();
	}

	@Override
	public List<SysPermission> getAll() {
		return sysPermissionDao.getAll();
	}

}

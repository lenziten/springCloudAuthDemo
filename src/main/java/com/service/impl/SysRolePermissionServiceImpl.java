package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SysRolePermissionDao;
import com.domain.SysRolePermission;
import com.service.SysRolePermissionService;

@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
	
	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

	@Override
	public String getOne() {
		return sysRolePermissionDao.getOne();
	}

	@Override
	public List<SysRolePermission> getAll() {
		return sysRolePermissionDao.getAll();
	}

}

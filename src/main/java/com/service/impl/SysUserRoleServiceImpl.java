package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SysUserRoleDao;
import com.domain.SysUserRole;
import com.service.SysUserRoleService;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public String getOne() {
		return sysUserRoleDao.getOne();
	}

	@Override
	public List<SysUserRole> getAll() {
		return sysUserRoleDao.getAll();
	}

}

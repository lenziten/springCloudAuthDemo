package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SysRoleDao;
import com.domain.SysRole;
import com.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Override
	public String getOne() {
		return sysRoleDao.getOne();
	}

	@Override
	public List<SysRole> getAll() {
		return sysRoleDao.getAll();
	}

}

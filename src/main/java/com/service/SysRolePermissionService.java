package com.service;

import java.util.List;

import com.domain.SysRolePermission;

public interface SysRolePermissionService {

	String getOne();
	
	List<SysRolePermission> getAll();
}

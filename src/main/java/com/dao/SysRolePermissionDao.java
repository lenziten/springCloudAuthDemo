package com.dao;

import java.util.List;

import com.domain.SysRolePermission;

public interface SysRolePermissionDao {
	
	String getOne();

	List<SysRolePermission> getAll();
}

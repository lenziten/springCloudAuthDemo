package com.dao;

import java.util.List;

import com.domain.SysPermission;

public interface SysPermissionDao {
	
	String getOne();
	
	List<SysPermission> getAll();

}

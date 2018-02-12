package com.domain;

import java.io.Serializable;

public class SysRolePermission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long permissionId;
	
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}

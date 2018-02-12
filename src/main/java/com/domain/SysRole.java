package com.domain;

import java.io.Serializable;
import java.util.List;

public class SysRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String role;
	
	private String description;
	
	private Boolean available = Boolean.FALSE;
	
	private List<SysPermission> permissions;
	
	private List<UserInfo> userInfos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	
			

}

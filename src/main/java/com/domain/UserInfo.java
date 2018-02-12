package com.domain;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long uid;
	
	private String username;
	
	private String name;
	
	private String password;
	
	private String salt;
	
	private byte state;
	
	private List<SysRole> roleList;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	
}

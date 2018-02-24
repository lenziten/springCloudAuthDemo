package com.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.UserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/userList")
	@RequiresPermissions("userInfo:view")
	public String userInfo(){
		return "userInfo";
	}
	
	@RequestMapping("/userAdd")
	@RequiresPermissions("userInfo:add")
	public String userInfoAdd(){
		return "userInfoAdd";
	}
	
	@RequestMapping("/userDel")
	@RequiresPermissions("userInfo:del")
	public String userDel(){
		return "userInfoDel";
	}
	
}

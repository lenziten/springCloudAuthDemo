package com.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.domain.SysPermission;
import com.service.SysPermissionService;

@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController {
	
	@Autowired
	private SysPermissionService sysPermissionService;
	
	@RequestMapping(value="/getOne",method=RequestMethod.GET)
	@ResponseBody
	public String getOne(){
		return sysPermissionService.getOne();
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@ResponseBody
	public String getAll(){
		List<SysPermission> list = sysPermissionService.getAll();
		if(null != list && !list.isEmpty()){
			return JSONArray.toJSONString(list);
		}
		return "none";
	}

}

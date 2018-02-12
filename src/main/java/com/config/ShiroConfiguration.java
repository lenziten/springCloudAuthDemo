package com.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager; 

//@Configuration
public class ShiroConfiguration {
	
//	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		System.out.println("ShiroConfiguration.shiroFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		//must set secutiryManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		//filter
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		
		filterChainDefinitionMap.put("/logout", "logout");

		filterChainDefinitionMap.put("/**", "authc");
		
		shiroFilterFactoryBean.setLoginUrl("/login");
		
		shiroFilterFactoryBean.setSuccessUrl("/index");
		
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
	}
	
//	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		return securityManager;
	}

}

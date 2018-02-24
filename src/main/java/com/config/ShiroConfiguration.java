package com.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shiro.MyShiroRealm;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager; 

@Configuration
public class ShiroConfiguration {
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		System.out.println("ShiroConfiguration.shiroFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		//must set secutiryManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		//filter
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		
		filterChainDefinitionMap.put("/logout", "logout");

		filterChainDefinitionMap.put("/userInfo/**", "perms[userInfo:*]");

		filterChainDefinitionMap.put("/**", "authc");
		
		shiroFilterFactoryBean.setLoginUrl("/login");
		
		shiroFilterFactoryBean.setSuccessUrl("/index");
		
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
	}
	
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}
	
	/**身份认证realm*/
	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}
	
	/**凭证匹配器*/
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法
		hashedCredentialsMatcher.setHashIterations(2);//散列次数,相当于md5(md5)加密了两次
		
		return hashedCredentialsMatcher;
	}
	
	/**开启shiro aop注解支持
	 * 使用代理方式，所以需要开启代码支持*/
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizatinAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

}

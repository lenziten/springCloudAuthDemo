package com.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.domain.SysPermission;
import com.domain.SysRole;
import com.domain.UserInfo;
import com.service.UserInfoService;

/**
 * 身份校验
 * */
public class MyShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private UserInfoService userInfoService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthrizationInfo()");
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
		
		for(SysRole role : userInfo.getRoleList()){
			
			authorizationInfo.addRole(role.getRole());
			System.out.println(role.getPermissions());
			for(SysPermission p : role.getPermissions()){
				System.out.println(JSONObject.toJSON(p));
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		//获取用户的输入账号
		String username = (String) token.getPrincipal();
		System.out.println(token.getCredentials());
		List<UserInfo> a = userInfoService.selectA();
		System.out.println(JSONArray.toJSONString(a));
		//通过username从数据库中查找user对象
		UserInfo userInfo = userInfoService.findByUsername(username);
		System.out.println("---->>userInfo="+JSONObject.toJSONString(userInfo));
		if(userInfo == null){
			return null;
		}
		
		SimpleAuthenticationInfo authenticationInfo = new  SimpleAuthenticationInfo(userInfo,
				userInfo.getPassword(),
				ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
				getName());
		
		return authenticationInfo;
	}

}

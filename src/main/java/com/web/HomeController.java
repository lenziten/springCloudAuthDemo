package com.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/home")
public class HomeController {

	@RequestMapping({"/","index"})
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
//		return "forward:/index.jsp";//templates/login.html
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,Map<String,Object> map){
		System.out.println("HomeController.login");
		/*获取shiro类的全类名*/
		String exception = (String) request.getAttribute("shiroLoginFailure");
		String msg = "";
		if(null != exception){
			if(UnknownAccountException.class.getName().equals(exception)){
				System.out.println("UnknownAccountException --> 账号不存在:");
				msg = "UnknownAccountException --> 账号不存在:";
			}else if(IncorrectCredentialsException.class.getName().equals(exception)){
				System.out.println("IncorrectCredentialsException --> 密码不正确");
				msg = "IncorrectCredentialsException --> 密码不正确";
			}else if("kaptchaValidateFailed --> 验证码错误".equals(exception)){
				System.out.println("kaptchaValidateFailed --> 验证码错误");
				msg = "kaptchaValidateFailed --> 验证码错误";
			}else{
				msg = "else --> " + exception;
				System.out.println("else --> " +exception);
			}
		}
		
		map.put("msg", msg);
		return "/login";
	}
}

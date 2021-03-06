package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.User;
import com.service.DemoComponent;
import com.service.UserService;

@RestController
@RequestMapping("/exit")
public class CloseController {
	
    @Autowired
    private ApplicationContext appContext;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private DemoComponent demoComponent;
	
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String test(){
//    	System.out.println(userService.queryById("244B6AC3-66D9-4EE0-ACD1-C8061FD0631D").get("user_id"));
//    	return userService.getOne();
    	return (String) userService.queryById("0A7B50C6-B27E-47E2-AC3D-FA68298A8D0D").get("user_id");
//    	return demoComponent.getDemo();
    }
    
    @RequestMapping(value="updateById",method=RequestMethod.GET)
    public String updateById(){
    	User user = new User();
    	user.setUserId("1B20D00E-6C8B-42B1-88B6-DD8577FD0720");
    	Integer result = userService.updateById(user);
    	return result.toString();
    }
    
    @RequestMapping("/shutDown")
	public String shutDownBoot(){
    	int result = SpringApplication.exit(appContext);
		return String.valueOf(result);
	}

}

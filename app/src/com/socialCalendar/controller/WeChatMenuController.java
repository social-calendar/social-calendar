package com.socialCalendar.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socialCalendar.pojo.User;
import com.socialCalendar.service.UserService;

/** 
* 微信OAuth2.0网页授权 
* @author  
*/
@Controller  
@RequestMapping("/wechat")
public class WeChatMenuController {
 
	 public static final String DOMAIN = "localhost";
    @Resource(name="userService")
    private UserService userService;
    
    @RequestMapping("/test")
    public void OAuth(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String activeId = request.getParameter("activeId");
    	System.out.println("activeId:"+activeId);
    	User userinfo = userService.findByUserIdUser(17);
    	System.out.println("userInfo:"+userinfo);
    	HttpSession session = request.getSession();	
    	session.setAttribute("user", userinfo);
    	response.sendRedirect("/app/build/detail.html?activeId="+activeId);
    }
}


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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
    	String activteId = request.getParameter("activteId");
    	User userinfo = userService.findByUserIdUser(Integer.valueOf(activteId));
    	System.out.println("userInfo:"+userinfo);
    	HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();	
    	session.setAttribute("user", userinfo);
    	response.sendRedirect("http://"+DOMAIN+"/app/build/index.html");
    }
 
 
}
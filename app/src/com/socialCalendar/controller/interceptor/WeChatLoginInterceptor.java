/*package com.socialCalendar.controller.interceptor;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.socialCalendar.controller.WeChatMenuController;
import com.socialCalendar.pojo.User;
import com.socialCalendar.service.UserService;

public class WeChatLoginInterceptor implements HandlerInterceptor {
	
	public static final String DOMAIN = "localhost";
    @Resource(name="userService")
    private UserService userService;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			return true;
		}
		//取出请求的url
		String url = request.getRequestURI();
		if(url.indexOf("loginsubmit.action")>=0){
			//说明 公开地址
			//放行
			
		}		
		//得到session
		
		
		//从 session取出用户身份信息
		
		
		if(user!=null){
			//说明 用户已登陆（用户身份合法）
			//放行
			return true;			
		}else{					
			this.OAuth(request, response);
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle--------------");

		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
			System.out.println("afterCompletion--------------");
		
	}	    
	
}
*/
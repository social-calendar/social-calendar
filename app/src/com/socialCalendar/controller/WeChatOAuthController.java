/*package com.socialCalendar.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

*//** 
* 微信OAuth2.0网页授权 
* @author  
*//* 
@Controller  
@RequestMapping("/wechat/oauth")
public class WeChatOAuthController extends BaseController{
	private static final long serialVersionUID = -1847238807216447030L;
	@RequestMapping(method=RequestMethod.GET)
	public void oauth(){
		ModelAndView mv=new ModelAndView();
	}
	public void (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");// 用户同意授权后，能获取到code
		  String code = request.getParameter("code");// 用户同意授权
		  if (!"authdeny".equals(code)) {
		   // 获取网页授权access_token
		   WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("APPID", "APPSECRET", code);
		   // 网页授权接口访问凭证
		   String accessToken = weixinOauth2Token.getAccessToken();
		   // 用户标识
		   String openId = weixinOauth2Token.getOpenId();
		   // 获取用户信息
		   SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);[/align][align=left]   // 设置要传递的参数
		   request.setAttribute("snsUserInfo", snsUserInfo);
		  }
		  // 跳转到index.jsp
		  request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
}
*/
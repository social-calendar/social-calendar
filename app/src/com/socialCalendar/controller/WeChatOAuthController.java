/*package com.socialCalendar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.socialCalendar.WeChat.util.CommonUtil;

*//** 
* 微信OAuth2.0网页授权 
* @author  
*//* 
@Controller  
@RequestMapping("/wechat/oauth")
public class WeChatOAuthController extends BaseController{
	private static final long serialVersionUID = -6445185082623423416L;
	private String get_access_token_url="https://api.weixin.qq.com/sns/oauth2/access_token?" +
	        "appid=APPID" +
	        "&secret=SECRET&" +
	        "code=CODE&grant_type=authorization_code";
	private String get_userinfo_url="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	@RequestMapping(method=RequestMethod.GET)
	public void oauth(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{    
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");// 用户同意授权后，能获取到code
		  String code = request.getParameter("code");// 用户同意授权
		  get_access_token_url=get_access_token_url.replace("APPID", CommonUtil.appId);
	      get_access_token_url=get_access_token_url.replace("SECRET", CommonUtil.appSecret);
	      get_access_token_url=get_access_token_url.replace("CODE", code);	        
	      
	      String json=CommonUtil.httpsRequest(requestUrl, requestMethod, outputStr).getUrl(get_access_token_url);	     	        
	      JSONObject jsonObject=JSONObject.fromObject(json);
	      String access_token=jsonObject.getString("access_token");
	        String openid=jsonObject.getString("openid");
	        
	        get_userinfo=get_userinfo.replace("ACCESS_TOKEN", access_token);
	        get_userinfo=get_userinfo.replace("OPENID", openid);
	        
	        String userInfoJson=HttpUtil.getUrl(get_userinfo);
	        
	        JSONObject userInfoJO=JSONObject.fromObject(userInfoJson);
	        
	        String user_openid=userInfoJO.getString("openid");
	        String user_nickname=userInfoJO.getString("nickname");
	        String user_sex=userInfoJO.getString("sex");
	        String user_province=userInfoJO.getString("province");
	        String user_city=userInfoJO.getString("city");
	        String user_country=userInfoJO.getString("country");
	        String user_headimgurl=userInfoJO.getString("headimgurl");
		
}
*/
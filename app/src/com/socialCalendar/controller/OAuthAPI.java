package com.socialCalendar.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.socialCalendar.WeChat.util.CommonUtil;
import com.socialCalendar.pojo.User;
import com.socialCalendar.service.UserService;

/** 
* 微信OAuth2.0网页授权 
* @author  
*/ 
@Controller  
@RequestMapping("/wechat")
public class OAuthAPI {
 
	
	public static final String DOMAIN = "152m09481l.iask.in";
    //public static final String DOMAIN = "isolarfun.com";
    
    @Resource(name="userService")
    private UserService userService;
    
    @RequestMapping("/oauthOne")
    public void toIndexOauth(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        String code = request.getParameter("code");
        HttpSession session =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();	        
        boolean isValidCode = true;
        String serviceUrl = URLEncoder.encode(
                "http://" + DOMAIN + request.getRequestURI(), "utf-8");
        //检查是否已验证或者验证是否通过
        if (code == null || code.equals("authdeny")) {
            isValidCode = false;
        }
        //如果session未空或者取消授权，重定向到授权页面
        if ((!isValidCode) && session.getAttribute("user") == null) {
            StringBuilder oauth_url = new StringBuilder();
            oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
            oauth_url.append("appid=").append(CommonUtil.appId);
            oauth_url.append("&redirect_uri=").append(serviceUrl);
            oauth_url.append("&response_type=code");
            oauth_url.append("&scope=snsapi_userinfo");
            oauth_url.append("&state=");
            oauth_url.append("&state=STATE");            
            oauth_url.append("#wechat_redirect");
            response.sendRedirect(oauth_url.toString());
            return;
        }
        //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
        if (isValidCode && session.getAttribute("user") == null) {
                User member = null;
                JSONObject obj = OAuthAPI.getAccessToken(CommonUtil.appId,CommonUtil.appSecret, code);
                String token = obj.getString("access_token");
                String openid = obj.getString("openid");
                System.out.println();
                JSONObject userinfo = OAuthAPI.getUserInfo(token, openid);
                System.out.println(member);
                member = userService.saveOrUpdate(userinfo);
                session.setAttribute("user", member);
        }
                response.sendRedirect("http://"+DOMAIN+"/app/build/index.html"); 
       

    }   
    @RequestMapping("/oauthTwo")
    public void toAddOauth(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        String code = request.getParameter("code");
        HttpSession session =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();	        
        boolean isValidCode = true;
        String serviceUrl = URLEncoder.encode(
                "http://" + DOMAIN + request.getRequestURI(), "utf-8");
        //检查是否已验证或者验证是否通过
        if (code == null || code.equals("authdeny")) {
            isValidCode = false;
        }
        //如果session未空或者取消授权，重定向到授权页面
        if ((!isValidCode) && session.getAttribute("user") == null) {
            StringBuilder oauth_url = new StringBuilder();
            oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
            oauth_url.append("appid=").append(CommonUtil.appId);
            oauth_url.append("&redirect_uri=").append(serviceUrl);
            oauth_url.append("&response_type=code");
            oauth_url.append("&scope=snsapi_userinfo");
            oauth_url.append("&state=");
            oauth_url.append("&state=STATE");            
            oauth_url.append("#wechat_redirect");
            response.sendRedirect(oauth_url.toString());
            return;
        }
        //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
       if (isValidCode&&session.getAttribute("user") == null) {
                User member = null;
                JSONObject obj = OAuthAPI.getAccessToken(CommonUtil.appId,CommonUtil.appSecret, code);
                String token = obj.getString("access_token");
                String openid = obj.getString("openid");
                System.out.println();
                JSONObject userinfo = OAuthAPI.getUserInfo(token, openid);
                System.out.println(member);
                member = userService.saveOrUpdate(userinfo);
                session.setAttribute("user", member);
       }
                response.sendRedirect("http://"+DOMAIN+"/app/build/add.html"); 
    }
    
    @RequestMapping("/oauthThree")
    public void toDetailOauth(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        String code = request.getParameter("code");
        String activeId = request.getParameter("activeId");        
        HttpSession session =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();	        
        if(activeId!=null)
        	session.setAttribute("activeId",activeId);  
        String reUrl=null;
        boolean isValidCode = true;
        if(activeId==null)
          {
        	reUrl = "http://"+DOMAIN+"/app/build/detail.html?"+"activeId="+session.getAttribute("activeId");
          }
        else reUrl = "http://"+DOMAIN+"/app/build/detail.html?"+"activeId="+activeId;
        String serviceUrl = URLEncoder.encode(
                "http://" + DOMAIN +"/app/wechat/oauthThree.do", "utf-8");
        //检查是否已验证或者验证是否通过
        if (code == null || code.equals("authdeny")) {
            isValidCode = false;
        }
        //如果session未空或者取消授权，重定向到授权页面
        if ((!isValidCode) && session.getAttribute("user") == null) {
            StringBuilder oauth_url = new StringBuilder();
            oauth_url.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
            oauth_url.append("appid=").append(CommonUtil.appId);
            oauth_url.append("&redirect_uri=").append(serviceUrl);
            oauth_url.append("&response_type=code");
            oauth_url.append("&scope=snsapi_userinfo");
            oauth_url.append("&state=STATE");
            oauth_url.append("#wechat_redirect"); 
            response.sendRedirect(oauth_url.toString());
            return;
        }
        //如果用户同意授权并且，用户session不存在，通过OAUTH接口调用获取用户信息
       if(isValidCode&&session.getAttribute("user") == null){
                User member = null;
                JSONObject obj = OAuthAPI.getAccessToken(CommonUtil.appId,CommonUtil.appSecret, code);
                String token = obj.getString("access_token");
                String openid = obj.getString("openid");
                System.out.println();
                JSONObject userinfo = OAuthAPI.getUserInfo(token, openid);
                System.out.println(member);
                member = userService.saveOrUpdate(userinfo);
                session.setAttribute("user", member);
       }
                response.sendRedirect(reUrl); 
    }
    /**
     * 获取授权令牌
     * */
    public static JSONObject getAccessToken(String appid, String secret,
            String code) {
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");   
        url.append("appid=" + appid);
        url.append("&secret=").append(secret);
        url.append("&code=").append(code);
        url.append("&grant_type=authorization_code");
        return CommonUtil.httpsRequest(url.toString(),"GET",null);
    }
 
    //获取用户信息
    public static JSONObject getUserInfo(String token, String openid) {
        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/sns/userinfo?");
        url.append("access_token=" + token);
        url.append("&openid=").append(openid);
        url.append("&lang=zh_CN");
        return CommonUtil.httpsRequest(url.toString(),"GET",null);
    } 
}
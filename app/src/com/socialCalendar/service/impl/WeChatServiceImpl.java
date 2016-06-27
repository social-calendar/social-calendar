package com.socialCalendar.service.impl;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import weChat.test.MenuManager;

import com.socialCalendar.WeChat.menu.Menu;
import com.socialCalendar.WeChat.pojo.WeChatUserInfo;
import com.socialCalendar.WeChat.util.CommonUtil;
import com.socialCalendar.service.WeChatService;
@Service("weChatService")
public class WeChatServiceImpl implements WeChatService {
	
	public String processRequest(HttpServletRequest request){
		return null;	
	}

	@Override
	public WeChatUserInfo getWeChatUserInfo(String accessToken, String openId) {
		    return null;
	
	}

	@Override
	public boolean createMenu(Menu menu, String accessToken) {
		return false;
	}

	@Override
	public String getMenu(String accessToken) {
		return null;
	}

	@Override
	public boolean deleteMenu(String accessToken) {
		return false;
	}
}

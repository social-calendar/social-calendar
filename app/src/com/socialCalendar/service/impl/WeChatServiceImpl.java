package com.socialCalendar.service.impl;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.socialCalendar.WeChat.menu.Menu;
import com.socialCalendar.WeChat.pojo.Config;
import com.socialCalendar.WeChat.pojo.Token;
import com.socialCalendar.WeChat.pojo.WeChatUserInfo;
import com.socialCalendar.WeChat.util.CommonUtil;
import com.socialCalendar.service.WeChatService;
import com.socialCalendar.WeChat.util.Sha1Util;

@Service("weChatService")
public class WeChatServiceImpl implements WeChatService {

	public String processRequest(HttpServletRequest request) {
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

	@Override
	public Config getConfig(String activiteUrl) {
		Config cofig = new Config();
		String appId = CommonUtil.appId;
		Token token = CommonUtil.getToken(CommonUtil.appId,
				CommonUtil.appSecret);
		String access_token = token.getAccessToken();
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
				+ access_token + "&type=jsapi";
		//String postUrl="http://isolarfun/app/build/detail.html?"+activiteUrl;
		JSONObject json = CommonUtil.httpsRequest(requestUrl, "GET", null);
		String jsapi_ticket = json.getString("ticket");
		String timestamp = Sha1Util.getTimeStamp();
		String nonceStr = Sha1Util.getNonceStr();
		String signature=null;
		try {
			SortedMap<String, String> packageParams = new TreeMap<String, String>();
			packageParams.put("jsapi_ticket", jsapi_ticket);
			packageParams.put("noncestr", nonceStr);
			packageParams.put("timestamp", timestamp);
			packageParams.put("url", activiteUrl);
			signature = Sha1Util.createSHA1Sign(packageParams);
		} catch (Exception e) {
			e.printStackTrace();
		}
			cofig.setAppId(appId);
			cofig.setSignature(signature);
			cofig.setNonceStr(nonceStr);
			cofig.setTimestamp(timestamp);
		return cofig;
	}
}

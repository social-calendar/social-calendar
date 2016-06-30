package com.socialCalendar.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.socialCalendar.WeChat.menu.Menu;
import com.socialCalendar.WeChat.message.resp.TextMessage;
import com.socialCalendar.WeChat.pojo.Config;
import com.socialCalendar.WeChat.pojo.Token;
import com.socialCalendar.WeChat.pojo.WeChatUserInfo;
import com.socialCalendar.WeChat.util.CommonUtil;
import com.socialCalendar.service.WeChatService;
import com.socialCalendar.WeChat.util.Sha1Util;
import com.socialCalendar.WeChat.util.MessageUtil;

@Service("weChatService")
public class WeChatServiceImpl implements WeChatService {
	
	public String processRequest(HttpServletRequest request) {
		// xml格式的消息数据
		String respXml = null;
		// 默认返回的文本消息内容
		String respContent = "未知的消息类型！";
		try {
			// 调用parseXml方法解析请求消息
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号
			String fromUserName = requestMap.get("FromUserName");
			// 开发者微信号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "您发送的是文本消息！社交日历暂时还不提供此服务喔！";
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！社交日历暂时还不提供此服务的处理喔！";
			}
			// 语音消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是语音消息！社交日历暂时还不提供此服务的处理喔！";
			}
			// 视频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
				respContent = "您发送的是视频消息！社交日历暂时还不提供此服务的处理喔！";
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息社交日历暂时还不提供此服务的处理喔！！";
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！社交日历暂时还不提供此服务的处理喔！";
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 关注
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "团队人员：李焕,石佳楠,贺志凯,王小调. 社交日历欢迎您的关注，我们将为你提供最优质的服务!-----.";
				}
				// 取消关注
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
				}
				// 扫描带参数二维码
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
					// TODO 处理扫描带参数二维码事件
				}
				// 上报地理位置
				else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
					// TODO 处理上报地理位置事件
				}
				// 自定义菜单
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 处理菜单点击事件
				}
			}
			// 设置文本消息的内容
			textMessage.setContent(respContent);
			// 将文本消息对象转换成xml
			respXml = MessageUtil.messageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
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

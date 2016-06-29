package com.socialCalendar.service;

import javax.servlet.http.HttpServletRequest;

import com.socialCalendar.WeChat.menu.Menu;
import com.socialCalendar.WeChat.pojo.Config;
import com.socialCalendar.WeChat.pojo.WeChatUserInfo;

public interface WeChatService {
	/**
	 * 微信请求处理类
	 * 
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request);

	/**
	 * 获取微信用户信息
	 * 
	 * @param accessToken
	 * @param openId
	 * @return
	 */
	public WeChatUserInfo getWeChatUserInfo(String accessToken, String openId);

	/**
	 * 创建自定义菜单
	 * 
	 * @param menu
	 * @param accessToken
	 *            凭证
	 * @return
	 */
	public boolean createMenu(Menu menu, String accessToken);

	/**
	 * 获取自定义菜单
	 * 
	 * @param accessToken
	 *            凭证
	 * @return
	 */
	public String getMenu(String accessToken);

	/**
	 * 删除自定义菜单
	 * 
	 * @param accessToken
	 *            凭证
	 * @return
	 */
	public boolean deleteMenu(String accessToken);
	
	/**
	 * 		获得JSJSDK
	 * appId:  // 必填，公众号的唯一标识
     * timestamp // 必填，生成签名的时间戳
     * nonceStr // 必填，生成签名的随机串
     * signature // 必填，签名，见附录1
	 * @return
	 */
	public Config getConfig(String activiteUrl);

}

package com.socialCalendar.WeChat.util;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.socialCalendar.WeChat.menu.Menu;
import com.socialCalendar.WeChat.pojo.WeChatUserInfo;

/**
 * 自定义菜单和用户信息获取工具类
 * 
 */
public class MenuUtil {
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

	// 菜单创建（POST）
	public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 菜单查询（GET）
	public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 菜单删除（GET）
	public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单实例
	 * @param accessToken 凭证
	 * @return true成功 false失败
	 */
	public static boolean createMenu(Menu menu, String accessToken) {
		boolean result = false;
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 发起POST请求创建菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				log.error("创建菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}

		return result;
	}

	/**
	 * 查询菜单
	 * 
	 * @param accessToken 凭证
	 * @return
	 */
	public static String getMenu(String accessToken) {
		String result = null;
		String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
		// 发起GET请求查询菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			result = jsonObject.toString();
		}
		return result;
	}

	/**
	 * 删除菜单
	 * 
	 * @param accessToken 凭证
	 * @return true成功 false失败
	 */
	public static boolean deleteMenu(String accessToken) {
		boolean result = false;
		String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
		// 发起GET请求删除菜单
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
			} else {
				result = false;
				log.error("删除菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}
	/**
	 * 获取用户基本信息
	 * @param accessToken 凭证
	 * @param openId 用户openId
	 * @return
	 */
	public static WeChatUserInfo getUserInfo(String accessToken, String openId) {
		WeChatUserInfo weixinUserInfo = null;
	    // 拼接请求地址
	    String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
	    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
	    // 获取用户信息
	    JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
	    if (null != jsonObject) {
	      try {
	        weixinUserInfo = new WeChatUserInfo();
	        // 用户的标识
	        weixinUserInfo.setOpenid(jsonObject.getString("openid"));
	        // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
	        weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
	        // 用户关注时间
	        weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
	        // 昵称
	        weixinUserInfo.setNickname(jsonObject.getString("nickname"));
	        // 用户的性别（1是男性，2是女性，0是未知）
	        weixinUserInfo.setSex(jsonObject.getInt("sex"));
	        // 用户所在国家
	        weixinUserInfo.setCountry(jsonObject.getString("country"));
	        // 用户所在省份
	        weixinUserInfo.setProvince(jsonObject.getString("province"));
	        // 用户所在城市
	        weixinUserInfo.setCity(jsonObject.getString("city"));
	        // 用户的语言，简体中文为zh_CN
	        weixinUserInfo.setLanguage(jsonObject.getString("language"));
	        // 用户头像
	        weixinUserInfo.setHeadImgurl(jsonObject.getString("headimgurl"));
	      } catch (Exception e) {
	        if (0 == weixinUserInfo.getSubscribe()) {
	          log.error("用户{}已取消关注", weixinUserInfo.getOpenid());
	        } else {
	          int errorCode = jsonObject.getInt("errcode");
	          String errorMsg = jsonObject.getString("errmsg");
	          log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
	        }
	      }
	    }
	    return weixinUserInfo;
	  }
}
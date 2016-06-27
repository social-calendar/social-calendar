package weChat.test;

import com.socialCalendar.WeChat.menu.Button;
import com.socialCalendar.WeChat.menu.ClickButton;
import com.socialCalendar.WeChat.menu.ComplexButton;
import com.socialCalendar.WeChat.menu.Menu;
import com.socialCalendar.WeChat.menu.ViewButton;
import com.socialCalendar.WeChat.pojo.Token;
import com.socialCalendar.WeChat.pojo.WeChatUserInfo;
import com.socialCalendar.WeChat.util.CommonUtil;
import com.socialCalendar.WeChat.util.MenuUtil;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器类
 * 
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	/**
	 * 定义菜单结构
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		/*ClickButton btn11 = new ClickButton();
		btn11.setName("开源中国");
		btn11.setType("click");
		btn11.setKey("oschina");

		ClickButton btn12 = new ClickButton();
		btn12.setName("ITeye");
		btn12.setType("click");
		btn12.setKey("iteye");

		ViewButton btn13 = new ViewButton();
		btn13.setName("CocoaChina");
		btn13.setType("view");
		btn13.setUrl("http://www.iteye.com");

		ViewButton btn21 = new ViewButton();
		btn21.setName("淘宝");
		btn21.setType("view");
		btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx46126c68d98f25b7&redirect_uri=http://152m09481l.iask.in/Javen/OauthTest&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
*/
		ViewButton btn11 = new ViewButton();
		btn11.setName("我的活动");
		btn11.setType("view");
		btn11.setUrl("http://social.ngrok.cc/app/build/index.html");
		
		ViewButton btn12 = new ViewButton();
		btn12.setName("创建活动");
		btn12.setType("view");
		btn12.setUrl("http://social.ngrok.cc/app/build/index.html");
		
		ViewButton btn22 = new ViewButton();
		btn22.setName("精选活动");
		btn22.setType("view");
		btn22.setUrl("http://social.ngrok.cc/app/build/add.html");

	/*	ViewButton btn23 = new ViewButton();
		btn23.setName("唯品会");
		btn23.setType("view");
		btn23.setUrl("http://m.vipshop.com");

		ViewButton btn24 = new ViewButton();
		btn24.setName("当当网");
		btn24.setType("view");
		btn24.setUrl("http://m.dangdang.com");

		ViewButton btn25 = new ViewButton();
		btn25.setName("苏宁易购");
		btn25.setType("view");
		btn25.setUrl("http://m.suning.com");

		ViewButton btn31 = new ViewButton();
		btn31.setName("多泡");
		btn31.setType("view");
		btn31.setUrl("http://www.duopao.com");

		ViewButton btn32 = new ViewButton();
		btn32.setName("一窝88");
		btn32.setType("view");
		btn32.setUrl("http://www.yi588.com");*/

		/*ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("调哥");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("调哥");
		mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24, btn25 });*/

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("活动管理");
		mainBtn1.setSub_button(new Button[] {btn11,btn12 });
		
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("发现");
		mainBtn2.setSub_button(new Button[] {btn22});

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1,mainBtn2 });

		return menu;
	}

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx46126c68d98f25b7";
		// 第三方用户唯一凭证密钥
		String appSecret = "629ce902a1b930959e4aabb105c04977";

		// 调用接口获取凭证
		Token token = CommonUtil.getToken(appId, appSecret);

		System.out.println(MenuManager.getUserInfo(token.getAccessToken(),"oFHjkv-aOf41CM1yRa8vosE1BstE"));
		
		if (null != token) {
			// 创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
			
			// 判断菜单创建结果
			if (result)
				log.info("菜单创建成功！");
			else
				log.info("菜单创建失败！");
		}
	}
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

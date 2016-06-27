package com.socialCalendar.WeChat.pojo;
/**
 * 微信用户信息实体类
 * @author XD
 */
public class WeChatUserInfo {
	 // 用户的标识 (openid)
	private String openid;
    // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息(subscribe)
    private Integer subscribe;
    // 用户关注时间 (subscribe_time)
    private String subscribeTime;
    // 昵称(nickname)
    private String nickname;
    // 用户的性别（1是男性，2是女性，0是未知）(sex)
    private Integer sex;
    // 用户所在国家(country)
    private String country;
    // 用户所在省份(province)
    private String province;
    // 用户所在城市(city)
    private String city;
    // 用户的语言，简体中文为zh_CN(language)
    private String language;
    // 用户头像(headimgurl)
    private String headImgurl;
    
    public WeChatUserInfo() {
		// TODO Auto-generated constructor stub
	}
    
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}
	public String getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadImgurl() {
		return headImgurl;
	}
	public void setHeadImgurl(String headImgurl) {
		this.headImgurl = headImgurl;
	}
	@Override
	public String toString() {
		return "WeChatUserInfo [openid=" + openid + ", subscribe=" + subscribe
				+ ", subscribeTime=" + subscribeTime + ", nickname=" + nickname
				+ ", sex=" + sex + ", country=" + country + ", province="
				+ province + ", city=" + city + ", language=" + language
				+ ", headImgurl=" + headImgurl + "]";
	}
	public WeChatUserInfo(String openid, Integer subscribe,
			String subscribeTime, String nickname, Integer sex, String country,
			String province, String city, String language, String headImgurl) {
		super();
		this.openid = openid;
		this.subscribe = subscribe;
		this.subscribeTime = subscribeTime;
		this.nickname = nickname;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.language = language;
		this.headImgurl = headImgurl;
	}
}

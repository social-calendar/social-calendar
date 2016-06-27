package com.socialCalendar.pojo;

public class User {
	private Integer id;	//用户id
	private String openID;//微信用户openID	
	private String nickname;//微信用户昵称
	private String sex;//微信用户性别，1-男，2-女，0-未知
	private String headimgurl;//微信用户头像地址
	private String subscribe;//用户是否订阅该公众号标识，0-没有关注该公众号，拉取不到其余信息。
	private String subscribeTime;//用户关注时间
	
	public User() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", openID=" + openID + ", nickname="
				+ nickname + ", sex=" + sex + ", headimgurl=" + headimgurl
				+ ", subscribe=" + subscribe + ", subscribeTime="
				+ subscribeTime + "]";
	}
	public User(Integer id, String openID, String nickname, String sex,
			String headimgurl, String subscribe, String subscribeTime) {
		super();
		this.id = id;
		this.openID = openID;
		this.nickname = nickname;
		this.sex = sex;
		this.headimgurl = headimgurl;
		this.subscribe = subscribe;
		this.subscribeTime = subscribeTime;
	}
	
	
}

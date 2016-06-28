package com.socialCalendar.pojo;

import java.sql.Timestamp;

public class User {
	private Integer id;	//用户id
	private String openID;//微信用户openID	
	private String nickname;//微信用户昵称
	private Integer sex;//微信用户性别，1-男，2-女，0-未知
	private String headimgurl;//微信用户头像地址
	private Integer subscribe;//用户是否订阅该公众号标识，0-没有关注该公众号，拉取不到其余信息。
	private Timestamp subscribeTime;//用户关注时间
	
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public Timestamp getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Timestamp subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", openID=" + openID + ", nickname="
				+ nickname + ", sex=" + sex + ", headimgurl=" + headimgurl
				+ ", subscribe=" + subscribe + ", subscribeTime="
				+ subscribeTime + "]";
	}

	public User(Integer id, String openID, String nickname, Integer sex,
			String headimgurl, Integer subscribe, Timestamp subscribeTime) {
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

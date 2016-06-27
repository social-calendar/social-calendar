package com.socialCalendar.dataModel;

import java.sql.Timestamp;

public class CommentDetail {
	private String userAvatar;
	private String userName;
	private String content;
	private String time;
	
	public CommentDetail() {
		// TODO Auto-generated constructor stub
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public CommentDetail(String userAvatar, String userName, String content,
			String time) {
		super();
		this.userAvatar = userAvatar;
		this.userName = userName;
		this.content = content;
		this.time = time;
	}
	@Override
	public String toString() {
		return "CommentDetail [userAvatar=" + userAvatar + ", userName="
				+ userName + ", content=" + content + ", time=" + time + "]";
	}
	

}

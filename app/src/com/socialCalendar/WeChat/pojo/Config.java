package com.socialCalendar.WeChat.pojo;

public class Config {
	private  String appId; // 必填，公众号的唯一标识	
	private  String signature;	
	private  String timestamp;  // 必填，生成签名的随机串
	private  String nonceStr; // 必填，生成签名的随机串
	
	public Config() {
		// TODO Auto-generated constructor stub
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "Config [appId=" + appId + ", signature=" + signature
				+ ", timestamp=" + timestamp + ", nonceStr=" + nonceStr + "]";
	}
	public Config(String appId, String signature, String timestamp,
			String nonceStr) {
		super();
		this.appId = appId;
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonceStr = nonceStr;
	}
	
}

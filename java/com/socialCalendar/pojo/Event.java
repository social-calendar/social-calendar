package com.socialCalendar.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * 活动实体类
 * 
 * @author NumberSevens
 * 
 */
public class Event {
	private Integer id;// 活动id，主键唯一标识
	private String title;// 活动标题
	private Timestamp startDate;// 活动开始时间
	private Timestamp endDate;// 活动结束时间
	private Integer maxPeople;// 最大参与人数
	private String tag;// 活动标签
	private String content;// 活动内容
	private String place;// 活动地点
	private Integer state; // 活动状态：0未发布，1已发布，2已过期
	private Integer promoterID;//活动发起人id
	
	private User promoter;//参与人
	
	
	private List<EventDetail> eventDetails;//参与人详情集


	public Event() {
		
	}
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}


	public Timestamp getEndDate() {
		return endDate;
	}


	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	public Integer getMaxPeople() {
		return maxPeople;
	}


	public void setMaxPeople(Integer maxPeople) {
		this.maxPeople = maxPeople;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public Integer getPromoterID() {
		return promoterID;
	}


	public void setPromoterID(Integer promoterID) {
		this.promoterID = promoterID;
	}


	public User getPromoter() {
		return promoter;
	}


	public void setPromoter(User promoter) {
		this.promoter = promoter;
	}


	public List<EventDetail> getEventDetails() {
		return eventDetails;
	}


	public void setEventDetails(List<EventDetail> eventDetails) {
		this.eventDetails = eventDetails;
	}


	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", startDate="
				+ startDate + ", endDate=" + endDate + ", maxPeople="
				+ maxPeople + ", tag=" + tag + ", content=" + content
				+ ", place=" + place + ", state=" + state + ", promoterID="
				+ promoterID + ", promoter=" + promoter + ", eventDetails="
				+ eventDetails + "]";
	}


	public Event(Integer id, String title, Timestamp startDate,
			Timestamp endDate, Integer maxPeople, String tag, String content,
			String place, Integer state, Integer promoterID, User promoter,
			List<EventDetail> eventDetails) {
		super();
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.maxPeople = maxPeople;
		this.tag = tag;
		this.content = content;
		this.place = place;
		this.state = state;
		this.promoterID = promoterID;
		this.promoter = promoter;
		this.eventDetails = eventDetails;
	}	
}


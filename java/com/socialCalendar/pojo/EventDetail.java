package com.socialCalendar.pojo;
/**
 * 活动详情实体类
 * @author NumberSevens
 *
 */
public class EventDetail {
	private Integer eventDetailID;//活动详情id;
	private Integer eventID;//活动id;
	private Integer participantID;//参与人id;
	private Integer isPromoter;//判断是否是发起人;

	
	private User participant;//参与人

	public Integer getEventDetailID() {
		return eventDetailID;
	}

	public void setEventDetailID(Integer eventDetailID) {
		this.eventDetailID = eventDetailID;
	}

	public Integer getEventID() {
		return eventID;
	}

	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}

	public Integer getParticipantID() {
		return participantID;
	}

	public void setParticipantID(Integer participantID) {
		this.participantID = participantID;
	}

	public Integer getIsPromoter() {
		return isPromoter;
	}

	public void setIsPromoter(Integer isPromoter) {
		this.isPromoter = isPromoter;
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}
	
	
	
}

package com.socialCalendar.dataModel;

import java.sql.Timestamp;
/**
 * 获取用户个人活动列表实体类
 * @author XD
 *
 */
public class Activity {
	private Integer activeId;
	private String activeTheme;
	private String startTime;
	private String endTime;
	public Integer getActiveId() {
		return activeId;
	}
	public void setActiveId(Integer activeId) {
		this.activeId = activeId;
	}
	public String getActiveTheme() {
		return activeTheme;
	}
	public void setActiveTheme(String activeTheme) {
		this.activeTheme = activeTheme;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Activity [activeId=" + activeId + ", activeTheme="
				+ activeTheme + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	

	
}

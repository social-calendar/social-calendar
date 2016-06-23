package com.social_calendar.service;

import java.util.List;
import java.util.Map;

import com.social_calendar.pojo.Event;
import com.social_calendar.pojo.EventDetail;

/**
 * EventService接口
 * 
 * @author NumberSevens
 * 
 */
public interface EventService {
	/**
	 * 活动查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Event> findDetailEvent(Map<String, Object> map);
	/**
	 * 修改活动
	 * 
	 * @param event
	 * @return影响的记录数
	 */
	public int updateEvent(Event event);

	/**
	 * 添加活动
	 * 
	 * @param event
	 * @return影响的记录数
	 */
	public int addEvent(Event event);

	/**
	 * 删除活动
	 * 
	 * @param id
	 * @return
	 */
	public int deleteEvent(Integer id);
	
	  /**
     * 加入活动
     * @param 
     * @return返回加入是否成功
     */
    public int joinEvent(EventDetail eventDetail );
    
    /**
     * 退出活动
     * @param 
     * @return返回退出是否成功
     */
    public int quitEvent(EventDetail eventDetail);
}

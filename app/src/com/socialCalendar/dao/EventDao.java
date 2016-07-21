package com.socialCalendar.dao;

import java.util.List;
import java.util.Map;

import com.socialCalendar.pojo.Event;
import com.socialCalendar.pojo.EventDetail;

public interface EventDao {
	 /**
     * 修改活动
     * @param event
     * @return影响的记录数
     */
    public int updateEvent(Event event);
    
    /**
     * 添加活动
     * @param event
     * @return影响的记录数
     */
    public int addEvent(Event event);
    
    /**
     * 删除活动
     * @param id
     * @return
     */
    public int deleteEvent(Integer id);
    
    /**
     * 活动详情查询
     * @param id 活动id
     * @return活动实体
     */
    public Event findDetailEvent(Integer id);
    
    /**
     * 活动列表查询
     * @param map
     * @return活动集合
     */
    public List<Event> findListEvent(Map<String, Object> map);
    
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
   
    /**
     * 活动列表查询
     * @param map
     * @return活动集合
     */
    public List<Event> findMgtListEvent(Map<String, Object> map);
    
}

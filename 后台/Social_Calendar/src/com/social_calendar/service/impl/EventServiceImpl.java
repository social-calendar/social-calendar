package com.social_calendar.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.social_calendar.dao.EventDao;
import com.social_calendar.pojo.Event;
import com.social_calendar.pojo.EventDetail;
import com.social_calendar.service.EventService;
/**
 * EventService实现类
 * @author NumberSevens
 *
 */
@Service("eventService")
public class EventServiceImpl implements EventService {
	@Resource
	private EventDao eventDao;
	
	@Override
	public List<Event> findDetailEvent(Map<String, Object> map) {
		return eventDao.findDetailEvent(map);
	}

	@Override
	public int updateEvent(Event event) {
		return eventDao.updateEvent(event);
	}

	@Override
	public int addEvent(Event event) {
		//创建人做为参与人参与活动
		int result = 0;
		result = eventDao.addEvent(event);		
		EventDetail eventDetail = new EventDetail();
		eventDetail.setEventID(event.getId());
		eventDetail.setParticipantID(event.getPromoterID());
		eventDetail.setIsPromoter(1);
		if(eventDao.joinEvent(eventDetail)>0)
			 result = 1;
		else result = 0;
		return result;
	}

	@Override
	public int deleteEvent(Integer id) {
		return eventDao.deleteEvent(id);
	}

	@Override
	public int joinEvent(EventDetail eventDetail) {
		return eventDao.joinEvent(eventDetail);
	}

	@Override
	public int quitEvent(EventDetail eventDetail) {
		return eventDao.quitEvent(eventDetail);
	}	
}

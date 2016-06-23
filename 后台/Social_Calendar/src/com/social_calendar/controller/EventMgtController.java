package com.social_calendar.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.social_calendar.pojo.Event;
import com.social_calendar.pojo.EventDetail;
import com.social_calendar.service.EventService;
import com.social_calendar.service.UserService;

@Controller
@RequestMapping("/event")
public class EventMgtController {
	@Resource
	private EventService eventService;
	private UserService userService;
	Map<String, Object> map;

	/**
	 * 1.获取用户个人活动列表
	 */
	@RequestMapping(value = "/listEvent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listEvent(@RequestBody Object user)
			throws Exception {
		JSONObject json = JSONObject.fromObject(user);
		map = new HashMap();
		int status = 2;
		map.put("participantID", json.getInt("nickname"));
		List<Event> eventList = eventService.findDetailEvent(map);
		map.clear();
		if (eventList.size() > 0)
			status = 1;
		map.put("status", status);
		map.put("eventList", eventList);
		return map;
	}

	/**
	 * 2.创建活动
	 */
	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addEvent(@RequestBody Object event)
			throws Exception {
		JSONObject json = JSONObject.fromObject(event);
		map = new HashMap();
		int status = 0, flag = 0;
		Event events = new Event();
		events.setTitle(json.getString("activeTheme"));
		events.setStartDate((Timestamp) json.get("startTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setPlace(json.getString("place"));
		events.setContent(json.getString("activeDetail"));
		events.setPromoterID(json.getInt("promoterID"));
		flag = eventService.addEvent(events);
		if (flag != 0)
			status = 1;
		map.put("activeId", events.getId());
		map.put("author", userService.findByUserIdUser(events.getId())
				.getNickname());
		map.put("status", status);
		return null;
	}

	/**
	 * 3.编辑活动
	 */
	@RequestMapping(value = "/editEvent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editEvent(@RequestBody Object event)
			throws Exception {
		JSONObject json = JSONObject.fromObject(event);
		map = new HashMap();
		int status = 0;
		Event events = new Event();
		events.setId(json.getInt("activeId"));
		events.setTitle(json.getString("activeTheme"));
		events.setStartDate((Timestamp) json.get("startTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setPlace(json.getString("place"));
		events.setContent(json.getString("activeDetail"));
		events.setPromoterID(json.getInt("promoterID"));
		status = eventService.updateEvent(events);
		map.put("status", status);
		return map;
	}

	/**
	 * 4.活动详情
	 */
	@RequestMapping(value = "/listEvent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> detailEvent(@RequestBody Object event)
			throws Exception {
		JSONObject json = JSONObject.fromObject(event);
		map = new HashMap();
		int status = 2;
		map.put("id", json.getInt("activeId"));
		List<Event> eventList = eventService.findDetailEvent(map);
		map.clear();
		if (eventList.size() > 0)
			status = 1;
		map.put("status", status);
		map.put("eventList", eventList);
		return map;
	}

	/**
	 * 5.获取某一活动下的评论
	 */
	@RequestMapping(value = "/getEventComment", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getEventComment(@RequestBody Object event)
			throws Exception {
		
		return null;
	}

	/**
	 * 6.发布评论
	 */
	@RequestMapping(value = "/addEventComment", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addEventComment(@RequestBody Object event)
			throws Exception {

		return null;
	}
}

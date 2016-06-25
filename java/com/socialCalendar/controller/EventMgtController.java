package com.socialCalendar.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socialCalendar.pojo.Comment;
import com.socialCalendar.pojo.Event;
import com.socialCalendar.service.CommentService;
import com.socialCalendar.service.EventService;
import com.socialCalendar.service.UserService;

@Controller
@RequestMapping("/event")
public class EventMgtController {
	@Resource
	private CommentService commentService;
	@Resource
	private EventService eventService;
	@Resource
	private UserService userService;
	/**
	 * 1.获取用户个人活动列表
	 */
	@RequestMapping(value = "/getEventList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listEvent(@RequestParam("user")String user)
			throws Exception {
		//JSONObject json = JSONObject.fromObject(user);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 2;
		map.put("participantID","1");
		List<Event> eventList = eventService.findDetailEvent(map);
		map.clear();
		if (eventList.size() > 0)
			status = 1;
		map.put("status", status);
		map.put("eventList", eventList);
		System.out.println(map);
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
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0, flag = 0;
		Event events = new Event();
		events.setTitle(json.getString("activeTheme"));
		events.setStartDate((Timestamp) json.get("startTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setPlace(json.getString("place"));
		events.setContent(json.getString("activeDetail"));
		events.setPromoterID(json.getInt("1"));
		flag = eventService.addEvent(events);
		if (flag != 0)
			status = 1;
		map.put("activeId", events.getId());
		map.put("author", userService.findByUserIdUser(events.getPromoterID())
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
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		Event events = new Event();
		events.setId(json.getInt("activeId"));
		events.setTitle(json.getString("activeTheme"));
		events.setStartDate((Timestamp) json.get("startTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setEndDate((Timestamp) json.get("endTime"));
		events.setPlace(json.getString("place"));
		events.setContent(json.getString("activeDetail"));
		events.setPromoterID(json.getInt("1"));
		status = eventService.updateEvent(events);
		map.put("status", status);
		return map;
	}

	/**
	 * 4.活动详情
	 */
	@RequestMapping(value = "/getEventDetail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> detailEvent(@RequestBody Object event)
			throws Exception {
		JSONObject json = JSONObject.fromObject(event);
		Map<String, Object> map = new HashMap<String, Object>();
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
	public Map<String, Object> getEventComment(@RequestParam("activeId")Integer activeId)
			throws Exception {	
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		List<Comment> comments  = commentService.findCommentByEventId(activeId);
		if(comments!=null)status = 1;
		else status = 2;
		map.put("status", status);
		map.put("comments", comments);		
		return map;
	}

	/**
	 * 6.发布评论
	 */
	@RequestMapping(value = "/addEventComment", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addEventComment(@RequestBody Object comment)
			throws Exception {
		JSONObject json = JSONObject.fromObject(comment);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		Comment comments = new Comment();
		comments.setCommentEventId(json.getInt("activeId"));
		comments.setCommentUserId(json.getInt("用户ID"));
		comments.setCommentTime(json.getString("time"));
		comments.setCommentContent(json.getString("content"));
		status = commentService.addComment(comments);
		map.put("status", status);		
		return map;
	}
}

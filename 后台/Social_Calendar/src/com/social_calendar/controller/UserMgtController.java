package com.social_calendar.controller;

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
import com.social_calendar.service.EventService;
import com.social_calendar.service.UserService;

@Controller
@RequestMapping("/user")
public class UserMgtController {
	@Resource
	private UserService userService;
	@Resource
	private EventService eventService;

	/*
	 * @RequestMapping("/addEvent")
	 * 
	 * @ResponseBody public Object addEvent(@RequestBody Object user)throws
	 * Exception{ System.out.println(user); JSONObject json =
	 * JSONObject.fromObject(user);//将java对象转换为json对象
	 * System.out.println("nickname："+json.get("nickname"));
	 * System.out.println("openID："+json.get("openID")); return user; }
	 */
	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listEvent(@RequestBody Object user)
			throws Exception {
		JSONObject json = JSONObject.fromObject(user);
		Map<String, Object> map = new HashMap();
		map.put("participantID",json.getInt("nickname"));
		List<Event> eventList = eventService.findDetailEvent(map);
		map.clear();
		map.put("status", "true");
		map.put("eventList", eventList);
		return map;
	}
}

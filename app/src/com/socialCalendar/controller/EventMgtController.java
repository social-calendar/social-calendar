package com.socialCalendar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;







import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.socialCalendar.pojo.Event;
import com.socialCalendar.service.EventService;
import com.socialCalendar.util.StringUtil;

@Controller
@RequestMapping("/manager")
public class EventMgtController{
	public static final int pagesize = 8;
	@Resource(name="eventService")
	private EventService eventService;
	
	@RequestMapping(value="/event/listEvent",method=RequestMethod.GET)
	public ModelAndView listEvent(String pagenum,Event event){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("views/listEvent");
	mv.addObject("sidebar","events");
	int num = 1;
	if(null!=pagenum){
		num = Integer.parseInt(pagenum);
	}
	Map<String,Object> map = new HashMap<String,Object>();
	map.put("start", (num-1)*pagesize);
	map.put("size", pagesize);
	map.put("overall", StringUtil.formatLike(event.getTitle()));
	List<Event> list = eventService.findListEvent(map);
	System.out.println(list);
	mv.addObject("eventList", list);
	mv.addObject("length", list.size());
	mv.addObject("pagenum", num);
	mv.addObject("event", event);
	return mv;
	}	
}

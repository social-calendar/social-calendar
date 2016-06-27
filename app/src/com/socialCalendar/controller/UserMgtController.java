package com.socialCalendar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.socialCalendar.pojo.User;
import com.socialCalendar.service.UserService;
import com.socialCalendar.util.StringUtil;

@Controller
@RequestMapping("/manager")
public class UserMgtController{
	public static final int pagesize = 8;
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/user/listUser",method=RequestMethod.GET)
	public ModelAndView listUser(String pagenum,User user){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("views/listUser");
	mv.addObject("sidebar","users");
	int num = 1;
	if(null!=pagenum){
		num = Integer.parseInt(pagenum);
	}
	Map<String,Object> map = new HashMap<String,Object>();
	map.put("start", (num-1)*pagesize);
	map.put("size", pagesize);
	map.put("nickname", StringUtil.formatLike(user.getNickname()));
	List<User> list = userService.findByNickNameUser(map);
	mv.addObject("userList", list);
	mv.addObject("length", list.size());
	mv.addObject("pagenum", num);
	mv.addObject("user", user);
	return mv;
	}	
}

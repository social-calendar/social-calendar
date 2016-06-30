package com.socialCalendar.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.socialCalendar.WeChat.pojo.Config;
import com.socialCalendar.WeChat.pojo.Token;
import com.socialCalendar.WeChat.pojo.Token;
import com.socialCalendar.WeChat.util.CommonUtil;
import com.socialCalendar.WeChat.util.DateUtil;
import com.socialCalendar.dataModel.Activity;
import com.socialCalendar.dataModel.CommentDetail;
import com.socialCalendar.pojo.Comment;
import com.socialCalendar.pojo.Event;
import com.socialCalendar.pojo.EventDetail;
import com.socialCalendar.pojo.User;
import com.socialCalendar.service.CommentService;
import com.socialCalendar.service.EventService;
import com.socialCalendar.service.UserService;
import com.socialCalendar.service.WeChatService;

@Controller
@RequestMapping("/java")
public class EventFrontController extends BaseController{
	@Resource(name="commentService")
	private CommentService commentService;
	@Resource(name="eventService")
	private EventService eventService;
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="weChatService")
	private WeChatService weChatService;
	
	/**
	 * 1.获取用户个人活动列表
	 */
	@RequestMapping(value = "/getActiveList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listEvent()
			throws Exception {
		HttpSession session = super.getRequest().getSession();
		System.out.println("获取用户个人活动列表。getActiveList请求！==========");
		User user = (User) session.getAttribute("user");
		System.out.println("getActivi:"+user);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Activity> activitys = new ArrayList<Activity>();
		int status = 2;	
		map.put("participantID",user.getId());
		List<Event> eventList = eventService.findListEvent(map);
		map.clear();
		if(eventList!=null){
			for(int i = 0;i<eventList.size();i++){
				Activity activity = new Activity();
				activity.setActiveId(eventList.get(i).getId());
				activity.setActiveTheme(eventList.get(i).getTitle());
				activity.setStartTime(DateUtil.timestampToStr(eventList.get(i).getStartDate()));
				activity.setEndTime(DateUtil.timestampToStr(eventList.get(i).getEndDate()));
				activitys.add(activity);
			}
			status = 1;
		}
		map.put("status", status);
		map.put("data", activitys);
		return map;
	}

	/**
	 * 2.创建活动
	 */
	@RequestMapping(value = "/newActive", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addEvent(@RequestBody Object event)
			throws Exception {
		HttpSession session = super.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getNickname()+"创建活动。newActive请求！==========");
		JSONObject json = JSONObject.fromObject(event);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0, flag = 0;
		Event events = new Event();	
		events.setTitle(json.getString("activeTheme"));
		events.setStartDate(DateUtil.strToTimestamp(json.getString("startTime")));
		events.setEndDate(DateUtil.strToTimestamp(json.getString("endTime")));
		events.setPlace(json.getString("place"));
		events.setContent(json.getString("activeDetail"));
		events.setAlarm(json.getInt("alarm"));
		events.setPromoterID(user.getId());
		System.out.println(events);
		flag = eventService.addEvent(events);
		if (flag != 0)
			status = 1;
		map.put("activeId", events.getId());
		System.out.println(events.getId());
		map.put("author", userService.findByUserIdUser(events.getPromoterID())
				.getNickname());
		map.put("status", status);
		return map;
	}

	/**
	 * 3.编辑活动
	 */
	@RequestMapping(value = "/editActive", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> editEvent(@RequestBody Object event)
			throws Exception {
		HttpSession session = super.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getNickname()+"编辑活动。editActive请求！==========");
		JSONObject json = JSONObject.fromObject(event);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		Event events = new Event();
		events.setId(json.getInt("activeId"));
		events.setTitle(json.getString("activeTheme"));
		events.setStartDate(DateUtil.strToTimestamp(json.getString("startTime")));
		events.setEndDate(DateUtil.strToTimestamp(json.getString("endTime")));
		events.setPlace(json.getString("place"));
		events.setContent(json.getString("activeDetail"));
		events.setAlarm(json.getInt("alarm"));
		events.setPromoterID(user.getId());
		status = eventService.updateEvent(events);
		map.put("activeId", json.getInt("activeId"));
		map.put("status", status);
		
		return map;
	}

	/**
	 * 4.活动详情
	 */
	@RequestMapping(value = "/getActiveDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> detailEvent(HttpServletRequest request)
			throws Exception {
		HttpSession session = super.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		String activeId =request.getParameter("activeId");
		System.out.println(request.getParameter("activeId"));
		System.out.println(user.getNickname()+"查看活动详情。getActiveDetail请求！==========");
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommentDetail> commentDetails = new ArrayList<CommentDetail>();
		List<String> avatarArrays = new ArrayList<String>();
		int status = 2;
		boolean isCreater = false;
		Event event = eventService.findDetailEvent(Integer.valueOf(activeId));
		List<Comment> comment = commentService.findCommentByEventId(Integer.valueOf(activeId));
		boolean hasJoined = false;
		//装载参与人头像
		if(event!=null){
			status = 1;	
			for(int i = 0;i<event.getEventDetails().size();i++){
				avatarArrays.add(event.getEventDetails().get(i).getParticipant().getHeadimgurl());
				if(user.getId()==event.getEventDetails().get(i).getParticipantID()){
					hasJoined = true;
				}
			}
			//装载评论数据
			if(comment!=null){
				for(int j = 0;j<comment.size();j++){
					//只要最新三条数据
					if(j<=2){
					CommentDetail commentDetail = new CommentDetail();
					commentDetail.setUserAvatar(comment.get(j).getCommentUser().getHeadimgurl());
					commentDetail.setUserName(comment.get(j).getCommentUser().getNickname());
					commentDetail.setContent(comment.get(j).getCommentContent());
					commentDetail.setTime(DateUtil.timestampToStr(comment.get(j).getCommentTime()));
					commentDetails.add(commentDetail);
					}
					else break;
				}
			}
			//分享接口返回数据
			String activiteUrl=request.getParameter("url");
			Config config = weChatService.getConfig(activiteUrl);
						
			if(event.getPromoterID()==user.getId())isCreater = true;
			//装载数据
			map.put("authorAvatar", userService.findByUserIdUser(event.getPromoterID())
					.getHeadimgurl());
			map.put("author", userService.findByUserIdUser(event.getPromoterID())
					.getNickname());
			map.put("activeTheme", event.getTitle());
			map.put("startTime", DateUtil.timestampToStr(event.getStartDate()));
			map.put("endTime", DateUtil.timestampToStr(event.getEndDate()));
			map.put("place", event.getPlace());
			map.put("alarm", event.getAlarm());
			map.put("activeDetail", event.getContent());
			map.put("activeId", event.getId());
			map.put("partInNum", event.getEventDetails().size());
			map.put("AvatarArray", avatarArrays);
			map.put("commentList", commentDetails);
			map.put("commentLength", comment.size());
			map.put("config", config);
			map.put("isCreater",isCreater);
			map.put("hasJoined",hasJoined);
			map.put("status", status);		
		}
		else map.put("status", status);
		System.out.println(map);
		return map;
	}

	/**
	 * 5.获取某一活动下的评论
	 */
	@RequestMapping(value = "/getComment", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getEventComment(@RequestParam("activeId")Integer activeId)
			throws Exception {
		HttpSession session = super.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("获取某一活动下的评论。getComment请求！==========");
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommentDetail> commentList = new ArrayList<CommentDetail>();
		int status = 0;
		List<Comment> comments  = commentService.findCommentByEventId(activeId);
		if(comments!=null){
			//全部的评论信息
			for(int j = 0;j<comments.size();j++){
				CommentDetail commentDetail = new CommentDetail();
				commentDetail.setUserAvatar(comments.get(j).getCommentUser().getHeadimgurl());
				commentDetail.setUserName(comments.get(j).getCommentUser().getNickname());
				commentDetail.setContent(comments.get(j).getCommentContent());
				commentDetail.setTime(DateUtil.timestampToStr(comments.get(j).getCommentTime()));
				commentList.add(commentDetail);
			}
			status = 1;	
		}
		else status = 2;
		map.put("status", status);
		map.put("commentList", commentList);		
		return map;
	}

	/**
	 * 6.发布评论
	 */
	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addEventComment(@RequestBody Object comment)
			throws Exception {
		HttpSession session = super.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getNickname()+"发布评论。saveComment请求！==========");
		JSONObject json = JSONObject.fromObject(comment);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		Comment comments = new Comment();
		comments.setCommentEventId(json.getInt("activeId"));
		comments.setCommentUserId(user.getId());
		System.out.println(json.getString("time"));
		comments.setCommentTime(DateUtil.strToTimestamp(json.getString("time")));
		comments.setCommentContent(json.getString("content"));
		status = commentService.addComment(comments);
		map.put("status", status);		
		return map;
	}
	/**
	 * 7.加入活动
	 */
	@RequestMapping(value = "/joinActive", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> joinActive(@RequestBody Object join)
			throws Exception {
		HttpSession session = super.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		JSONObject json = JSONObject.fromObject(join);
		System.out.println(user.getNickname()+"加入活动。joinActive请求！==========");
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		EventDetail eventDetail  = new EventDetail();
		eventDetail.setEventID(json.getInt("activeId"));
		eventDetail.setParticipantID(user.getId());
		eventDetail.setIsPromoter(0);
		status = eventService.joinEvent(eventDetail);
		map.put("status", status);		
		return map;
	}
}

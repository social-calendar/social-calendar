import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.socialCalendar.pojo.Event;
import com.socialCalendar.service.CommentService;
import com.socialCalendar.service.EventService;
import com.socialCalendar.service.UserService;
import com.socialCalendar.util.StringUtil;

public class Test1 {
	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(
				new String[] {"applicationContext.xml"});
		System.out.println(applicationContext);
	}

	@Test
	public void testFindUserById() throws Exception {

		EventService eventService = (EventService) applicationContext
				.getBean("eventService");
		UserService userService = (UserService) applicationContext
				.getBean("userService");

		System.out.println(eventService);
		// 活动查询条件集
		Map<String, Object> map = new HashMap();
		map.put("title", null);
		map.put("participantID", null);
		map.put("isPromoter", null);
		map.put("nickname", null);
		map.put("content", null);
		map.put("tag", null);
		map.put("endDate", null);
		map.put("startDate", null);
		map.put("maxPeople", null);
		map.put("state", null);
		
		List<Event> event = eventService.findListEvent(map);
		System.out.println(event);
		System.out.println(event.size());
		for (int i = 0; i < event.size(); i++) {
			System.out.println("第" + (i + 1) + "活动");
			System.out.println("活动标题：" + event.get(i).getTitle());
			System.out.println("活动内容：" + event.get(i).getContent());
			System.out.println("活动发起者："
					+ userService
							.findByUserIdUser(event.get(i).getPromoterID())
							.getNickname());
			System.out.print("活动参与者：");
			for (int j = 0; j < event.get(i).getEventDetails().size(); j++) {
				System.out.print(event.get(i).getEventDetails().get(j)
						.getParticipant().getNickname()
						+ "  ");
				System.out.println("评论:");
			}
			System.out.println();
		}
	}

	@Test
	public void testAdd() throws Exception {

		EventService eventService = (EventService) applicationContext
				.getBean("eventService");
		System.out.println(eventService);
		Event event = new Event();
		event.setTitle("周目露营");
		event.setStartDate(new Timestamp(6));
		event.setEndDate(new Timestamp(1));
		event.setMaxPeople(10);
		event.setTag("露营");
		event.setContent("周末去公园露营！");
		event.setPromoterID(1);
		System.out.println("插入前：" + event.getId());
		System.out.println("++++++++++++" + eventService.addEvent(event));
		System.out.println("插入后：" + event.getId());

	}
	/*
	 * @Test public void testUpdate() throws Exception {
	 * 
	 * EventService eventService = (EventService)
	 * applicationContext.getBean("eventService");
	 * System.out.println(eventService); Event event = new Event();
	 * event.setId(10); event.setTitle("周asd"); event.setState(9);
	 * event.setStartDate(new Timestamp(9)); event.setEndDate(new Timestamp(8));
	 * event.setMaxPeople(112); event.setTag("露营222");
	 * event.setContent("周末去公园露营222！");
	 * 
	 * System.out.println("++++++++++++"+eventService.updateEvent(event));
	 * 
	 * }
	 */
	/*
	 * @Test public void testUserFind() throws Exception { UserService
	 * userService = (UserService) applicationContext.getBean("userService");
	 * System.out.println(userService);
	 * System.out.println("++++++++++++"+userService.deleteUser(1));
	 * 
	 * }
	 */
	@Test
	public void testComment() throws Exception {
		CommentService commentService = (CommentService) applicationContext
				.getBean("commentService");
		System.out.println(commentService.findCommentByEventId(1));
	}
}

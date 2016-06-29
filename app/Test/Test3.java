
import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.socialCalendar.WeChat.pojo.Config;
import com.socialCalendar.service.WeChatService;

@Controller
public class Test3 {
	private ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(
				new String[] {"applicationContext.xml"});
		System.out.println(applicationContext);
	}

	@Test//获取JSJDK配置测试
	public void aa() {
		/*WeChatService weChatService = (WeChatService) applicationContext
				.getBean("weChatService");
		Config cofig = weChatService.getConfig();
		System.out.println("AppId:"+cofig.getAppId());
		System.out.println("NonceStr:"+cofig.getNonceStr());
		System.out.println("Timestamp:"+cofig.getTimestamp());
		System.out.println("Signature:"+cofig.getSignature());*/
		System.out.println("119f1b7c59c85393142534006fb8f8ba6cc7a7f3".equals("119f1b7c59c85393142534006fb8f8ba6cc7a7f3"));
	}
}

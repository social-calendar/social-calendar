package com.socialCalendar.controller;

import java.io.IOException;  
import java.io.PrintWriter;  
  




import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  




import org.apache.log4j.Logger;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
  




import com.socialCalendar.WeChat.pojo.WeChat;
import com.socialCalendar.WeChat.util.SignUtil;
import com.socialCalendar.service.WeChatService;
  
/** 
 * 微信核心 web 入口 
 *  
 * @author  
 * @see 用户微信接口的相关接入工作。 
 */  
@Controller  
@RequestMapping("/wechat/api")
public class WeChatMsgController{ 
	@Resource
	private WeChatService weChatService;
	
    private Logger log = Logger.getLogger(WeChatMsgController.class);  
  
    /** 
     * 校验信息是否是从微信服务器发过来的。 
     *  
     * @param weChat 
     * @param out 
     */  
    @RequestMapping(method = { RequestMethod.GET }, produces = "application/json;charset=UTF-8")  
    public void valid(WeChat weChat, PrintWriter out) {  
        String signature = weChat.getSignature(); // 微信加密签名  
        String timestamp = weChat.getTimestamp(); // 时间戳  
        String nonce = weChat.getNonce();// 随机数  
        String echostr = weChat.getEchostr();// 随机字符串  
        System.out.println(weChat.getSignature());
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        } else {  
            System.out.println("不是微信服务器发来的请求,请小心!");  
        }  
        out.flush();  
        out.close();  
    }  
    /** 
     * 微信消息的处理 
     *  
     * @param request 
     * @param out 
     * @throws IOException 
     */  
    @RequestMapping(method = { RequestMethod.POST }, produces = "application/xml;charset=UTF-8")  
    public void dispose(HttpServletRequest request, HttpServletResponse response)  
            throws IOException {  
        /* 消息的接收、处理、响应 */  
  
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        // 调用核心业务类接收消息、处理消息
        String respMessage = weChatService.processRequest(request);  
        log.info(respMessage);  
        // 响应消息  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
    }   
}  

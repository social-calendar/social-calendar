<%@ page language="java" import="java.util.*,com.socialCalendar.pojo.User" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <% 
  // 获取由OAuthServlet中传入的参数
  User user = (User)request.getAttribute("snsUserInfo"); 
  if(null != user) {
%>
<table width="100%" cellspacing="0" cellpadding="0">
  <tr><td width="20%">属性</td><td width="80%">值</td></tr>
  <tr><td>OpenID</td><td><%=user.getOpenID()%></td></tr>
  <tr><td>昵称</td><td><%=user.getNickname()%></td></tr>
  <tr><td>性别</td><td><%=user.getSex()%></td></tr>
  <tr><td>头像</td><td><%=user.getHeadimgurl()%></td></tr>
</table>
<%
  }
  else 
   out.print("用户不同意授权,未获取到用户信息！");
%>
  </body>
</html>

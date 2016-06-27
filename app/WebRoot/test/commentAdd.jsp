<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'activityAdd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<script type="text/javascript" src="/assets/js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="/assets/js/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
function addUser(){
	 //将json对象传成字符串
	 //var user = JSON.stringify({nickname: "张三", openID: "diaoge"});
	  $.ajax({
			type:"POST",
			url:"/SocialCalendar/java/saveComment.do?activeId=6",
			contentType:"application/json;charset=utf-8", //请求内容为json
			data:JSON.stringify({
				content: $("#content").prop("value"), 
				time: $("#time").prop("value")			
							
				}),
			success: function(data){
				 $("#results").append(JSON.stringify(data));
			},
			error: function(e){
                    alert("出错："+JSON.stringify(e));
                }
		});
  }
    </script>
<body>
	评论时间：        <input type="text" id="time"/><br/>
	内容：<input type="text" id="content"/><br/>
	<input type="submit" value="添加" onclick="addUser()"/><br/>	
	<div id="results">
			<table>
				<tr>
					<td>${user.nickname}</td>
					<td>${user.openID}</td>
				</tr>
			</table>
    </div>
    ${flag}
</body>
</html>

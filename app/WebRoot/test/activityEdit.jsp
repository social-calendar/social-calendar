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
			url:"/SocialCalendar/java/editActive.do",
			contentType:"application/json;charset=utf-8", //请求内容为json
			data:JSON.stringify({
			    activeId: $("#activeId").prop("value"),
				activeTheme: $("#activeTheme").prop("value"), 
				startTime: $("#startTime").prop("value"),				
				endTime: $("#endTime").prop("value"),				
				place: $("#place").prop("value"),				
				activeDetail: $("#activeDetail").prop("value"),
				alarm: $("#alarm").prop("value")					
							
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
	ID：        <input type="text" id="activeId"/><br/>
	主题：        <input type="text" id="activeTheme"/><br/>
	开始时间：<input type="text" id="startTime"/><br/>
	结束时间：<input type="text" id="endTime"/><br/>
	地点：        <input type="text" id="place"/><br/>
	活动详情：<input type="text" id="activeDetail"/><br/>
	提醒时间：<input type="text" id="alarm"/><br/>
	<input type="submit" value="修改" onclick="addUser()"/><br/>	
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

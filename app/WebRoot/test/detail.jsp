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
</head>
<script type="text/javascript" src="assets/js/jquery-2.0.3.js"></script>
<script type="text/javascript" src="assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript">


function addUser(){
	 //将json对象传成字符串
	 //var user = JSON.stringify({nickname: "张三", openID: "diaoge"});
	 var active =$("#activeId").prop("value");
	  $.ajax({
			type:"GET",
			url:"/SocialCalendar/java/getActiveDetail.do?activeId="+active,
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

	活动id(建议用1测试数据量齐全)：        <input type="text" id="activeId"/><br>
	<input type="submit" value="获取" onclick="addUser()"/><br/>	
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>用户信息</title>
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@include file="/views/common/css.jsp" %>
	</head>

	<body>
		<%@ include file="/views/common/navbar.jsp" %>
		<div class="main-container container-fluid">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>
			<%@ include file="/views/common/sidebar.jsp" %>
			<div class="main-content">
				 
				<div class="page-content">
					<div class="page-header position-relative">
						<h1>
							<small>
								<i class="icon-user"></i>
								用户信息
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form class="form-inline" method="get" action="<%=request.getContextPath() %>/manager/user/listUser.do">
								<input type="hidden" name="pagenum" value="${pagenum}">
								&nbsp;&nbsp;昵称：<input  type="text" am-form-group name="nickname" value="${user.nickname}"  class="input-medium search-query">&nbsp;&nbsp;&nbsp;&nbsp;
				<%-- 				<select name="classid">
									<option value="0">选择班级</option>
									<c:forEach items="${clsList}"  var="cls"  >
										<option <c:if test="${student.classid == cls.id}">selected="selected"</c:if> value="${cls.id}">${cls.name}</option>
									</c:forEach>
								</select>&nbsp;&nbsp; --%>
								<button  type="submit" class="am-btn  am-btn-primary am-btn-sm">
									搜索
									<i class="icon-search icon-on-right bigger-110"></i>
								</button>
							</form>
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th width="10%">用户编号</th>
										<th width="10%">头像</th>
										<th width="15%">用户昵称</th>
										
										<th width="12%">用户性别</th>
										<th	width="35%">OpenID</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${userList}"  var="user"  >
									<tr>
										<td><a href="#">${user.id}</a></td>
										<td><img class="our_img" src="${user.headimgurl}"/></td>
										<td>${user.nickname}</td>
										<c:if test="${user.sex == 1}">
											<td class="row text-center">男</td>			
										</c:if>
										<c:if test="${user.sex != 1}">
											<td class="row text-center">女</td>			
										</c:if>			
										<td>${user.openID}</td>
										<td >
											<button class="am-btn am-btn-primary am-btn-xs" onclick="location.href='/views/wechatMessage.jsp'" ><i class="icon-comment"></i>留言</button>
											<button class="am-btn am-btn-primary am-btn-xs" onclick="location.href='<%=request.getContextPath() %>/manager/user/detailUser?userid=${user.id}'"><i class="icon-file"></i>详情</button>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							
					 		<div class="dataTables_paginate paging_bootstrap pagination">
							  <button class="am-btn am-btn-primary am-btn-xs" onclick="location.href='<%=request.getContextPath() %>/manager/user/listUser.do?pagenum=${pagenum-1}'" <c:if test="${pagenum <= 1}">disabled="disabled"</c:if>    >&laquo;</button>
							  <button class="am-btn am-btn-primary am-btn-xs" disabled="disabled">第 ${pagenum} 页</button>
							  <button class="am-btn am-btn-primary am-btn-xs" onclick="location.href='<%=request.getContextPath() %>/manager/user/listUser.do?pagenum=${pagenum+1}'" <c:if test="${length < 8}">disabled="disabled"</c:if> >&raquo;</button>
					 		</div>
							 
							<!--PAGE CONTENT ENDS-->
					</div><!--/.span-->
				</div><!--/.row-fluid-->
			</div><!--/.page-content-->
		</div><!--/.main-content-->
	</div><!--/.main-container-->

		<%@include file="/views/common/js.jsp" %>
		
	</body>
</html>
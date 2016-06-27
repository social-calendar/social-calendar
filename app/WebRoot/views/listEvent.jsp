<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>活动信息</title>
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
								活动信息
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form class="form-inline" method="get" action="<%=request.getContextPath() %>/manager/event/listEvent.do">
								<input type="hidden" name="pagenum" value="${pagenum}">
								&nbsp;&nbsp;搜索：<input type="text" name="title" value="${event.title}"  class="input-medium search-query">&nbsp;&nbsp;&nbsp;&nbsp;
				 				<%-- <select name="participantID">
									<option value="0">活动发起人</option>
									<c:forEach items="${ulist}"  var="u"  >
										<option <c:if test="${event.eventDetails.participantID == ulist.id}">selected="selected"</c:if> value="${ulist.id}">${ulist.nickname}</option>
									</c:forEach>
								</select>&nbsp;&nbsp; --%>
								<button  type="submit" class="btn btn-purple btn-small">
									查找
									<i class="icon-search icon-on-right bigger-110"></i>
								</button>
							</form>
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th width="5%">活动编号</th>
										<th width="10%">活动标题</th>
										<th width="10%">开始时间</th>		
										<th width="10%">结束时间</th>
										<th width="10%">活动地点</th>
										<th width="10%">活动内容</th>
										<th	width="15%">发起人</th>
										<th	width="15%">参与人</th>
										
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${eventList}"  var="event"  >
									<tr>
										<td><a href="#">${event.id}</a></td>
										<td>${event.title}</td>
										<td>${event.startDate}</td>
										<td>${event.endDate}</td>
										<td>${event.place}</td>
										<td>${event.content}</td>
										<td>
										<c:forEach items="${event.eventDetails}"  var="user1"  >
											<c:if test="${user1.isPromoter==1}">
											${user1.participant.nickname}
											</c:if>
											
										</c:forEach>
										</td>			
										<td>
										<c:forEach items="${event.eventDetails}"  var="user2"  >
										${user2.participant.nickname}&nbsp;
										</c:forEach> 
										</td>
										
		
										<td >
											<button class="btn btn-mini btn-primary" onclick="location.href='<%=request.getContextPath() %>/manager/event/leavemessage?userid=${user.id}'" ><i class="icon-comment"></i>微信留言</button>
											<button class="btn btn-mini btn-primary" onclick="location.href='<%=request.getContextPath() %>/manager/event/detailEvent?userid=${user.id}'"><i class="icon-file"></i>详细信息</button>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							
					 		<div class="dataTables_paginate paging_bootstrap pagination">
							  <button class="btn btn-success btn-mini" onclick="location.href='<%=request.getContextPath() %>/manager/event/listEvent.do?pagenum=${pagenum-1}'" <c:if test="${pagenum <= 1}">disabled="disabled"</c:if>    >&laquo;</button>
							  <button class="btn btn-success btn-mini" disabled="disabled">第 ${pagenum} 页</button>
							  <button class="btn btn-success btn-mini" onclick="location.href='<%=request.getContextPath() %>/manager/event/listEvent.do?pagenum=${pagenum+1}'" <c:if test="${length < 4}">disabled="disabled"</c:if> >&raquo;</button>
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
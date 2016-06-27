<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>�û���Ϣ</title>
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
								�û���Ϣ
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form class="form-inline" method="get" action="<%=request.getContextPath() %>/manager/user/listUser.do">
								<input type="hidden" name="pagenum" value="${pagenum}">
								&nbsp;&nbsp;�ǳƣ�<input type="text" name="nickname" value="${user.nickname}"  class="input-medium search-query">&nbsp;&nbsp;&nbsp;&nbsp;
				<%-- 				<select name="classid">
									<option value="0">ѡ��༶</option>
									<c:forEach items="${clsList}"  var="cls"  >
										<option <c:if test="${student.classid == cls.id}">selected="selected"</c:if> value="${cls.id}">${cls.name}</option>
									</c:forEach>
								</select>&nbsp;&nbsp; --%>
								<button  type="submit" class="btn btn-purple btn-small">
									����
									<i class="icon-search icon-on-right bigger-110"></i>
								</button>
							</form>
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th width="15%">�û����</th>
										<th width="22%">ͷ��</th>
										<th width="15%">�û��ǳ�</th>
										
										<th width="8%">�û��Ա�</th>
										<th	width="15%">��עʱ��</th>
										<th>����</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${userList}"  var="user"  >
									<tr>
										<td><a href="#">${user.id}</a></td>
										<td>${user.headimgurl}</td>
										<td>${user.nickname}</td>
										<c:if test="${user.sex == 1}">
											<td>��</td>			
										</c:if>
										<c:if test="${user.sex == 0}">
											<td>Ů</td>			
										</c:if>			
										<td>${user.subscribeTime}</td>
										<td >
											<button class="btn btn-mini btn-primary" onclick="location.href='<%=request.getContextPath() %>/manager/user/leavemessage?userid=${user.id}'" ><i class="icon-comment"></i>΢������</button>
											<button class="btn btn-mini btn-primary" onclick="location.href='<%=request.getContextPath() %>/manager/user/detailUser?userid=${user.id}'"><i class="icon-file"></i>��ϸ��Ϣ</button>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							
					 		<div class="dataTables_paginate paging_bootstrap pagination">
							  <button class="btn btn-success btn-mini" onclick="location.href='<%=request.getContextPath() %>/manager/user/listUser.do?pagenum=${pagenum-1}'" <c:if test="${pagenum <= 1}">disabled="disabled"</c:if>    >&laquo;</button>
							  <button class="btn btn-success btn-mini" disabled="disabled">�� ${pagenum} ҳ</button>
							  <button class="btn btn-success btn-mini" onclick="location.href='<%=request.getContextPath() %>/manager/user/listUser.do?pagenum=${pagenum+1}'" <c:if test="${length < 8}">disabled="disabled"</c:if> >&raquo;</button>
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
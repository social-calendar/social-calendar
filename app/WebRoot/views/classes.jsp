<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>�༶��Ϣ</title>
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
								<i class="icon-list-alt"></i>
								�༶��Ϣ
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form class="form-inline" method="get" action="<%=request.getContextPath() %>/manager/classes">
								<input type="hidden" name="pagenum" value="${pagenum}">
								&nbsp;&nbsp;���ƣ�<input type="text" name="name" value="${classes.name}"  class="input-medium search-query">&nbsp;&nbsp;&nbsp;&nbsp;
								<button  type="submit" class="btn btn-purple btn-small">
									����
									<i class="icon-search icon-on-right bigger-110"></i>
								</button>
								<button  type="button" onclick="location.href='<%=request.getContextPath() %>/manager/addclassespage'" class="btn btn-purple btn-small">
									��Ӱ༶
									<i class="icon-plus-sign icon-on-right bigger-110"></i>
								</button>
							</form>
							
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th width="20%">�༶���</th>
										<th width="20%">�༶����</th>
										<th width="20%">ѧ������</th>
										<th width="20%">������</th>
										<th width="20%" >����</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${classesList}"  var="classes"  >
									<tr>
										<td>${classes.id}</td>
										<td>${classes.name}</td>
										<td>${classes.studentcount}</td>
										<td>${classes.headteacher}</td>
										<td >
											<button class="btn btn-mini btn-primary" onclick="location.href='<%=request.getContextPath() %>/manager/classesnewspage?classesid=${classes.id}'" ><i class=" icon-envelope"></i>&nbsp;������̬</button>
											<button class="btn btn-mini btn-primary" onclick="location.href='<%=request.getContextPath() %>/manager/managerstudentpage?classesid=${classes.id}'" ><i class="icon-user"></i>&nbsp;����ѧ��</button>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
					 		<div class="dataTables_paginate paging_bootstrap pagination">
							  <button class="btn btn-success btn-mini" onclick="location.href='<%=request.getContextPath() %>/manager/classes?pagenum=${pagenum-1}'" <c:if test="${pagenum <= 1}">disabled="disabled"</c:if>    >&laquo;</button>
							  <button class="btn btn-success btn-mini" disabled="disabled">�� ${pagenum} ҳ</button>
							  <button class="btn btn-success btn-mini" onclick="location.href='<%=request.getContextPath() %>/manager/classes?pagenum=${pagenum+1}'" <c:if test="${length < 10}">disabled="disabled"</c:if> >&raquo;</button>
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
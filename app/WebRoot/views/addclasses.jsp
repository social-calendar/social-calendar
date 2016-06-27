<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>��Ӱ༶</title>
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
								��Ӱ༶
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form action="addclasses" id="addclasses" class="form-horizontal" method="post">
								<div class="control-group">
									<label class="control-label" for="id">�༶���</label>
									<div class="controls">
										<input type="text" name="id" id="id" placeholder=�༶���>*
										<span class="help-inline"><c:if test="${param.notice==null}">�������꼶������Ϊ302</c:if>  <font color="red"><c:if test="${param.notice!=null}">${param.notice}</c:if></font></span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"  for="name">�༶����</label>
									<div class="controls">
										<input type="text" id="name" value="${param.name}" name="name" placeholder="�༶����">*
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"  for="headteacher">����������</label>
									<div class="controls">
										<input type="text" value="${param.headteacher}" name="headteacher" id="headteacher" placeholder="����������">*
									</div>
								</div>
									<div class="form-actions">
									<button class="btn btn-info" id="add" type="button">
										<i class="icon-ok bigger-110"></i>
										��Ӱ༶
									</button>
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-info" type="button" onclick="location.href='<%=request.getContextPath() %>/manager/classes'" >
										<i class="icon-arrow-left"></i>
										����
									</button>
								</div>
							</form>
							<!--PAGE CONTENT ENDS-->
					</div><!--/.span-->
				</div><!--/.row-fluid-->
			</div><!--/.page-content-->
		</div><!--/.main-content-->
	</div><!--/.main-container-->
	<%@include file="/views/common/js.jsp" %>
	<script type="text/javascript">
		$(function() {
			$('#add').on('click', function() {
				if($.trim($("#id").val())==''||isNaN($('#id').val())){
					alert('��������ȷ�İ༶��ţ�');
					return;
				}else if($.trim($("#name").val())==''){
					alert('������༶���ƣ�');
					return;
				}else if($.trim($("#headteacher").val())==''){
					alert('��������������ƣ�');
					return;
				}else{
					$("#addclasses").submit();
				}
			});
			
		});
		</script>
	</body>
</html>
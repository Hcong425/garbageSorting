<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="common.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'rightShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${path}css/rightShow.css">
<script type="text/javascript">
	$(function(){
		
		$('#pageSize').change(function(){
			var pageSize = $(this).val();
			window.location.href = "role_findAllByPage?pageBean.pageSize="+pageSize;
			
		})
		
	})
</script>
<style type="text/css">
.table>tbody>tr:hover {
	background-color: #0096880a;
}
tbody .panel-default .panel-heading{
	height: 35px;
}
tbody .panel-default .panel-body{
	padding-bottom: 0px;
}
tbody .panel-default i{
    margin-bottom: 15px;
}
</style>
</head>

<body class="container-fluid" style="padding: 0px">

	<div class="navTop">

		<h1 class="page-header">
			Management System <small>Welcome <s:property
					value="#session.manger.name" /></small>
		</h1>
		<s:debug></s:debug>
		<ol class="breadcrumb">
			<li><a href="${path}manger_toIndexPage">首页</a></li>
			<li>权限</li>
			<li class="active">角色管理</li>
		</ol>
	</div>
	<div class="main">


		<div class="panel panel-default">
			<div class="panel-heading" style="background-color: #009688">
				角色列表<a class="btn btn-info" id="add"
					href="${path}role_toEditPage"><i class="fa fa-plus">新增角色</i></a>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
						<colgroup>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col width="240px"></col>
						</colgroup>
						<tr>
							<th>角色ID</th>
							<th>角色名称</th>
							<th>所有权限</th>
							<th>拥有管理员</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.pageBean.list" var="role">
								<tr>
									<td style="vertical-align: middle; text-align: center;">${id }</td>
									<td style="vertical-align: middle; text-align: center;">${name }</td>
									<td><s:iterator value="#session.classes" var="classes">
											<s:set value="#classes.id" name="class"></s:set>
											<s:set value="false" name="have"></s:set>
											<s:iterator value="#role.rights" var="right">
												<s:if test="#class == #right.classes.id">
													<s:set value="true" name="have"></s:set>
												</s:if>

											</s:iterator>

											<s:if test="#have">

												<div class="panel panel-default">
													<div class="panel-heading"
														style="background-color: #009688">
														<h3 class="panel-title">${classes.name}</h3>
													</div>
													<div class="panel-body">

														<s:iterator value="#role.rights" var="right">
															<s:if test="#class == #right.classes.id">
																<i class="fa fa-check-circle" style="color: #009688">&nbsp;&nbsp;${name }&nbsp;&nbsp;&nbsp;&nbsp;</i>
															</s:if>

														</s:iterator>
													</div>
												</div>
											</s:if>
											<s:set value="false" name="have"></s:set>
										</s:iterator></td>
									<td style="vertical-align: middle; text-align: center;"><s:iterator
											value="#role.mangers">${name } ,</s:iterator></td>
									<td style="vertical-align: middle; text-align: center;"><div
											class="btn-group">
											<a class="btn btn-primary"
												href="${path}role_toEditPage?form.id=${id}"><i
												class="fa fa-edit"></i>&nbsp;&nbsp;编辑</a> <a
												class="btn btn-success prevent" href="#"><i
												class="fa fa-check-circle"></i>&nbsp;&nbsp;保存</a> <a
												class="btn btn-danger delete"
												href="${path}role_delete?form.id=${id}"><i
												class="fa fa-times-circle"></i>&nbsp;&nbsp;删除</a>
										</div></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>

			</div>
			<div class="panel-footer" style="background-color: #009688">
				<lable>每页记录数:</lable>
				<select class="form-control" id="pageSize">
					<option value="3" selected="selected">3</option>
					<option value="5">5</option>
					<option value="10">10</option>
				</select>
				<div>
					<ul class="pagination ">
						<s:if test="#session.pageBean.pageNum > 1">
							<li><a
								href="${path}role_findAllByPage?pageBean.pageNum=1&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>">&laquo;</a>
							</li>
							<li><a
								href="${path}role_findAllByPage?pageBean.pageNum=<s:property value='#session.pageBean.pageNum - 1'/>&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>"
								class="fa fa-angle-left"></a></li>
						</s:if>
						<s:else>
							<li><a class="prevent">&laquo;</a></li>
							<li><a class="fa fa-angle-left prevent"></a></li>
						</s:else>
						<s:iterator begin="1"
							end="#session.pageBean.totalPage < 6 ? #session.pageBean.totalPage : 5"
							status="i">

							<s:if test="#i.getIndex() + 1 == #session.pageBean.pageNum">
								<li class="active"><a class="prevent">${i.getIndex() + 1 }</a>
								</li>
							</s:if>
							<s:else>
								<li><a
									href="${path}role_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=${i.getIndex() + 1 }">${i.getIndex() + 1 }</a>
								</li>
							</s:else>
						</s:iterator>
						<s:if
								test="#session.pageBean.pageNum < #session.pageBean.totalPage">
								<li><a
									href="${path}role_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.pageNum + 1'/>"
									class="fa fa-angle-right"></a></li>
								<li><a
									href="${path}role_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.totalPage'/>">&raquo;</a></li>
							</s:if>
							<s:else>
								<li><a class="fa fa-angle-right prevent"></a></li>
								<li><a class="prevent">&raquo;</a></li>
							</s:else>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

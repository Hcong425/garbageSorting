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
<script type="text/javascript" src="${path}js/rightShow.js"></script>
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
			<li class="active">权限管理</li>
		</ol>
	</div>
	<div class="main">


		<div class="panel panel-default">
			<div class="panel-heading">
				权限列表<a class="btn btn-success" id="add"
					href="${path}right_toEditPage"><i class="fa fa-plus">新增权限</i></a>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-hover table-bordered">
						<thead>
						<colgroup>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col width="240px"></col>
						</colgroup>
						<tr>
							<th>权限ID</th>
							<th>权限名称</th>
							<th>匹配路径</th>
							<th>所属组别</th>
							<th>所属角色</th>
							<th>激活</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.pageBean.list">
								<tr>
									<td>${id }</td>
									<td>${name }</td>
									<td>${url }</td>
									<td>${classes.name }</td>
									<td><s:iterator value="roles">
												${name }&nbsp;&nbsp;&nbsp;
											</s:iterator></td>
									<td><s:if test="active == 1">是</s:if>
										<s:else>否</s:else></td>
									<td><div class="btn-group">
											<a class="btn btn-primary"
												href="${path}right_toEditPage?form.id=${id}"><i
												class="fa fa-edit"></i>&nbsp;&nbsp;编辑</a> <a
												class="btn btn-success prevent" href="#"><i
												class="fa fa-check-circle"></i>&nbsp;&nbsp;保存</a> <a
												class="btn btn-danger delete"
												href="${path}right_delete?form.id=${id}"><i
												class="fa fa-times-circle"></i>&nbsp;&nbsp;删除</a>
										</div></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>

			</div>
			<div class="panel-footer">
				<lable>每页记录数:</lable>
				<select class="form-control" id="pageSize">
					<option value="5">5</option>
					<option value="10" selected="selected">10</option>
					<option value="20">20</option>
					<option value="50">50</option>
				</select>
				<div>
					<ul class="pagination ">
						<s:if test="#session.pageBean.pageNum > 1">
							<li><a
								href="${path}right_findAllByPage?pageBean.pageNum=1&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>">&laquo;</a>
							</li>
							<li><a
								href="${path}right_findAllByPage?pageBean.pageNum=<s:property value='#session.pageBean.pageNum - 1'/>&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>"
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
									href="${path}right_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=${i.getIndex() + 1 }">${i.getIndex() + 1 }</a>
								</li>
							</s:else>
						</s:iterator>
						<s:if
								test="#session.pageBean.pageNum < #session.pageBean.totalPage">
								<li><a
									href="${path}right_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.pageNum + 1'/>"
									class="fa fa-angle-right"></a></li>
								<li><a
									href="${path}right_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.totalPage'/>">&raquo;</a></li>
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

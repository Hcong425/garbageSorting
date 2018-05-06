<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="common.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'rightDistribution.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${path}css/rightShow.css">
<script type="text/javascript" src="${path}js/rightDistribution.js"></script>
<style type="text/css">
.green {
	color: green;
}

.red {
	color: red;
}
.modal-header{
	padding: 10px;
}
#form{
	margin-bottom: 0px;
}
#form .panel-default .panel-heading{
	height: 34px;
}
#form .modal-body{
	padding-bottom: 0px;
}
</style>
</head>

<body class="container-fluid" style="padding: 0px">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">角色分配</h4>
				</div>
				<form action="role_setRole" method="post" class="form" id="form">
					<div class="modal-body">
						<input hidden="hidden" value="" id="mangerId" name="mangerId">
						<input hidden="hidden" value="" name="form.id" id="formId">
						<div class="form-group">
							<label>角色名称</label> <select class="form-control" id="role">
								<option value="0">请选择角色</option>
								<s:iterator value="#session.roles">
									<option value="${id }">${name }</option>
								</s:iterator>
							</select>
						</div>

						<s:iterator value="#session.classes">
							<div class="panel panel-default">
								<div class="panel-heading"
									style="background-color: #76c9cc;color: white">
									<h3 class="panel-title">${name}</h3>
								</div>
								<div class="panel-body">
									<s:iterator value="rights" var="right">
										<span id="${id }" class="rights"><i
											class="fa fa-ban red"></i>&nbsp;${name }&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</s:iterator>
								</div>
							</div>
						</s:iterator>
					</div>
					<div class="modal-footer">
						<div class="btn-group btn-group-justified  form-group"
							role="group">
							<div class="btn-group" role="group">
								<button type="submit" class="btn btn-success submit">确定</button>
							</div>
							<div class="btn-group" role="group">
								<button type="reset" class="btn btn-danger">重置</button>
							</div>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="navTop">

		<h1 class="page-header">
			Management System <small>Welcome <s:property
					value="#session.manger.name" /></small>
		</h1>
		<s:debug></s:debug>
		<ol class="breadcrumb">
			<li><a href="${path}manger_toIndexPage">首页</a></li>
			<li><a href="#">积分系统</a></li>
			<li class="active">积分更改记录</li>
		</ol>
	</div>
	<div class="main">


		<div class="panel panel-default">
			<div class="panel-heading">角色分配</div>
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
							<th>管理员ID</th>
							<th>管理员名称</th>
							<th>所属角色</th>
							<th>分配时间</th>
							<th>有效时间</th>
							<th>分配管理员</th>
							<th>操作</th>
						</tr>
						</thead>
							<s:iterator value="#session.pageBean.list">
								<tr>
									<td>${id }</td>
									<td>${name }</td>
									<td>${role.name }</td>
									<td>开始</td>
									<td>结束</td>
									<td>分配管理员</td>

									<td><div class="btn-group">
											<a class="btn btn-primary" data-toggle="modal"
												data-target="#myModal" id="distribution"><i
												class="fa fa-edit"></i>&nbsp;&nbsp;分配</a> <a
												class="btn btn-success prevent" href="#"><i
												class="fa fa-check-circle"></i>&nbsp;&nbsp;冻结</a> <a
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
							<li><a href="#" class="prevent">&laquo;</a></li>
							<li><a href="#" class="fa fa-angle-left prevent"></a></li>
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

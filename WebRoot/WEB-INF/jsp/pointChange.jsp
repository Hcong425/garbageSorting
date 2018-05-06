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

<title>My JSP 'PointChange.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">

</script>
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
			<li><a href="#">积分系统</a></li>
			<li class="active">积分更改记录</li>
		</ol>
	</div>
	<div class="row main">
		<s:debug></s:debug>
		<div class="col-md-6 col-sm-12 col-xs-12">

			<div class="panel panel-default">
				<div class="panel-heading">垃圾积分更改记录</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>垃圾ID</th>
									<th>垃圾名称</th>
									<th>时间</th>
									<th>更改前</th>
									<th>更改后</th>
									<th>操作管理员</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.pageBean.list">
									<tr>
										<td>${rubbish.id }</td>
										<td>${rubbish.name }</td>
										<td><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></td>
										<td>${beforePoint }</td>
										<td>${afterPoint }</td>
										<td>
											<s:if test="#manger.name == null">未知</s:if>
											<s:else>
												${manger.name }
											</s:else>
										</td>
									</tr>

								</s:iterator>

							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>

		<div class="col-md-6 col-sm-12 col-xs-12">

			<div class="panel panel-default">
				<div class="panel-heading">商品积分更改记录</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>商品ID</th>
									<th>商品名称</th>
									<th>时间</th>
									<th>更改前积分</th>
									<th>更改后积分</th>
									<th>操作管理员</th>
								</tr>
							</thead>
							<tbody>
							<s:iterator value="#session.pageBean.list">
								<tr>
									<td>${commodity.id }</td>
									<td>${commodity.name }</td>
									<td><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></td>
									<td>${beforePoint }</td>
									<td>${afterPoint }</td>
									<td>
										<s:if test="#manger.name == null">未知</s:if>
										<s:else>
											${manger.name }
										</s:else>
									</td>
								</tr>
							</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>

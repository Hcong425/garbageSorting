<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="common.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'RubbishAdd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${path }css/recyclePointAdd.css" />
<link rel="stylesheet" type="text/css"
	href="${path }css/recycleItemAdd.css" />
</head>

<body class="container-fluid" style="padding: 0px">
	<div class="navTop">

		<h1 class="page-header">
			Management System <small>Welcome <s:property
					value="#session.manger.name" /></small>
		</h1><s:debug></s:debug>
		<ol class="breadcrumb">
			<li><a href="${path}manger_toIndexPage">首页</a></li>
			<li><a href="${path}recyclePoint_findAllByPage">回收点</a></li>
			<li class="active">回收记录录入</li>
		</ol>
	</div>
	<div class="main">
			<div class="panel panel-default col-md-12">
				<div class="panel-heading">
					<h4 class="panel-title">
						<i class="fa fa-map-marker"></i>&nbsp;&nbsp;回收记录录入
					</h4>
				</div>

				<div id="collapseThree" class="panel-collapse collapse in">
					<div class="panel-body">
						<form action="rubbishItem_add" method="post" class="form">

							<div class="form-group">
								<label class="control-label">管理员</label> <input type="text"
									value="" name="form.manger" class="form-control"
									placeholder="请输入管理员" />
							</div>
							<div class="form-group">
								<label class="control-label">用户</label> <input type="text"
									value="" name="form.user" class="form-control"
									placeholder="请输入用户" />
							</div>

							<div class="form-group">
								<label class="control-label">回收点</label> <input type="text"
									value="" name="form.recyclePoint" class="form-control"
									placeholder="请输入回收点" />
							</div>
							<div class="panel panel-default details">
								<div class="panel-heading">垃圾详情</div>
								<table class="table">
									<thead>
									<colgroup>
										<col style="width: 10%"></col>
										<col style="width: 20%"></col>
										<col style="width: 40%"></col>
										<col style="width: 15%"></col>
										<col style="width: 15%"></col>
										<col></col>
									</colgroup>
									<tr>
										<th>垃圾ID</th>
										<th>图片</th>
										<th>垃圾名称</th>
										<th>重量</th>
										<th>积分</th>
									</tr>
									</thead>
									<tr>
										<td><input type="text" value="" name="form.rubbish"
											class="form-control" /></td>
										<td><input type="text" value="" class="form-control" /></td>
										<td><input type="text" value="" class="form-control" /></td>
										<td><input type="text" value="" name="form.rubbishWeight"
											class="form-control" /></td>
										<td><input type="text" value="" class="form-control" /></td>
									</tr>
								</table>
							</div>
							<div class="btn-group btn-group-justified  form-group"
								role="group">
								<div class="btn-group" role="group">
									<button type="submit" class="btn btn-success submit">提交</button>
								</div>
								<div class="btn-group" role="group">
									<a href="recyclePoint_findAllByPage?pageBean.pageNum=1&pageBean.pageSize=10" class="btn btn-info">取消</a>
								</div>
								<div class="btn-group" role="group">
									<button type="reset" class="btn btn-danger">重置</button>
								</div>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
		<s:debug></s:debug>
	</div>
</body>
</html>

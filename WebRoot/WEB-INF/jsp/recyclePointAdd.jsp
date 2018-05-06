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

<title>My JSP 'recyclePointAdd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="${path}js/recyclePointAdd.js"></script>
<link rel="stylesheet" type="text/css"
	href="${path}css/recyclePointAdd.css">
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
			<li><a href="${path}recyclePoint_findAllByPage">回收点</a></li>
			<s:if test="#request.checkRecyclePoint != null">
				<li class="active">编辑回收点</li>
			</s:if>
			<s:else>
				<li class="active">添加回收点</li>
			</s:else>
		</ol>
	</div>
	<div class="main">
		<div class="panel panel-default col-md-12">
			<div class="panel-heading" style="padding: 0px;">
				<ul class="nav nav-tabs nav-justified">
					<li role="presentation" class="active"><a id="addComm"><i
							class="fa fa-map-marker"></i>&nbsp;&nbsp;新增回收点</a></li>
					<li role="presentation"><a id="addCate">新增覆盖小区</a></li>
				</ul>
			</div>

			<div class="panel-body" id="recyclePointForm">
				<form action="recyclePoint_saveOrUpdate" method="post" class="form">
					<input hidden="hidden"
						value="${requestScope.checkRecyclePoint.id }" name="form.id">
					<div class="form-group has-feedback">
						<label class="control-label">回收点名称</label> <input type="text"
							name="form.pointName" class="form-control" placeholder="请输入回收点名称"
							value="${requestScope.checkRecyclePoint.name}">
							<span class="form-control-feedback"><span class="text"></span></span></span>
					</div>
					<div data-toggle="distpicker" id="cityselect">

						<div class="form-group">
							<label for="province">省</label> <select class="form-control"
								id="province1">
								<s:iterator value="#request.parAddress" status="i">
									<s:if test="#request.checkRecyclePoint.cell.address.parAddress.parAddress.id == id">
										<option value="${id }" selected="selected">${name }</option>
									</s:if>
									<s:else>
										<option value="${id }">${name }</option>
									</s:else>
								</s:iterator>
							</select>
						</div>
						<div class="form-group">
							<label for="city1">市</label> <select class="form-control" id="city1" value="<s:property value='#request.checkRecyclePoint.cell.address.parAddress.id'/>">
							</select>
						</div>
						<div class="form-group">
							<label for="district1">区/县</label> <select class="form-control" id="district1" value="<s:property value='#request.checkRecyclePoint.cell.address.id'/>">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="cell">小区</label>
						<select class="form-control" name="form.cell" id="cell" value="<s:property value='#request.checkRecyclePoint.cell.id'/>">
						</select>
					</div>
					
					<div class="form-group has-feedback">
						<label class="control-label">机器编号</label>
						<input type="text" class="form-control" placeholder="请输入机器编号" name="form.robotNum">
						<span class="form-control-feedback"><span class="text"></span></span></span>
					</div>

					<div class="form-group">
						<label>是否激活回收点</label>
						<s:if test="#request.checkRecyclePoint.active == 1">
							<input name="form.active" type="checkbox" data-size="small" checked="checked" 
								value="true">
						</s:if>
						<s:else>
							<input name="form.active" type="checkbox" data-size="small" value="">
						</s:else>
					</div>

					<div class="form-group">
						<label>是否监控回收点</label> <input name="form.monitor" type="checkbox"
							data-size="small">
					</div>

					<div class="btn-group btn-group-justified  form-group" role="group">
						<div class="btn-group" role="group">
							<button type="submit" class="btn btn-success submit">提交</button>
						</div>
						<div class="btn-group" role="group">
							<a class="btn btn-info" href="recyclePoint_findAllByPage">取消</a>
						</div>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-danger">重置</button>
						</div>
					</div>

				</form>

			</div>

			<div class="panel-body hidden" id="cellForm">
				<form action="cell_saveOrUpdate" method="post" class="form">
					<!-- 					<input hidden="hidden" value=""
						name="id"> -->
					<div class="form-group has-feedback">
						<label class="control-label">小区名称</label> <input type="text"
							name="cell.name" class="form-control" placeholder="请输入小区名称">
							<span class="form-control-feedback"><span class="text"></span></span></span>
					</div>

					<div data-toggle="distpicker" id="cityselect">

						<div class="form-group">
							<label for="province">省</label> <select class="form-control"
								id="province2">
								<s:iterator value="#request.parAddress" status="i">
									<s:if test="#i.getIndex() == 0">
										<option value="${id }" selected="selected">${name }</option>
									</s:if>
									<s:else>
										<option value="${id }">${name }</option>
									</s:else>
								</s:iterator>
							</select>
						</div>
						<div class="form-group">
							<label for="city">市</label> <select class="form-control"
								id="city2">
							</select>
						</div>
						<div class="form-group">
							<label for="district">区/县</label> <select class="form-control"
								name="addressId" id="district2">
							</select>
						</div>
					</div>

					<div class="form-group has-feedback">
						<label class="control-label">经度</label> <input type="text" class="form-control"
							name="cell.longitude" placeholder="请输入经度"">
							<span class="form-control-feedback"><span class="text"></span></span></span>
					</div>
					<div class="form-group has-feedback">
						<label class="control-label">纬度</label> <input type="text" class="form-control"
							name="cell.latitude" placeholder="请输入纬度"">
							<span class="form-control-feedback"><span class="text"></span></span></span>
					</div>

					<div class="btn-group btn-group-justified  form-group" role="group">
						<div class="btn-group" role="group">
							<button type="submit" class="btn btn-success submit">提交</button>
						</div>
						<div class="btn-group" role="group">
							<a class="btn btn-info" href="commodity_findAllByPage">取消</a>
						</div>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-danger">重置</button>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>
</body>
</html>

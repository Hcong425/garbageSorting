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

<title>My JSP 'rightAdd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${path }css/recyclePointAdd.css">
<link rel="stylesheet" type="text/css" href="${path }css/rightAdd.css">
<script type="text/javascript" src="${path }js/rightAdd.js"></script>

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
			<li class="active">权限</a></li>
			<li class="active">新增权限</li>
		</ol>
	</div>
	<div class="main">

		<div class="panel panel-default col-md-12">
			<div class="panel-heading">
				<h4 class="panel-title">
					<i class="fa fa-map-marker"></i>&nbsp;&nbsp;新增权限
				</h4>
			</div>

			<div id="collapseThree" class="panel-collapse collapse in">
				<div class="panel-body">
					<form action="right_saveOrUpdate" method="post" class="form">
						<input hidden="hidden" value="${sessionScope.checkRight.id }"
							name="form.id">
						<div class="form-group has-feedback">
							<label class="control-label">权限名称</label> <input type="text"
								value="${sessionScope.checkRight.name }" name="form.name"
								class="form-control" placeholder="请输入权限名称" />
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>

						<div class="form-group has-feedback">
							<label class="control-label">匹配url</label> <input type="text"
								value="${sessionScope.checkRight.url }" name="form.url"
								class="form-control" placeholder="请输入匹配url" />
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>

						<div class="form-group">
							<label>所属类别</label> <select class="form-control"
								name="form.classes">
								<s:iterator value="#session.classes">
									<s:if test="id == #session.checkRight.classes.id">
										<option value="${id }" selected="selected">${name }</option>
									</s:if>
									<s:else>
										<option value="${id }">${name }</option>
									</s:else>
								</s:iterator>
							</select>
						</div>

						<div class="form-group">
							<label>是否激活此权限</label> <input name="form.active" type="checkbox"
								data-size="small">
						</div>


						<div class="btn-group btn-group-justified  form-group"
							role="group">
							<div class="btn-group" role="group">
								<button type="submit" class="btn btn-success submit">提交</button>
							</div>
							<div class="btn-group" role="group">
								<a type="button" class="btn btn-info" href="right_findAllByPage">取消</a>
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
	</div>
</body>
</html>

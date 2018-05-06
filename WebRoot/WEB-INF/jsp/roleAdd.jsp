<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<link rel="stylesheet" type="text/css" href="${path}css/build.css">
<link rel="stylesheet" type="text/css" href="${path}css/roleAdd.css">
<script type="text/javascript" src="${path }js/roleAdd.js"></script>
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

		<div class="panel-group">
			<div class="panel panel-default col-md-12">
				<div class="panel-heading" style="background-color: #47b9b2ab">
					<h4 class="panel-title">
						<i class="fa fa-map-marker"></i>&nbsp;&nbsp;新增角色
					</h4>
				</div>

				<div class="panel-body">
					<form action="role_saveOrUpdate" method="post" class="form">
						<input hidden="hidden" value="${sessionScope.checkRole.id }"
							name="form.id">
						<div class="form-group has-feedback">
							<label>角色名称</label> <input type="text"
								value="${sessionScope.checkRole.name }" name="form.name"
								class="form-control" placeholder="请输入角色名称" />
							<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>

						<s:iterator value="#session.classes">
							<div class="panel panel-default">
								<div class="panel-heading"
									style="background-color: #79ce92;color: white;padding: 7px 15px;">
									<h3 class="panel-title">${name}</h3>
								</div>
								<div class="panel-body">
									<s:iterator value="rights" var="right">
										<div class="checkbox-inline checkbox">
											<s:iterator value="#session.checkRole.rights"
												var="checkright">
												<s:if test="#checkright.id == #right.id">
													<s:set value="true" name="flag"></s:set>
												</s:if>

											</s:iterator>
											<s:if test="#flag">
												<div class="checkbox checkbox-success checkbox-circle">
													<input id="checkbox${id }" class="styled" type="checkbox"
														value="${id }" name="form.rights" checked="checked">
													<label for="checkbox${id }"> ${name } </label>
												</div>
											</s:if>
											<s:else>

												<div class="checkbox checkbox-success checkbox-circle">
													<input id="checkbox${id }" class="styled" type="checkbox"
														value="${id }" name="form.rights"> <label
														for="checkbox${id }"> ${name } </label>
												</div>
											</s:else>
										</div>
										<s:set value="false" name="flag"></s:set>
									</s:iterator>
								</div>
							</div>
						</s:iterator>

						<div class="btn-group btn-group-justified  form-group"
							role="group">
							<div class="btn-group" role="group">
								<button type="submit" class="btn btn-success submit">提交</button>
							</div>
							<div class="btn-group" role="group">
								<a type="button" class="btn btn-info" href="role_findAllByPage">取消</a>
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
</body>
</html>

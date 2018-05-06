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
<link rel="stylesheet" type="text/css"
	href="${path }css/recyclePointAdd.css">
<link rel="stylesheet" type="text/css"
	href="${path }css/commodityAdd.css">
<script type="text/javascript" src="${path }js/commodityAdd.js"></script>
</head>
<body class="container-fluid" style="padding: 0px">
	<div class="navTop">

		<h1 class="page-header">
			Management System <small>Welcome <s:property
					value="#session.currentManger.name" /></small>
		</h1>
		<s:debug></s:debug>
		<ol class="breadcrumb">
			<li><a href="${path}manger_toIndexPage">首页</a></li>
			<li><a href="${path}recyclePoint_findAllByPage">积分系统</a></li>
			<s:if test="#session.checkRecyclePoint != null">
				<li class="active">新增商品</li>
			</s:if>
			<s:else>
				<li class="active">修改商品</li>
			</s:else>
		</ol>
	</div>
	<div class="main">
		<div class="panel panel-default col-md-12">
			<div class="panel-heading">
				<ul class="nav nav-tabs nav-justified">
					<li role="presentation" class="active"><a id="addComm">新增商品</a></li>
					<li role="presentation"><a id="addCate">新增类别</a></li>
				</ul>
			</div>

				<div class="panel-body" id="commForm">
					<form action="commodity_saveOrUpdate" method="post" class="form" enctype="multipart/form-data">
						<input hidden="hidden" value="${requestScope.checkCommodity.id }" name="form.id">
						<div class="form-group has-feedback">
							<label class="control-label">商品名称</label> <input type="text"
								name="form.name" class="form-control" placeholder="请输入商品名称"
								value="${requestScope.checkCommodity.name }">
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>
				
						<div class="form-group has-feedback" style="float: left;">
							<label class="control-label">图片</label> <input type="file" value="${requestScope.checkCommodity.image }" name="upload" class="form-control" style="width: auto; padding-right: 300px;">
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>
						<div id="preview"></div>
						
						<div data-toggle="distpicker" id="cityselect">

							<div class="form-group" >
								<label class="control-label">所属类别</label> <select class="form-control" id="parent"
									name="parCategoryId">
									<s:iterator value="#request.topCategory">
										<s:if test="#request.checkCommodity.category.parentCategory.id == id">
											<option value="${id }" selected="selected">${name }</option>
										</s:if>
										<s:else>
											<option value="${id }">${name }</option>
										</s:else>
									</s:iterator>
								</select>
							</div>
							
							<div class="form-group" >
								<select class="form-control" id="children" childrenId="${requestScope.checkCommodity.category.id}"
									name="form.categoryId">
								</select>
							</div>
							
						</div>

						<div class="form-group has-feedback">
							<label class="control-label">描述</label>
							<textarea type="text" class="form-control" name="form.descr"
								placeholder="请输入描述信息">${requestScope.checkCommodity.descr }</textarea>
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>

						<div class="form-group has-feedback">
						<label class="control-label">兑换积分</label>
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-registration-mark"></span></span> <input type="text" class="form-control"
								name="form.point" placeholder="请输入可兑换积分" value="${requestScope.checkCommodity.point }">
								<span class="form-control-feedback"   style=" width: auto;right: 55px;top: 4px;"><span class="text"></span></span></span>
								<span class="input-group-addon">/件</span></div>
								
						</div>

						<div class="form-group has-feedback">
							<label class="control-label">库存</label> <input type="text" class="form-control"
								name="form.repertory" placeholder="请输入库存" value="${requestScope.checkCommodity.repertory }">
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>

						<div class="btn-group btn-group-justified  form-group"
							role="group">
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

				<div class="panel-body hidden" id="cateForm">
					<form action="category_saveOrUpdate" method="post" class="form">
						<input type="hidden" value="" name="categoryForm.id">
						<div class="form-group has-feedback">
							<label class="control-label">类别名称</label> <input type="text"
								name="categoryForm.name" class="form-control" placeholder="请输入类别名称"
								value="">
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>

						<div class="form-group">
							<label>是否为父类</label> <input type="checkbox" data-size="small" name="categoryForm.isPar">
							
						</div>

						<div class="form-group" id="parCategory">
							<label>所属类别</label> <select class="form-control" id="parCate"
								name="categoryForm.parCategoryId">
								<s:iterator value="#request.topCategory">
									<option value="${id }">${name }</option>
								</s:iterator>
							</select>
						</div>

						<div class="btn-group btn-group-justified  form-group"
							role="group">
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
		</div>
	</div>
</body>
</html>


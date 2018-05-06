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
	href="${path }css/recyclePointAdd.css">
<link rel="stylesheet" type="text/css"
	href="${path }css/rubbishAdd.css">
<script type="text/javascript" src="${path }js/rubbishAdd.js"></script>
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
			<li><a href="${path}rubbish_findAllChildByPage">垃圾分类</a></li>
			<li class="active">新增分类</li>
		</ol>
	</div>
	<div class="main">

		<div class="panel panel-default col-md-12">
			<div class="panel-heading">
				<h4 class="panel-title">
					<i class="fa fa-map-marker"></i>&nbsp;&nbsp;新增垃圾分类
				</h4>
			</div>

			<div id="collapseThree" class="panel-collapse collapse in">
				<div class="panel-body">
					<form action="rubbish_saveOrUpdate" method="post" class="form"
						enctype="multipart/form-data">

						<div class="form-group">
							<label>所属类别</label> <select class="form-control"
								name="form.parRubbishId">
								<s:iterator value="#request.parRubbish">
									<s:if test="#request.checkRubbish != null">
										<s:if test="#request.checkRubbish.parRubbish.id == id">
											<option value="${id }" selected="selected">${name }</option>
										</s:if>
										<s:else>
											<option value="${id }">${name }</option>
										</s:else>
									</s:if>
									<s:else>
										<option value="${id }">${name }</option>
									</s:else>

								</s:iterator>
							</select>
						</div>

						<div class="form-group has-feedback">
							<label class="control-label">垃圾名称</label> <input type="text"
								value="${checkRubbish.name}" name="form.name"
								class="form-control" placeholder="请输入垃圾名称" />
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>

						<div class="form-group has-feedback">
							<label class="control-label">描述</label>
							<s:if test="#request.checkRubbish.descr != null">
								<textarea class="form-control" name="form.descr">${checkRubbish.descr}</textarea>
								<span class="form-control-feedback"><span class="text"></span></span></span>
							</s:if>
							<s:else>
								<textarea class="form-control" name="form.descr"
									placeholder="请输入垃圾描述信息"></textarea>
									<span class="form-control-feedback"><span class="text"></span></span></span>
							</s:else>
						</div>

						<div class="form-group has-feedback" style="float: left;">
							<label class="control-label">图片</label> <input type="file" value="${checkRubbish.image }" name="upload" class="form-control" style="width: auto; padding-right: 300px;">
								<span class="form-control-feedback"><span class="text"></span></span></span>
						</div>
						<div id="preview"></div>

						<div class="form-group has-feedback">
						<label class="control-label">兑换积分</label>
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-registration-mark"></span></span> <input placeholder="请输入可兑换积分" 
								type="text" class="form-control" name="form.point"
								value="${checkRubbish.point }"> 
								<span class="form-control-feedback"   style=" width: auto;right: 55px;top: 4px;"><span class="text"></span></span></span>
								<span class="input-group-addon">/kg</span></div>
								
						</div>

						<div class="form-group">
							<label>是否激活此分类</label>
							<s:if test="#checkRubbish.active == 1">
								<input name="form.active" type="checkbox" value="true"
									data-size="small">
							</s:if>
							<s:else>
								<input name="form.active" type="checkbox" data-size="small">
							</s:else>
						</div>


						<div class="form-group">
							<label>是否监控此分类</label> <input name="form.monitor" type="checkbox"
								data-size="small">
						</div>

						<div class="btn-group btn-group-justified  form-group"
							role="group">
							<div class="btn-group" role="group">
								<button type="submit" class="btn btn-success submit">提交</button>
							</div>
							<div class="btn-group" role="group">
								<a href="rubbish_findAllChildByPage" class="btn btn-info">取消</a>
							</div>
							<div class="btn-group" role="group">
								<button type="reset" class="btn btn-danger">重置</button>
							</div>
						</div>
						<input type="hidden" name="form.id" value="${requestScope.checkRubbish.id }"></input>

					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>

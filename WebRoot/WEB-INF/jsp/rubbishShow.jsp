
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="common.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'RubbishShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="${path }js/rubbishShow.js"></script>
<link rel="stylesheet" type="text/css" href="${path}css/rubbishShow.css">
<link rel="stylesheet" type="text/css" href="${path}css/build.css">

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
			<li class="active">查看分类</li>
		</ol>
	</div>
	<div class="row main">
		<div class="serach row">
			<div class="col-md-2">

				<select class="form-control" id="classify">
					<s:if test="#request.parRubbish != null">
						<option value="">全部</option>
					</s:if>
					<s:else>
						<option selected="selected">全部</option>
					</s:else>
					<s:iterator value="#request.parRubbish">
						<s:if test="#session.parRubbishId != null">
							<s:if test="#session.parRubbishId == id">
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
			<div class="input-group col-md-2">
				<form action="rubbish_search" method="post">
					<input hidden="hidden" value="${requestScope.condition }"
						id="previous"> <span class="input-group-btn"> <input
						type="text" class="form-control" placeholder="Search for..."
						id="text" name="form.condition" value="${requestScope.condition }">
						<button class="btn btn-default " type="submit" id="go">Go!</button>
					</span>
				</form>
			</div>
		</div>
		<s:if test="#request.pageBean.list.size == 0">
			<h3 class="info">没有符合您的查找记录</h3>
		</s:if>
		<s:else>
			<s:iterator value="#request.pageBean.list" status="i" var="rubbish">
				<s:if test="parRubbish != null">
					<s:if test="parRubbish.id == 648">
						<s:set name="color" value="'green'" scope="page"></s:set>
					</s:if>
					<s:elseif test="parRubbish.id == 649">
						<s:set name="color" value="'orange'" scope="page"></s:set>
					</s:elseif>
					<s:elseif test="parRubbish.id == 650">
						<s:set name="color" value="'red'" scope="page"></s:set>
					</s:elseif>
					<s:else>
						<s:set name="color" value="'blue'" scope="page"></s:set>
					</s:else>
					<div class="panel panel-default col-md-3"">
						<div class="panel-heading ${color}">
							<a class="delete" href="${path }rubbish_delete?form.id=${id}"><i
								class="glyphicon glyphicon-remove"></i></a>
							<h3 class="panel-title">${rubbish.parRubbish.name }</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-6 col-md-12 rubbishInfo">
									<div class="thumbnail">
										<img src="${path }rubbishImg/${image }" alt="..."
											class="img-circle">
									</div>
									<h3>
										${name } <span class="badge">${point } p</span>
									</h3>
								</div>
								<p>${descr }</p>
							</div>
						</div>
						<div class="panel-footer ${color}">
							<span>编辑<i class="fa fa-arrow-circle-right"></i></span></a>
						</div>
					</div>
				</s:if>
			</s:iterator>
			<nav class="col-md-12">
				<ul class="pager">
					<s:if test="#request.pageBean.pageNum != 1">
						<li class="previous"><a
							href="rubbish_findAllChildByPage?pageBean.pageNum=<s:property value="#request.pageBean.pageNum-1"/>&form.parRubbishId=<s:property value="#request.parRubbishId"/>">上一页</a></li>
					</s:if>
					<s:else>
						<li class="previous active"><a class="prevent"> 上一页</a></li>
					</s:else>
					<s:if
						test="#request.pageBean.pageNum != #request.pageBean.totalPage">
						<li class="next"><a
							href="rubbish_findAllChildByPage?pageBean.pageNum=<s:property value="#request.pageBean.pageNum+1"/>&form.parRubbishId=<s:property value="#request.parRubbishId"/>"><span>下一页
							</a></li>
					</s:if>
					<s:else>
						<li class="next active"><a class="prevent">下一页</a></li>
					</s:else>
				</ul>
			</nav>
		</s:else>
	</div>
</body>
</html>

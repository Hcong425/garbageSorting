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

<title>My JSP 'mangerShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${path}css/recyclePointShow.css" rel="stylesheet">
<style type="text/css">
.panel-default>.panel-heading, .panel-footer{
    background-color: #5bc0de;
}
.table>tbody>tr:hover {  
    background-color: #ddeef3;  
}
</style>
<script type="text/javascript" src="${path}js/userShow.js"></script>
</head>

<body class="container-fluid" style="padding: 0px">
	<div class="navTop">

		<h1 class="page-header">
			Management System <small>Welcome <s:property
					value="#session.manger.name" /></small>
		</h1><s:debug></s:debug>
		<ol class="breadcrumb">
			<li><a href="${path}manger_toIndexPage">首页</a></li>
			<li><a href="${path}user_findAllByPage">用户管理</a></li>
			<li class="active">查看用户</li>
		</ol>
	</div>
	<div class="main">
			<div class="panel panel-default col-md-12">
				<div class="panel-heading">
					<h4 class="panel-title">
						<i class="fa fa-map-marker"></i>&nbsp;&nbsp;用户管理
					</h4>
				</div>

				<div id="collapseThree" class="panel-collapse collapse in">
					<div class="panel-body">
						<table class="table table-striped table-hover table-bordered">
							<thead>
							<tbody>
								<colgroup>
									<col></col>
									<col></col>
									<col></col>
									<col></col>
									<col></col>
									<col></col>
									<col></col>
									<col></col>
									<col width="290px"></col>
									<col width="198px"></col>
								</colgroup>
								<tr>
									<th style="text-align: center"><i
										class="glyphicon glyphicon-sort"></i>&nbsp;&nbsp;序号</th>
									<th><i class="fa fa-key"></i>&nbsp;&nbsp;id<i
										class="fa fa-sort right"></i></th>
									<th><i class="fa fa-thumb-tack"></i>&nbsp;&nbsp;用户名</th>
									<th><i class="fa fa-id-card"></i>&nbsp;&nbsp;地址</th>
									<th><i class="fa fa-id-card"></i>&nbsp;&nbsp;注册时间</th>
									<th><i class="fa fa-anchor"></i>&nbsp;&nbsp;电话<i
										class="fa fa-sort right"></i></th>
									<th><i class="fa fa-info-circle"></i>&nbsp;&nbsp;邮箱</th>
									<th><i class="fa fa-info-circle"></i>&nbsp;&nbsp;积分</th>
									<th><i class="fa fa-info-circle"></i>&nbsp;&nbsp;查看兑换记录</th>
									<th><span class="glyphicon glyphicon-asterisk"></span>&nbsp;&nbsp;操作</th>
								</tr>
							</thead>
							<tbody>

								<s:iterator value="#session.pageBean.list" status="i">
									<tr>
										<td style="text-align: center">${(pageBean.pageNum == 0 ? 0 : (pageBean.pageNum-1)) * pageBean.pageSize + i.getIndex() +1}</td>
										<td>${id }</td>
										<td>${name }</td>
										<td>${address }</td>
										<td><s:date format="yyyy-MM-dd" name="time" /></td>
										<td>${telphone }</td>
										<td>${eamil }</td>
										<td>${point }</td>
										<td><a class="btn btn-info"
											href="${path}rubbishItem_findByPageUserId?userId=${id}"><i
												class="fa fa-recycle"></i>&nbsp;&nbsp;查看回收记录</a> <a
											class="btn btn-info"
											href="${path}convert_findByPageUserId?userId=${id}"><i
												class="fa fa-shopping-bag"></i>&nbsp;&nbsp;查看兑换记录</a>
										</td>
										<td><div class="btn-group">
												<a class="btn btn-success prevent"
													href=""><i
													class="fa fa-edit"></i>&nbsp;&nbsp;详情</a> <a
													class="btn btn-danger delete"
													href="${path}user_delete?id=${id}"><i
													class="fa fa-times-circle"></i>&nbsp;&nbsp;删除</a>
											</div></td>
									</tr>
								</s:iterator>

							</tbody>
						</table>

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
										href="${path}user_findAllByPage?pageBean.pageNum=1&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>">&laquo;</a>
									</li>
									<li><a
										href="${path}user_findAllByPage?pageBean.pageNum=<s:property value='#session.pageBean.pageNum - 1'/>&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>"
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
												href="${path}user_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=${i.getIndex() + 1 }">${i.getIndex() + 1 }</a>
											</li>
										</s:else>
								</s:iterator>
								<s:if
									test="#session.pageBean.pageNum < #session.pageBean.totalPage">
									<li><a
										href="${path}user_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.pageNum + 1'/>"
										class="fa fa-angle-right"></a></li>
									<li><a
										href="${path}user_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.totalPage'/>">&raquo;</a></li>
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
		</div>
	</div>
</body>
</html>

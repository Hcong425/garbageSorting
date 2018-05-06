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

<title>My JSP 'recycleItemShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${path}css/recyclePointShow.css" rel="stylesheet">
<style type="text/css">
.panel-default>.panel-heading, .panel-footer {
	background-color: #5bc0de;
}

.table>tbody>tr:hover {
	background-color: #ddeef3;
}
.info{
    text-align: center;
    font-size: x-large;
    margin: 150px;
    color: #9d9d9d;
}
.download-block .btn-download {
    margin: 0px 5px 0px;
    font-weight: 700;
    padding: 15px 55px;
    color: #fff;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    background: #999;
    border-radius: 2px;
}
</style>
<script type="text/javascript" src="${path}js/rubbishItemShow.js"></script>
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
			<li><a href="${path}user_findAllByPage">用户管理</a></li>
			<li class="active">查看兑换记录</li>
		</ol>
	</div>
	<div class="main">

		<s:if test="#request.pageBean.list == null">
			<h3 class="info">目前没有兑换记录</h3>
			<div class="download-block text-center">
			<a href="commodity_findAllByPage" class="btn-download">返回</a>
			</div>
		</s:if>
		<s:else>
			<div class="panel panel-default">
				<div class="panel-heading">兑换记录</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
							<colgroup>
								<col></col>
								<col></col>
								<col></col>
								<col></col>
								<col width="600px"></col>
								<col></col>
								<col></col>
								<col width="198px"></col>
							</colgroup>
							<tr>
								<th>兑换项编号</th>
								<th>用户ID</th>
								<th>用户名称</th>
								<th>时间</th>
								<th>商品</th>
								<th>总件数</th>
								<th>总计积分</th>
								<th>操作</th>
							</tr>
							</thead>
							<tbody>
								<s:iterator value="#request.pageBean.list">
									<tr>
										<td>${id }</td>
										<td>${user.id }</td>
										<td>${user.name }</td>
										<td><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></td>
										<td><s:iterator value="convertItems" status="i">
												<s:if test="commodity.id == #request.foundCommodtiy.id">
													<s:if test="#i.isLast()">
														<font color="red">${commodity.name }</font><span
																class="badge">${quantity}个</span>
													</s:if>
													<s:else>
														<font color="red">${commodity.name }</font><span
																class="badge">${quantity}个</span>&nbsp;
													</s:else>
												</s:if>
												<s:else>
													<s:if test="#i.isLast()">
		                                   	${commodity.name }<span
																class="badge">${quantity}个</span>
										</s:if>
													<s:else>
											${commodity.name }<span
																class="badge">${quantity}个</span>&nbsp;
										</s:else>
												</s:else>
											</s:iterator></td>
										<td>${amount }件</td>
										<td>${point }</td>
										<td><div class="btn-group">
												<a class="btn btn-primary"
													href="${path}right_toEditPage?form.id=${id}"><i
													class="fa fa-edit"></i>&nbsp;&nbsp;详情</a> <a
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
				<input type="hidden" value="${requestScope.user.id}" id="hidden">
				<div class="panel-footer">
					<lable>每页记录数:</lable>
					<select class="form-control" id="pageSize">
						<option value="5">5</option>
						<option value="10" selected="selected">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
					</select>
					<div>
						<s:if test="#request.user != null">
							<ul class="pagination ">
								<s:if test="#request.pageBean.pageNum > 1">
									<li><a
										href="${path}convert_findByPageUserId?userId=${user.id}&pageBean.pageNum=1&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>">&laquo;</a>
									</li>
									<li><a
										href="${path}convert_findByPageUserId?userId=${user.id}&pageBean.pageNum=<s:property value='#request.pageBean.pageNum - 1'/>&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>"
										class="fa fa-angle-left"></a></li>
								</s:if>
								<s:else>
									<li><a class="prevent">&laquo;</a></li>
									<li><a class="fa fa-angle-left prevent"></a></li>
								</s:else>
								<s:iterator begin="1"
									end="#request.pageBean.totalPage < 6 ? #request.pageBean.totalPage : 5"
									status="i">

									<s:if test="#i.getIndex() + 1 == #request.pageBean.pageNum">
										<li class="active"><a class="prevent">${i.getIndex() + 1 }</a>
										</li>
									</s:if>
									<s:else>
										<li><a
											href="${path}convert_findByPageUserId?userId=${user.id}&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=${i.getIndex() + 1 }">${i.getIndex() + 1 }</a>
										</li>
									</s:else>

								</s:iterator>
								<s:if
									test="#request.pageBean.pageNum < #request.pageBean.totalPage">
									<li><a
										href="${path}convert_findByPageUserId?userId=${user.id}&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#request.pageBean.pageNum + 1'/>"
										class="fa fa-angle-right"></a></li>
									<li><a
										href="${path}convert_findByPageUserId?userId=${user.id}&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#request.pageBean.totalPage'/>">&raquo;</a></li>
								</s:if>
								<s:else>
									<li><a class="fa fa-angle-right prevent"></a></li>
									<li><a class="prevent">&raquo;</a></li>
								</s:else>
							</ul>

						</s:if>
						<s:else>
							<ul class="pagination ">
								<s:if test="#request.pageBean.pageNum > 1">
									<li><a
										href="${path}recycleItem_findAllByPage?pageBean.pageNum=1&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>">&laquo;</a></li>
									<li><a
										href="${path}recycleItem_findAllByPage?pageBean.pageNum=<s:property value='#request.pageBean.pageNum - 1'/>&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>"
										class="fa fa-angle-left"></a></li>
								</s:if>
								<s:else>
									<li><a class="prevent">&laquo;</a></li>
									<li><a class="fa fa-angle-left prevent"></a></li>
								</s:else>
								<s:iterator begin="1"
									end="#request.pageBean.totalPage < 6 ? #request.pageBean.totalPage : 5"
									status="i">

									<s:if test="#i.getIndex() + 1 == #request.pageBean.pageNum">
										<li class="active"><a class="prevent">${i.getIndex() + 1 }</a>
										</li>
									</s:if>
									<s:else>
										<li><a
											href="${path}recycleItem_findAllByPage?pageBean.pageSize=<s:property
									value='#request.pageBean.pageSize' />&pageBean.pageNum=${i.getIndex() + 1 }">${i.getIndex() + 1 }</a>
										</li>
									</s:else>

								</s:iterator>
								<s:if
									test="#request.pageBean.pageNum < #request.pageBean.totalPage">
									<li><a
										href="${path}recycleItem_findAllByPage?pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#request.pageBean.pageNum + 1'/>"
										class="fa fa-angle-right"></a></li>
									<li><a
										href="${path}recycleItem_findAllByPage?pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#request.pageBean.totalPage'/>">&raquo;</a></li>
								</s:if>
								<s:else>
									<li><a class="fa fa-angle-right prevent"></a></li>
									<li><a class="prevent">&raquo;</a></li>
								</s:else>
							</ul>
						</s:else>

					</div>
				</div>
			</div>
		</s:else>
	</div>

</body>
</html>
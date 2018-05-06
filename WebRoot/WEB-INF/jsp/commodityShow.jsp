<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="common.jsp"></jsp:include>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'rightShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${path}css/rightShow.css">
<script type="text/javascript" src="${path}js/commodityShow.js"></script>
<style type="text/css">
.thumbnail {
	margin-bottom: 0px;
	padding: 0px;
}

td {
	vertical-align: middle;
}

.panel-default>.panel-heading, .panel-footer {
	background-color: #c0bc70d4;
}

.table>tbody>tr:hover {
	background-color: #c0bc7030;
}
</style>
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
			<li class="active">积分系统</li>
			<li class="active">商品管理</li>
		</ol>
	</div>
	<div class="main">


		<div class="panel panel-default">
			<div class="panel-heading">商品列表<a
						class="btn btn-success" id="add" style="display:initial"
						href="${path}commodity_toEditPage"><i
						class="fa fa-plus">新增商品</i></a></div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table">
						<thead>
						<colgroup>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
							<col width="300px"></col>
						</colgroup>
						<tr>
							<th>图片</th>
							<th>商品ID</th>
							<th>名称</th>
							<th>类别</th>
							<th>录入时间</th>
							<th>积分</th>
							<th>销量</th>
							<th>库存</th>
							<th>操作</th>
						</tr>

						</thead>
						<tbody>
							<s:iterator value="#session.pageBean.list">
								<tr>
									<td style="width:100px"><a href="#" class="thumbnail">
											<img alt="" src="${path}commodityImg/${img}" width="70px">
									</a></td>
									<td style="vertical-align: middle;">${id }</td>
									<td style="vertical-align: middle;">${name }</td>
									<td style="vertical-align: middle;">${category.parentCategory.name}
										${category.name }</td>
									<td style="vertical-align: middle;"><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></td>
									<td style="vertical-align: middle;">${point}</td>
									<td style="vertical-align: middle;">${sales}</td>
									<td style="vertical-align: middle;">${repertory}</td>
									<td style="vertical-align: middle;"><div class="btn-group">

											<a class="btn btn-primary"
												href="${path}commodity_toEditPage?form.id=${id}"><i
												class="fa fa-edit"></i>&nbsp;&nbsp;编辑</a><a
										class="btn btn-info"
										href="${path}convert_findByPageCommodityId?commodityId=${id}"><i
											class="fa fa-recycle"></i>&nbsp;&nbsp;兑换记录</a><a
												class="btn btn-danger delete"
												href="${path}commodity_delete?form.id=${id}"><i
												class="fa fa-times-circle"></i>&nbsp;&nbsp;删除</a>
										</div></td>
								</tr>


							</s:iterator>
						</tbody>
					</table>
				</div>

			</div>
			<div class="panel-footer">
				<lable>每页记录数:</lable>
				<select class="form-control" id="pageSize">
					<option value="5" selected="selected">5</option>
					<option value="10">10</option>
					<option value="20">20</option>
				</select>
				<div>
					<ul class="pagination ">
						<s:if test="#session.pageBean.pageNum > 1">
							<li><a
								href="${path}commodity_findAllByPage?pageBean.pageNum=1&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>">&laquo;</a>
							</li>
							<li><a
								href="${path}commodity_findAllByPage?pageBean.pageNum=<s:property value='#session.pageBean.pageNum - 1'/>&pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>"
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
									href="${path}commodity_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=${i.getIndex() + 1 }">${i.getIndex() + 1 }</a>
								</li>
							</s:else>

						</s:iterator>
						<s:if
							test="#session.pageBean.pageNum < #session.pageBean.totalPage">
							<li><a
								href="${path}commodity_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.pageNum + 1'/>"
								class="fa fa-angle-right"></a></li>
							<li><a
								href="${path}commodity_findAllByPage?pageBean.pageSize=<s:property value='#session.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#session.pageBean.totalPage'/>">&raquo;</a></li>
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
</body>
</html>

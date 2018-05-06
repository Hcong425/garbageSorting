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

<title>My JSP 'recycleShow.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${path}css/recyclePointShow.css" rel="stylesheet">
<script type="text/javascript" src="${path}js/recyclePoint.js"></script>
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
			<li class="active">查看回收点</li>
		</ol>
	</div>
	<div class="main">

		<div class="panel panel-default col-md-12">
			<div class="panel-heading">

				<h4 class="panel-title">
					<i class="fa fa-map-marker"></i>&nbsp;&nbsp;回收点 <a
						class="btn btn-success" id="add"
						href="${path}recyclePoint_toEditPage"><i
						class="fa fa-plus">新增回收点</i></a>
				</h4>

			</div>

				<div class="panel-body">
					<table class="table table-striped table-hover">
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
							<col width="280px"></col>
						</colgroup>
						<tr>
							<th style="text-align: center"><i
								class="glyphicon glyphicon-sort"></i>&nbsp;&nbsp;序号</th>
							<th><i class="fa fa-key"></i>&nbsp;&nbsp;id<i
								class="fa fa-sort right"></i></th>
								<th><i class="fa fa-id-card"></i>&nbsp;&nbsp;名称</th>
							<th><i class="fa fa-thumb-tack"></i>&nbsp;&nbsp;地址</th>
							<th><i class="fa fa-thumb-tack"></i>&nbsp;&nbsp;单位/小区</th>
							<th><i class="fa fa-id-card"></i>&nbsp;&nbsp;录入时间</th>
							<th><i class="fa fa-anchor"></i>&nbsp;&nbsp;回收总量 kg<i
								class="fa fa-sort right"></i></th>
							<th><i class="fa fa-info-circle"></i>&nbsp;&nbsp;激活</th>
							<th><span class="glyphicon glyphicon-asterisk"></span>&nbsp;&nbsp;操作</th>
						</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.pageBean.list" status="i">
								<tr>
									<td style="text-align: center">${(requestScope.pageBean.pageNum == 0 ? 0 : (pageBean.pageNum-1)) * pageBean.pageSize + i.getIndex() +1}</td>
									<td><span>${id }</span></td>
									<td><span>${name }</span></td>
									<td><span><s:if test="cell.address.parAddress != null">

												<s:if test="cell.address.parAddress.parAddress != null">
		                                            				${cell.address.parAddress.parAddress.name }-
		                                            				${cell.address.parAddress.name }-
		                                            			</s:if>
												<s:else>
		                                            				${cell.address.parAddress.name }-
		                                            			</s:else>

											</s:if> ${cell.address.name}<span></td>
									<td><span>${cell.name }</span></td>
									<td><s:date name="time" format="yyyy-MM-dd" /></td>
									<td><span>${requestScope.pointWeight[id] }<span></td>
									<td><span><s:if test="active == 1">是</s:if> <s:else>否</s:else><span></td>
									<td><div class="btn-group">
											<a class="btn btn-primary"
												href="${path}recyclePoint_toEditPage?form.id=${id}"><i
												class="fa fa-edit"></i>&nbsp;&nbsp;编辑</a> <a
												class="btn btn-danger delete"
												href="${path}recyclePoint_delete?form.id=${id}"><i
												class="fa fa-times-circle"></i>&nbsp;&nbsp;删除</a>
												<a
												class="btn btn-success" href="recyclePoint_toMapPage?cellId=${cell.id }"><i
												class="fa fa-map-marker"></i>&nbsp;&nbsp;预览</a> 
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
							<s:if test="#request.pageBean.pageNum > 1">
								<li><a
									href="${path}recyclePoint_findAllByPage?pageBean.pageNum=1&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>">&laquo;</a>
								</li>
								<li><a
									href="${path}recyclePoint_findAllByPage?pageBean.pageNum=<s:property value='#request.pageBean.pageNum - 1'/>&pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>"
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
										href="${path}recyclePoint_findAllByPage?pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=${i.getIndex() + 1 }">${i.getIndex() + 1 }</a>
									</li>
								</s:else>

							</s:iterator>
							<s:if
								test="#request.pageBean.pageNum < #request.pageBean.totalPage">
								<li><a
									href="${path}recyclePoint_findAllByPage?pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#request.pageBean.pageNum + 1'/>"
									class="fa fa-angle-right"></a></li>
								<li><a
									href="${path}recyclePoint_findAllByPage?pageBean.pageSize=<s:property value='#request.pageBean.pageSize'/>&pageBean.pageNum=<s:property value='#request.pageBean.totalPage'/>">&raquo;</a></li>
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

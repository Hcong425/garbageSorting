<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="common.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${path}css/index.css" rel="stylesheet">
<script type="text/javascript" src="${path}js/index.js" />
</head>

<body>
	<div class="navTop">

		<h1 class="page-header">
			Management System <small>Welcome <s:property
					value="#session.currentManger.name" /></small>
		</h1>
		<ol class="breadcrumb">
			<li class="active"><i class="fa fa-home fa-1x"></i>首页</li>
		</ol>
	</div>

	<div class="main">
		<div class="row column" style="display: block;">
			<div class="col-lg-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-6">
								<i class="fa fa-recycle fa-5x"></i>
							</div>
							<div class="col-md-1 col-offest-2">
								<i class="fa fa-long-arrow-up fa-3x"></i>
							</div>
							<div class="col-md-4 text-right">

								<h3 id="todayWeight">${requestScope.todayWeight}&nbsp;&nbsp;kg</h3>
								<h4>今日回收</h4>
							</div>
						</div>
					</div>
					<a href="#">
						<div class="panel-footer announcement-bottom"
							style="background-color: #d9edf742;">
							<div class="row">
								<div class="col-xs-6">View Mentions</div>
								<div class="col-xs-6 text-right">
									<i class="fa fa-arrow-circle-right"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-6">
								<i class="fa fa-shopping-bag fa-5x"></i>
							</div>
							<div class="col-md-1 col-offest-2">
								<i class="fa fa-long-arrow-down fa-3x"></i>
							</div>
							<div class="col-md-4 text-right">
								<h3 id="todayAmount">${requestScope.todayAmount }&nbsp;&nbsp;个</h3>
								<h4>今日兑换</h4>
							</div>
						</div>
					</div>
					<a href="#">
						<div class="panel-footer announcement-bottom"
							style="background-color: #fcf8e33d;">
							<div class="row">
								<div class="col-xs-6">Complete Tasks</div>
								<div class="col-xs-6 text-right">
									<i class="fa fa-arrow-circle-right"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-6">
								<i class="fa fa-map-marker fa-5x"></i>
							</div>
							<div class="col-md-1 col-offest-2">
								<i class="fa fa-long-arrow-down fa-3x"></i>
							</div>
							<div class="col-md-4 text-right">
								<h3 id="totalPoint">${requestScope.totalPoint}&nbsp;&nbsp;个</h3>
								<h4>回收点</h4>
							</div>
						</div>
					</div>
					<a href="#">
						<div class="panel-footer announcement-bottom"
							style="background-color: #f2dede6e;">
							<div class="row">
								<div class="col-xs-6">Fix Issues</div>
								<div class="col-xs-6 text-right">
									<i class="fa fa-arrow-circle-right"></i>
								</div>
							</div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-6">
								<i class="fa fa-users fa-5x"></i>
							</div>
							<div class="col-md-1 col-offest-2">
								<i class="fa fa-long-arrow-up fa-3x"></i>
							</div>
							<div class="col-md-4 text-right">
								<h3>${requestScope.totalNumber}&nbsp;&nbsp;人</h3>
								<h4 class="announcement-text">注册用户</h4>
							</div>
						</div>
					</div>
					<div class="panel-footer announcement-bottom"
						style="background-color: #dff0d875;">
						<div class="row">
							<div class="col-xs-6">Complete Orders</div>
							<div class="col-xs-6 text-right">
								<i class="fa fa-arrow-circle-right"></i>
							</div>
						</div>
					</div>
					</a>
				</div>
			</div>


			<div class="col-md-6">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-7">
								<i class="fa fa-trash fa-5x"></i>
							</div>
							<div class="col-md-1">
								<i class="fa fa-long-arrow-up fa-3x"></i>
							</div>
							<div class="col-md-3 text-right">
								<h3 id="totalWeight">${requestScope.totalWeight}&nbsp;&nbsp;kg</h3>
								<h4 class="announcement-text">总垃圾回收量</h4>
							</div>
							<div class="col-md-1">
								<i class="fa fa-repeat"></i>
							</div>
						</div>
					</div>
					<div class="panel-footer announcement-bottom"
						style="background-color: #d9edf742;">
						<div id="rubbish" style="min-width:300px; height:250px;"></div>
					</div>
				</div>
			</div>



			<div class="col-md-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-7">
								<i class="fa fa-tag fa-5x"></i>
							</div>
							<div class="col-md-1">
								<i class="fa fa-long-arrow-up fa-3x"></i>
							</div>
							<div class="col-md-3 text-right">
								<h3 id="totalAmount">${requestScope.totalAmount}&nbsp;&nbsp;件</h3>
								<h4 class="announcement-text">总商品兑换数</h4>
							</div>
							<div class="col-md-1">
								<i class="fa fa-repeat"></i>
							</div>
						</div>
					</div>
					<div class="panel-footer announcement-bottom"
						style="background-color: #dff0d875;">
						<div id="commodity" style="min-width:300px;height:250px"></div>
					</div>
				</div>
			</div>

			<div class="col-md-7 chart">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="row">
							<span style="font-size:16px"></span>
							<div style="float: right;">
								<i class="fa fa-repeat"></i>
							</div>
							<div class="btn-group btn-group-xs " role="group"
								style="float: right;">
								<button type="button" id="plain" class="btn btn-info"
									style="font-size: 15px;">普通</button>
								<button type="button" id="inverted" class="btn btn-info"
									style="font-size: 15px;">反转</button>
								<button type="button" id="polar" class="btn btn-info"
									style="font-size: 15px;">极地图</button>
							</div>

						</div>
					</div>
					<div class="panel panel-primary" style="background-color: #f0f8ed">
						<div id="histogram"
							style="min-width:300px; height:380px; display:block;"></div>
					</div>
				</div>
			</div>


			<div class="col-md-3 chart">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="row">
							<div>
								<i class="fa fa-repeat"></i>
							</div>
						</div>
					</div>
					<div class="panel panel-primary"
						style="background-color: #d9edf742">
						<div id="pie"
							style="min-width:300px;height:380px; display: block;"></div>
					</div>
				</div>
			</div>


			<div class="col-md-2 col-sm-12 col-xs-12 col" id="rank">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<i class="fa fa-signal"></i>&nbsp;垃圾回收排行榜 <i
							class="fa fa-exchange exchange" style="float: right;"></i>
					</div>
					<div class="panel-body" style="overflow: hidden;">
						<div class="rank" style="width: 460px; overflow: hidden;">
							<div class="rankRubbish col-md-6" style="padding-left: 0px">
								<div class="list-group">
									<div class="btn-group btn-group-justified" role="group">
										<a type="button" class="btn btn-danger today">今日</a> <a
											type="button" class="btn btn-warning thisweek">本周</a> <a
											type="button" class="btn btn-danger thismouth">本月</a> <a
											type="button" class="btn btn-danger thismouth">全部</a>
									</div>
									<div class="rubbishranklist">
										<s:iterator value="#request.rankRubbish" status="i">
											<a href="#" class="list-group-item"> ${i.getIndex() + 1}.<span
												class="badge">${sortKey }kg</span> </i>&nbsp;&nbsp;&nbsp;${name }&nbsp;&nbsp;<i
												class="fa fa-caret-up" style="color:red"></i>
											</a>
										</s:iterator>
									</div>
								</div>
							</div>
							<div class="rankCommodity col-md-6" style="padding-left: 4px">
								<div class="list-group">
									<div class="btn-group btn-group-justified" role="group">
										<a type="button" class="btn btn-danger today">今日</a> <a
											type="button" class="btn btn-warning thisweek">本周</a> <a
											type="button" class="btn btn-danger thismouth">本月</a> <a
											type="button" class="btn btn-danger thismouth">全部</a>
									</div>
									<div class="commodityranklist">
										<s:iterator value="#request.rankCommodity" status="i">
											<a href="#" class="list-group-item"> ${i.getIndex() + 1}.<span
												class="badge">${sortKey }件</span> </i>&nbsp;&nbsp;&nbsp;${name }&nbsp;&nbsp;<i
												class="fa fa-caret-up" style="color:red"></i>
											</a>
										</s:iterator>
									</div>
								</div>
							</div>
						</div>
						<div class="text-right" style="padding: 4px;">
							<a href="#">More Tasks <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3 chart">
				<div class="panel panel-success">
					<div class="panel-heading" style="background-color: #f0f8ed">
						<div class="row">
							<div>
								<i class="fa fa-repeat"></i>
							</div>
						</div>
					</div>
					<div id="map" style="min-width:300px;height:360px;"></div>
				</div>
			</div>

			<div class="col-md-7 chart">
				<div class="panel panel-info">
					<div class="panel-heading" style="background-color: #d9edf742">
						<div class="row">
							<div>
								<i class="fa fa-repeat"></i>
							</div>
						</div>
					</div>
					<div class="panel panel-primary">
						<div id="line" style="min-width:300px; height:360px"></div>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">

				<div class="panel panel-default">
					<div class="panel-heading">Responsive Table Example</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>回收点名称</th>
										<th>回收点地址</th>
										<th>小区</th>
										<th>时间</th>
										<th>垃圾名称</th>
										<th>重量</th>
										<th>积分</th>
										<th>用户</th>
										<th>录入管理员</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<s:if test="#request.rubbishItemPageBean.list != null">
										<s:iterator value="#request.rubbishItemPageBean.list">
											<tr>
												<td>${recyclePoint.name }</td>
												<td ><s:if
														test="recyclePoint.cell.address.parAddress != null">

														<s:if
															test="recyclePoint.cell.address.parAddress.parAddress != null">
		                                            				${recyclePoint.cell.address.parAddress.parAddress.name }-
		                                            				${recyclePoint.cell.address.parAddress.name }-
		                                            			</s:if>
														<s:else>
		                                            				${recyclePoint.cell.address.parAddress.name }-
		                                            			</s:else>

													</s:if>${recyclePoint.cell.address.name}</td>
												<td>${recyclePoint.cell.name }</td>
												<td><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></td>
												<td>${rubbish.name }</td>
												<td>${weight }kg</td>
												<td>${point }</td>
												<td>${user.name }</td>
												<td>${manger.name }</td>
												<td><div class="btn-group btn-group-sm">
														<a class="btn btn-primary"
															href="${path}recyclePoint_toEditPage?form.id=${id}"><i
															class="fa fa-edit"></i>&nbsp;&nbsp;详情</a> 
													</div></td>
											</tr>
										</s:iterator>
									</s:if>

								</tbody>
							</table>
						</div>
					</div>
				</div>


			</div>

			<div class="col-md-9 col-sm-12 col-xs-12">

				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #4ec25a;">Responsive
						Table Example</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<colgroup>
										<col></col>
										<col></col>
										<col width="500px"></col>
										<col></col>
										<col></col>
										<col></col>
									</colgroup>
									<tr>
										<th>用户名称</th>
										<th>时间</th>
										<th>商品</th>
										<th>总件数</th>
										<th>总计积分</th>
										<th>总计积分</th>
									</tr>
								</thead>
								<tbody>
									<s:if test="#request.convertPageBean.list != null">
										<s:iterator value="#request.convertPageBean.list">
											<tr>
												<td>${user.name }</td>
												<td><s:date name="time" format="yyyy-MM-dd hh:mm:ss" /></td>
												<td><s:iterator value="convertItems" status="i">
														<s:if test="#i.isLast()">
		                                   	${commodity.name }&nbsp;<span
																class="badge">${quantity}个</span>
														</s:if>
														<s:else>
											${commodity.name }&nbsp;<span class="badge">${quantity}个</span>&nbsp;
										</s:else>
													</s:iterator></td>
												<td>${amount }件</td>
												<td>${point }</td>
												<td><div class="btn-group btn-group-sm">
														<a class="btn btn-success"
															href="${path}recyclePoint_toEditPage?form.id=${id}"><i
															class="fa fa-edit"></i>&nbsp;&nbsp;详情</a> 
													</div></td>
										</s:iterator>
									</s:if>

								</tbody>
							</table>
						</div>
					</div>
				</div>


			</div>
			<div class="col-md-3 col-sm-12 col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #db7b70;">Tasks
						Panel</div>
					<div class="panel-body">
						<div class="list-group">

							<a href="#" class="list-group-item"> <span class="badge">7
									minutes ago</span> <i class="fa fa-fw fa-comment"></i> Commented on a
								post
							</a> <a href="#" class="list-group-item"> <span class="badge">16
									minutes ago</span> <i class="fa fa-fw fa-truck"></i> Order 392 shipped
							</a> <a href="#" class="list-group-item"> <span class="badge">36
									minutes ago</span> <i class="fa fa-fw fa-globe"></i> Invoice 653 has
								paid
							</a> <a href="#" class="list-group-item"> <span class="badge">1
									hour ago</span> <i class="fa fa-fw fa-user"></i> A new user has been
								added
							</a> <a href="#" class="list-group-item"> <span class="badge">1.23
									hour ago</span> <i class="fa fa-fw fa-user"></i> A new user has added
							</a> <a href="#" class="list-group-item"> <span class="badge">yesterday</span>
								<i class="fa fa-fw fa-globe"></i> Saved the world
							</a> </a> <a href="#" class="list-group-item"> <span class="badge">yesterday</span>
								<i class="fa fa-fw fa-globe"></i> Saved the world
							</a>
						</div>
						<div class="text-right">
							<a href="#">More Tasks <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
	<pre id="tsv" style="display:none">Browser Version	Total Market Share
IE 8.0	26.61%
IE 9.0	16.96%
Chrome 18.0	8.01%
Chrome 19.0	7.73%
Firefox 12	6.72%
Internet Explorer 6.0	6.40%
Firefox 11	4.72%
Internet Explorer 7.0	3.55%
Safari 5.1	3.53%
Firefox 13	2.16%
Firefox 3.6	1.87%
Opera 11.x	1.30%
Chrome 17.0	1.13%
Firefox 10	0.90%
Safari 5.0	0.85%
Firefox 9.0	0.65%
Firefox 8.0	0.55%
Firefox 4.0	0.50%
Chrome 16.0	0.45%
Firefox 3.0	0.36%
Firefox 3.5	0.36%
Firefox 6.0	0.32%
Firefox 5.0	0.31%
Firefox 7.0	0.29%
Proprietary or Undetectable	0.29%
Chrome 18.0 - Maxthon Edition	0.26%
Chrome 14.0	0.25%
Chrome 20.0	0.24%
Chrome 15.0	0.18%
Chrome 12.0	0.16%
Opera 12.x	0.15%
Safari 4.0	0.14%
Chrome 13.0	0.13%
Safari 4.1	0.12%
Chrome 11.0	0.10%
Firefox 14	0.10%
Firefox 2.0	0.09%
Chrome 10.0	0.09%
Opera 10.x	0.09%
Internet Explorer 8.0 - Tencent Traveler Edition	0.09%
</pre>
</body>

<script src="http://127.0.0.1:3000/socket.io/socket.io.js"></script>  
    <script type="text/javascript">  
        // 创建websocket连接  
        var socket = io.connect('http://127.0.0.1:3000');  
        // 把信息显示到div上  
        socket.on('onlinenums', function (data) {  
  
                $("#nums").html(data.nums);
				//socket.send();
        }); 
		socket.on('totalPoint', function (data) {  
  
                $("#totalPoint").html(data + "&nbsp;&nbsp;个");
				//socket.send();
        }); 
		socket.on('totalWeight', function (data) {  
  
                $("#totalWeight").html(data + "&nbsp;&nbsp;kg");
				//socket.send();
        }); 
		socket.on('todayWeight', function (data) {  
  
                $("#todayWeight").html(data + "&nbsp;&nbsp;kg");
				//socket.send();
        }); 
		socket.on('todayAmount', function (data) {  
  
                $("#todayAmount").html(data + "&nbsp;&nbsp;个");
				//socket.send();
        }); 
		socket.on('totalNumber', function (data) {  
  
                $("#totalNumber").html(data + "&nbsp;&nbsp;个");
				//socket.send();
        }); 
		socket.on('totalAmount', function (data) {  
  
                $("#totalAmount").html(data + "&nbsp;&nbsp;个");
				//socket.send();
        }); 

		function send(){
		
			socket.emit('massage',"haha");
		}
		function send2(){
		
			socket.emit('call',"打Call");
		}
    </script>  
</html>

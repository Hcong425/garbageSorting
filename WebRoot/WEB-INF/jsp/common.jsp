<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'common.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="${path}css/bootstrap.min.css" rel="stylesheet">
<link href="${path}font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
<link href="${path}css/common.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${path }css/bootstrap-switch.css" />
<script src="${path}js/jquery-3.2.1.js"></script>
<script src="${path}js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}js/bootstrap-switch.js"></script>
<script type="text/javascript" src="${path}js/chart/highcharts.js"></script>
<script type="text/javascript" src="${path}js/common.js"></script>
<script type="text/javascript" src="${path}js/chart/drilldown.js"></script>
<script type="text/javascript" src="${path}js/chart/data.js"></script>
<script type="text/javascript" src="${path}js/map/map.js"></script>
<script type="text/javascript" src="${path}js/map/drilldown.js"></script>
<script type="text/javascript" src="${path}js/map/data.js"></script>
<script type="text/javascript" src="${path }js/moment.js"></script>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top" style="margin: 0" id="topNav">
		<div class="navbar-header">
			<a class="navbar-brand"  style="color:#fff" href="${path}manger_toIndexPage"> <span
				class="glyphicon glyphicon-globe"></span><strong>垃圾分类平台</strong>
			</a>

		</div>
		<div class="shrank"><i class="fa fa-bars fa-2x"></i></div>
		<form class="navbar-form navbar-right">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default"><i class="fa fa-search"></i>搜索</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li><a ><span class="glyphicon glyphicon-bell"></span>消息</a></li>
			<li><a ><span class="glyphicon glyphicon-heart"></span>关注</a></li>
				<li class="dropdown"><a  class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-cog fa-spin"></i>
					设置 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a >Action</a></li>
					<li><a >Another action</a></li>
					<li><a >Something else here</a></li>
					<li role="separator" class="divider"></li>
					<li><a >Separated link</a></li>
					<li role="separator" class="divider"></li>
					<li><a >One more separated link</a></li>
				</ul>
			</li>
			<li class="dropdown"><a  class="dropdown-toggle"
				data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
					我的 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a >Action</a></li>
					<li><a >Another action</a></li>
					<li><a >Something else here</a></li>
					<li role="separator" class="divider"></li>
					<li><a >Separated link</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="manger_logout"><span class="glyphicon glyphicon-off"></span>注销</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	<ul class="nav nav-pills nav-stacked" id="sideNav">
		<div class="time" style="font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;">
                      <h1 class="animated fadeInLeft"></h1>
                      <p class="animated fadeInRight"></p>
         </div>
		<li role="presentation"><a  data-toggle="collapse" class="pulldown"
			data-target="#content2"><span
				class="glyphicon glyphicon-map-marker"></span>回收点<span
				class="glyphicon glyphicon-chevron-down"></span></a>
			<ul id="content2" class="list-group collapse down ">
				<li class="list-group-item"><a href="${path}recyclePoint_findAllByPage"><span
						class="glyphicon glyphicon-info-sign"></span>管理</a></li>
				<li class="list-group-item"><a href="${path}recyclePoint_toEditPage"><span
						class="glyphicon glyphicon-plus"></span>新增</a></li>
				<li class="list-group-item"><a href="${path}rubbishItem_findAllByPage"><span
						class="fa fa-trash"></span>所有回收记录</a></li>
				<li class="list-group-item"><a href="${path}skip_rubbishItemAdd"><span
						class="fa fa-pencil-square"></span>回收记录录入</a></li>
				<%-- <li class="list-group-item"><a ><span
						class="fa fa-eye"></span>监控回收点</a></li> --%>
				<li class="list-group-item"><a href="recyclePoint_toMapPage"><span
						class="fa fa-map-pin"></span>回收点地图显示</a></li>
			</ul></li>
		<li role="presentation"><a  data-toggle="collapse" class="pulldown"
			data-target="#content3"><span class="glyphicon glyphicon-tasks"></span>垃圾分类<span
				class="glyphicon glyphicon-chevron-down"></span></a>
			<ul id="content3" class="list-group collapse down ">
				<li class="list-group-item"><a href="${path}rubbish_findAllChildByPage"><span
						class="glyphicon glyphicon-info-sign"></span>查看</a></li>
				<li class="list-group-item"><a href="${path}rubbish_toEditPage"><span
						class="glyphicon glyphicon-plus"></span>新增</a></li>
			</ul></li>
		<li role="presentation"><a  data-toggle="collapse" class="pulldown"
			data-target="#content4"><span class="glyphicon glyphicon-user"></span>用户<span
				class="glyphicon glyphicon-chevron-down"></span></a>
			<ul id="content4" class="list-group collapse down ">
				<li class="list-group-item"><a href="${path}user_findAllByPage"><span
						class="glyphicon glyphicon-info-sign"></span>查看</a></li>
				<li class="list-group-item"><a ><span
						class="fa fa-user-plus"></span>会员</a></li>
			</ul></li>
		<li role="presentation"><a data-toggle="collapse" class="pulldown"
			data-target="#content5"><span
				class="glyphicon glyphicon-shopping-cart"></span>积分系统<span
				class="glyphicon glyphicon-chevron-down"></span></a>
			<ul id="content5" class="list-group collapse down ">
				<li class="list-group-item"><a href="commodity_findAllByPage"><span
						class="fa fa-tags"></span>商品</a></li>
				<li class="list-group-item"><a href="commodity_toEditPage"><span
						class="glyphicon glyphicon-plus"></span>新增</a></li>
				<li class="list-group-item"><a href="convert_findAllByPage"><span
						class="fa fa-shopping-bag"></span>积分兑换记录</a></li>
				<li class="list-group-item"><a href="${path}pointChange_findAllByPage"><span
						class=" fa fa-exchange"></span>积分更改纪录</a></li>
			</ul></li>
		<li role="presentation"><a data-toggle="collapse" class="pulldown"
			data-target="#content6"><span
				class="glyphicon glyphicon-exclamation-sign"></span>权限<span
				class="glyphicon glyphicon-chevron-down"></span></a>
			<ul id="content6" class="list-group collapse down ">
				<li class="list-group-item"><a href="${path }right_findAllByPage"><span
						class="glyphicon glyphicon-info-sign"></span>权限管理</a></li>
				<li class="list-group-item"><a href="${path }role_findAllByPage"><span
						class="fa fa-sitemap"></span>角色管理</a></li>
				<li class="list-group-item"><a href="${path }role_toDistributionPage"><span
						class="fa fa-unlock"></span>角色分配</a></li>
			</ul></li>
		<li role="presentation"><a data-toggle="collapse" class="pulldown"
			data-target="#content7"><span
				class="fa fa-comments"></span>活动发布<span
				class="glyphicon glyphicon-chevron-down"></span></a>
			<ul id="content7" class="list-group collapse down ">
				<li class="list-group-item"><a >  <i class="fa fa-refresh fa-spin"></i></span>正在进行活动</a></li>
				<li class="list-group-item"><a ><span
						class="fa fa-history"></span>历史活动</a></li>
				<li class="list-group-item"><a ><span
						class="fa fa-cloud-upload"></span>活动发布</a></li>
			</ul></li>
	</ul>

</body>
</html>

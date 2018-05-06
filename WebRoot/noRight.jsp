<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'NoRight.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.right {
	width: 400px;
	margin: 0 auto;
	margin-top:200px;
	font-size: 35px;
	color: white;
	text-align: center;
}
.english{
	width: 800px;
	margin: 0 auto;
	margin-top:35px;
	font-size: 35px;
	color: white;
	text-align: center;
}
.download-block{
text-align:center;
}
.download-block .btn-download {
    margin: 45px 5px 0px;
    font-weight: 700;
    padding: 15px 55px;
    color: #fff;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    background: #0aabe1;
    border-radius: 2px;
    -webkit-transition: .3s ease;
    -moz-transition: .3s ease;
    -ms-transition: .3s ease;
    -o-transition: .3s ease;
    transition: .3s ease;
}
</style>

</head>

<body style="background-color: #1186ac">
	<div class="container-fluid">
		<div class="right">您的权限不足！</div>
		<div class="english">Sorry, you don't have enough authority！</div>
		<div class="download-block text-center">
			<a href="" class="btn-download">申请权限</a><a href="manger_toIndexPage"
				class="btn-download">返回</a>
		</div>
	</div>
</body>
</html>

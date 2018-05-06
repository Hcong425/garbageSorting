<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"  %>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="http://localhost:3000/socket.io/socket.io.js"></script>  
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>  
    <script type="text/javascript">  
        // 创建websocket连接  
        var socket = io.connect('http://localhost:3000');  
        // 把信息显示到div上  
        socket.on('onlinenums', function (data) {  
  
                $("#nums").html(data.nums);
				//socket.send();
        }); 
		socket.on('call', function (data) {  
  
                $("#nums").append(data);
				//socket.send();
        }); 
		function send(){
		
			socket.emit('massage',"haha");
		}
		function send2(){
		
			socket.emit('call',"打Call");
		}
    </script>  
  </head>
  
  <body>
   当前在线人数:<span style="color: red;" id="nums">0</span>  
			<input type="button" value="发送" onclick="send2()"/>
   <s:debug></s:debug>
   <s:fielderror></s:fielderror>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="common.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
#allmap {
	width: 98%;
	height: 92%;
}

.main {
	padding: 53px 0px 10px 250px;
}

.anchorBL {
	display: none;
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=QAvC8Bl3EnrDaVDeuaoyulfpCZbbBoKM"></script>
<title>缩放地图</title>
</head>
<body>

	<div class="row main">

		<div id="allmap"></div>
	</div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); //匹配目标参数
		if (r != null) return unescape(r[2]);
		return null; //返回参数值
	}
	var map = new BMap.Map("allmap");
	var cellId = getUrlParam("cellId");
	map.centerAndZoom(new BMap.Point(115.886259,28.682828), 14);
	$.ajax({
		type : "POST",
		url : "cell_findAllCellInMap",
		data : {
			"form.id" : cellId,
			"date" : new Date()
		},
		success : function(data) {
			var json = JSON.parse(data);
			for(var i = 0; i < json.length; i++){
				var point = new BMap.Point(json[i].longitude, json[i].latitude);    
				var marker = new BMap.Marker(point);        // 创建标注    
				map.addOverlay(marker);
				if(json[i].terget){
					marker.setAnimation(BMAP_ANIMATION_BOUNCE);
					map.centerAndZoom(new BMap.Point(json[i].longitude,json[i].latitude), 16);
				}
			}

		}
	});
	
	/* setTimeout(function() {
		map.setZoom(14);
	}, 2000); //2秒后放大到14级 */
	map.enableScrollWheelZoom(true);
	var myGeo = new BMap.Geocoder();
	// 根据坐标得到地址描述    
	var geoc = new BMap.Geocoder();
	map.addEventListener("click", function(e) {
		var pt = e.point;
		geoc.getLocation(pt, function(rs) {
			var addComp = rs.addressComponents;
			alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber +"    "+ e.point.lng+","+e.point.lat);
		});
	});
</script>

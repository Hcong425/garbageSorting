$(function(){
	
	var options = $("#pageSize").children();
	var pageSize = getUrlParam("pageBean.pageSize");
	for(var i =0;i<options.length;i++){
		if($(options[i]).val() == pageSize){
			$(options[i]).attr("selected","selected");
		}
	}
	
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); //匹配目标参数
		if (r != null) return unescape(r[2]);
		return null; //返回参数值
	}
	
	$('#pageSize').change(function(){
		var pageSize = $(this).val();
		window.location.href = "commodity_findAllByPage?pageBean.pageSize="+pageSize;
	})
	

})
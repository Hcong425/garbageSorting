$(function(){
	
	$('#pageSize').change(function(){
		var pageSize = $(this).val();
		window.location.href = "right_findAllByPage?pageBean.pageSize="+pageSize;
		
	})
	
})
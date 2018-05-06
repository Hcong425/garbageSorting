$(function() {

	$('#pageSize').change(function() {
		var pageSize = $(this).val();
		window.location.href = "role_findAllByPage?pageBean.pageSize=" + pageSize;

	})

	$('#role').change(function() {

		var roleId = $(this).val();
		if (roleId == 0) {
			$('.rights>i').removeClass().addClass("fa fa-ban red");
		} else {
			$('#formId').val(roleId);
			$.ajax({
				type : "POST",
				url : "right_findByRoleId",
				data : {
					"roleId" : roleId,
					"date" : new Date()
				},
				success : function(data) {
					$('.rights>i').removeClass().addClass("fa fa-ban red");
					var rights = data.split(",");
					for (var i = 0; i < rights.length; i++) {
						$('#' + rights[i]+'>i').removeClass().addClass("fa fa-check-circle green");
					}
				}
			});
		}

	})

	$(':reset').click(function(){
		$('.rights>i').removeClass().addClass("fa fa-ban red");
	})
	
	$('#distribution').click(function(){
		var id = $($(this).parent().parent().parent().children('td')[0]).text();
		$("#mangerId").val(id);
	})

})
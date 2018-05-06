$(function() {
	
	 function changeState(el) {
	        if (el.readOnly) el.checked=el.readOnly=false;
	        else if (!el.checked) el.readOnly=el.indeterminate=true;
	  }
	 
	$('#classify').change(function() {
		var parRubbishId = $(this).val();
		window.location.href = "rubbish_findAllChildByPage?pageBean.pageNum=1&form.parRubbishId=" + parRubbishId;

	})

	$('.serach form input').blur(function() {
		$('.serach form').submit();
	})

	$('.serach form').submit(function() {
		var condition = $('#text').val();
		var previous = $('#previous').val();
		condition = $.trim(condition).toUpperCase();
		previous = $.trim(previous).toUpperCase();
		if ($('.info').length >= 1) {
			if (condition == previous)
				return false;
		} else {
			if (condition != '') {
				if (previous != '') {
					if (condition == previous)
						return false;
				} else {
					return true;
				}
			}
			if (previous == '')
				return false;
		}
	})

	var active = $('[name="form.active"]').val();

	$('[name="form.monitor"], [name="form.active"]').bootstrapSwitch({
		onText : "是",
		offText : "否",
		onColor : "success",
		offColor : "info",
		size : "small",
		state : active,
		animate : 'true',
		handleWidth : '38px',
		labelWidth : '30px',
		onSwitchChange : function(event, state) {
			if (state == true) {
				$(this).val("true");
			} else {
				$(this).val("false");
			}
		}
	})
})
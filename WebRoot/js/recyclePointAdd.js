$(function() {

	var recyclePointForm = $('#recyclePointForm');
	var cellForm = $('#cellForm');
	
	var pointName = null;
	
	$("[name = 'form.pointName']").change(function(){
		pointName = isString($(this), 12, "需为1~12位字母、汉字或数字");
	})
	
	var robotNum = null;
	
	$("[name = 'form.robotNum']").change(function(){
		 robotNum = isDigit($(this), 8, "需为1~8位数字");
	})
	
	var cell = null;
	
	$("[name = 'cell.name']").change(function(){
		cell = robotNum = isString($(this), 30, "需为1~30位字母、汉字或数字");
	})
	
	var longitude = null;
	
	$("[name = 'cell.longitude']").change(function(){
		longitude = isLongitude($(this));
	})
	
	var latitude = null;
	
	$("[name = 'cell.latitude']").change(function(){
		latitude = isLatitude($(this));
	})
	
	
	$('#addComm').click(function() {
		if (!$(this).parent().hasClass('active')) {
			$(this).parent().addClass('active');
			$('#addCate').parent().removeClass('active');
			recyclePointForm.removeClass('hidden');
			cellForm.addClass('hidden');
		}

	})

	$('#addCate').click(function() {
		if (!$(this).parent().hasClass('active')) {
			$(this).parent().addClass('active');
			$('#addComm').parent().removeClass('active');
			cellForm.removeClass('hidden');
			recyclePointForm.addClass('hidden');
		}

	})

	$('#province1').change(function() {
		var parAddressId = $(this).val();
		$.ajax({
			type : "POST",
			url : "recyclePoint_fingAddressByPar",
			data : {
				"parAddressId" : parAddressId,
				"date" : new Date()
			},
			success : function(data) {
				if (data == '') {
					alert('null');
				} else {
					var json = JSON.parse(data);
					$('#city1').empty();
					for (var i = 0; i < json.length; i++) {
						if(json[i].id == $('#city1').attr('value'))
							$('#city1').append("<option value='" + json[i].id + "' selected='selected'>" + json[i].name + "</option>");
						else
							$('#city1').append("<option value='" + json[i].id + "'>" + json[i].name + "</option>");
					}
					$('#city1').change();
				}
			}
		});
	})

	$('#city1').change(function() {
		var parAddressId = $(this).val();
		$.ajax({
			type : "POST",
			url : "recyclePoint_fingAddressByPar",
			data : {
				"parAddressId" : parAddressId,
				"date" : new Date()
			},
			success : function(data) {
				var json = JSON.parse(data);
				$('#district1').empty();
				for (var i = 0; i < json.length; i++) {
					if(json[i].id == $('#district1').attr('value'))
						$('#district1').append("<option value='" + json[i].id + "' selected='selected'>" + json[i].name + "</option>");
					else
						$('#district1').append("<option value='" + json[i].id + "'>" + json[i].name + "</option>");
				}
				$('#district1').change();
			}
		});
	})

	$('#district1').change(function() {
		var addressId = $('#district1').val();
		$.ajax({
			type : "POST",
			url : "cell_findCellByAddressInMap",
			data : {
				"addressId" : addressId,
				"date" : new Date()
			},
			success : function(data) {
				$('#cell').empty();
				if (data == '') {
					$('#cell').append("<option value=''>暂无覆盖小区</option>");
				} else {
					var json = JSON.parse(data);
					if (json.length != null) {
						for (var i = 0; i < json.length; i++) {
							if(json[i].id == $('#cell').attr('value'))
								$('#cell').append("<option value='" + json[i].id + "' selected='selected'>" + json[i].name + "</option>");
							else
								$('#cell').append("<option value='" + json[i].id + "'>" + json[i].name + "</option>");
						}
					} else {
						$('#cell').append("<option value=''>暂无覆盖小区</option>");
					}
				}

			}
		});
	})

	$('#province1').change();

	$('#province2').change(function() {
		var parAddressId = $(this).val();
		$.ajax({
			type : "POST",
			url : "recyclePoint_fingAddressByPar",
			data : {
				"parAddressId" : parAddressId,
				"date" : new Date()
			},
			success : function(data) {
				var json = JSON.parse(data);
				$('#city2').empty();
				for (var i = 0; i < json.length; i++) {
					$('#city2').append("<option value='" + json[i].id + "'>" + json[i].name + "</option>");
				}
				$('#city2').change();
			}
		});
	})

	$('#city2').change(function() {
		var parAddressId = $(this).val();
		$.ajax({
			type : "POST",
			url : "recyclePoint_fingAddressByPar",
			data : {
				"parAddressId" : parAddressId,
				"date" : new Date()
			},
			success : function(data) {
				var json = JSON.parse(data);
				$('#district2').empty();
				for (var i = 0; i < json.length; i++) {
					$('#district2').append("<option value='" + json[i].id + "'>" + json[i].name + "</option>");
				}
			}
		});
	})

	$('#province2').change();
	
	$('#recyclePointForm .form').submit(function(){
		var flag = true;
		if(robotNum == null){
			$("[name = 'form.robotNum']").change();
		}
		if(pointName == null){
			$("[name = 'form.pointName']").change();
		}
		if($("[name = 'form.robotNum']").val() == ''){
			nothing($("[name = 'form.robotNum']"));
		}
		if($("[name = 'form.pointName']").val() == ''){
			nothing($("[name = 'form.pointName']"));
		}
		if(pointName && robotNum){
			this.submit();
		}
		else
			return false;
	})
	
	$('#cellForm .form').submit(function(){
		var flag = true;
		if(cell == null){
			$("[name = 'cell.name']").change();
		}
		if(longitude == null){
			$("[name = 'cell.longitude']").change();
		}
		if(latitude == null){
			$("[name = 'cell.latitude']").change();
		}
		if($("[name = 'cell.name']").val() == ''){
			flag = false;
			nothing($("[name = 'cell.name']"));
		}
		if($("[name = 'cell.longitude']").val() == ''){
			flag = false;
			nothing($("[name = 'cell.longitude']"));
		}
		if($("[name = 'cell.latitude']").val() == ''){
			flag = false;
			nothing($("[name = 'cell.latitude']"));
		}
		if(flag && cell && longitude && latitude){
			this.submit();
		}
		else
			return false;
	})
	
	var active = $('[name="form.active"]').val();
		
		$('[name="form.monitor"], [name="form.active"]').bootstrapSwitch({
			onText : "是",
			offText : "否",
			onColor : "success",
			offColor : "info",
			size : "small",
			state: active,
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
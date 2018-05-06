$(function(){
	
	var cateForm = $('#cateForm');
	var commForm = $('#commForm');
	var parent = $('#parent');
	var children = $('#children');

	var name = null;
	
	$("[name = 'form.name']").change(function(){
		name = isString($(this), 12, "需为1~12位字母、汉字或数字");
	})
	
	var descr = null;
	
	$("[name = 'form.descr']").change(function(){
		descr = notNull($(this));
	})
	
	var point = null;
	
	$("[name = 'form.point']").change(function(){
		point = isDigit($(this), 6, "需位1~6位数字");
	})
	
	var upload = null;
	
	$("[name = 'upload']").change(function(){
		upload = isImage($(this));
	})	
	
	var repertory = null;
	
	$("[name = 'form.repertory']").change(function(){
		repertory = isDigit($(this), 6, "需位1~6位数字");
	})

	
	$('#commForm form').submit(function(){
		if(name == null){
			$("[name = 'form.name']").change();
		}
		if(descr == null){
			$("[name = 'form.descr']").change();
		}
		if(point == null){
			$("[name = 'form.point']").change();
		}
		if(upload == null){
			$("[name = 'upload']").change();
		}
		if(repertory == null){
			$("[name = 'form.repertory']").change();
		}
		if($("[name = 'form.name']").val() == ''){
			nothing($("[name = 'form.name']"));
		}
		if($("[name = 'form.descr']").val() == ''){
			nothing($("[name = 'form.descr']"));
		}
		if($("[name = 'form.point']").val() == ''){
			nothing($("[name = 'form.point']"));
		}
		if($("[name = 'upload']").val() == ''){
			nothing($("[name = 'upload']"), "请选择文件");
		}
		if($("[name = 'form.repertory']").val() == ''){
			nothing($("[name = 'form.repertory']"));
		}
		if(upload && name && descr && point){
			this.submit();
		}
		else
			return false;
	})
	
	var cname = null;
	
	$("[name = 'categoryForm.name']").change(function(){
		cname = isString($(this), 12, "需为1~12位字母、汉字或数字");
	})
	
	
	$('#cateForm form').submit(function(){
		
		if(cname == null){
			$("[name = 'categoryForm.name']").change();
		}
		
		if($("[name = 'categoryForm.name']").val() == ''){
			nothing($("[name = 'categoryForm.name']"));
		}
		
		if(cname){
			this.submit();
		}else{
			return false;
		}
	})
	
	
	if(parent.val() != ""){
	
		$.ajax({
			type : "POST",
			url : "category_findChildById",
			data : {
				"categoryForm.id" : parent.val(),
				"date" : new Date()
			},
			success : function(data) {
				var json = JSON.parse(data);
				var children = $('#children');
				$(children).empty();
				if(json == "")
					$(children).append("<option>暂无子分类</option>");
				else{
					for(var i = 0; i < json.length; i++){
						if(json[i].id == children.attr("childrenId")){
							$(children).append("<option value="+ json[i].id +" selected='selected'>"+ json[i].name +"</option>");
						}else{
							$(children).append("<option value="+ json[i].id +">"+ json[i].name +"</option>");
						}
					}
				}
			}
		});
	}
	
	$('#addComm').click(function(){
		if(!$(this).parent().hasClass('active')){
			$(this).parent().addClass('active');
			$('#addCate').parent().removeClass('active');
			commForm.removeClass('hidden');
			cateForm.addClass('hidden');
		}
		
	})
	
	$('#addCate').click(function(){
		if(!$(this).parent().hasClass('active')){
			$(this).parent().addClass('active');
			$('#addComm').parent().removeClass('active');
			cateForm.removeClass('hidden');
			commForm.addClass('hidden');
		}
		
	})
	
	var parCategory = $('#parCategory');
	
	$(':checkbox').bootstrapSwitch({
			onText : "是",
			offText : "否",
			onColor : "success",
			offColor : "info",
			size : "small",
			animate : 'true',
			handleWidth : '38px',
			labelWidth : '30px',
			onSwitchChange : function(event, state) {
				if (state == true) {
					if(!$(parCategory).hasClass('hidden'))
						$(parCategory).addClass('hidden');
						$(this).val("true");
				} else {
					if($(parCategory).hasClass('hidden'))
						$(parCategory).removeClass('hidden');
						$(this).val("false");
				}
			}
		})
		
	$('#parent').change(function(){
		$.ajax({
			type : "POST",
			url : "category_findChildById",
			data : {
				"categoryForm.id" : $(this).val(),
				"date" : new Date()
			},
			success : function(data) {
				var json = JSON.parse(data);
					
				var children = $('#children');
				$(children).empty();
				if(json == "")
					$(children).append("<option>暂无子分类</option>");
				else{
				for(var i = 0; i < json.length; i++)
					$(children).append("<option value="+ json[i].id +">"+ json[i].name +"</option>");
				}
			}
		});

	})
	
})
$(function(){
	
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
	
	$('form').submit(function(){
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
		if(upload && name && descr && point){
			this.submit();
		}
		else
			return false;
	})
	
	$('[name="form.monitor"], [name="form.active"]').bootstrapSwitch({ 
        onText:"是",  
        offText:"否",  
        onColor:"success",  
        offColor:"info",  
        size:"small", 
        animate:'true',
        handleWidth:'38px',
        labelWidth:'30px',
        onSwitchChange:function(event,state){  
            if(state==true){  
                $(this).val("true");
            }else{  
                $(this).val("false"); 
            }  
        }  
    }) 
    
     function preview1(file) {
        var img = new Image(), url = img.src = URL.createObjectURL(file)
        var $img = $(img)
        img.onload = function() {
            URL.revokeObjectURL(url)
            $('#preview').empty().append($img);
        }
	}
     function preview2(file) {
        var reader = new FileReader()
        reader.onload = function(e) {
            var $img = $('<img>').attr("src", e.target.result);
            $('#preview').empty().append($img);
           
        }
        reader.readAsDataURL(file)
    }
         
    $(function() {
        $('[type=file]').change(function(e) {
        	if($(this).val() != ''){
	            var file = e.target.files[0]
	            preview1(file);
        	}else{
        		$('#preview').empty();
        	}
        })
    })
    
})
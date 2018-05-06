$(function(){
		$('[name="form.monitor"], [name="form.active"]').bootstrapSwitch({ 
        onText:"是",  
        offText:"否",  
        onColor:"success",  
        offColor:"info",  
        size:"small", 
        animate:'true',
        handleWidth:'40px',
        labelWidth:'30px',
        onSwitchChange:function(event,state){  
            if(state==true){  
                $(this).val("true");
            }else{  
                $(this).val("false"); 
            }  
        }  
    })
    
    var name = null;
		
	$("[name = 'form.name']").change(function(){
		name = notNull($(this));
	})
	
	var url = null;
	
	$("[name = 'form.url']").change(function(){
		url = notNull($(this));
	})
	
	$('form').submit(function(){
		if(name == null){
			$("[name = 'form.name']").change();
		}
		if(url == null){
			$("[name = 'form.url']").change();
		}		
		if($("[name = 'form.name']").val() == ''){
			nothing($("[name = 'form.name']"));
		}
		if($("[name = 'form.url']").val() == ''){
			nothing($("[name = 'form.url']"));
		}
		if(url && name){
			this.submit();
		}
		else
			return false;
	})
})
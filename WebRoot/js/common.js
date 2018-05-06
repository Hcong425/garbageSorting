
var datetime = null,
	date = null;

var update = function() {
	date = moment(new Date());
	datetime.html(date.format('HH:mm'));
	datetime2.html(date.format('YYYY年 MM月  DD日, dddd'));
};

function error(input, msg){
	input.parents('.form-group').removeClass('has-success').addClass('has-error');
	input.next('.form-control-feedback').children('.text').html(msg+"<span class='glyphicon glyphicon-remove'>");
}

function success(input){
	input.parents('.form-group').removeClass('has-error').addClass('has-success');
	input.next('.form-control-feedback').children('.text').html("<span class='glyphicon glyphicon-ok'>");
}

function clear(input){
	input.parents('.form-group').removeClass('has-error').removeClass('has-success');
	input.next('.form-control-feedback').children('.text').html("");
}

function hint(flag, input, msg){
	if(flag)
		success(input);
	else
		error(input, msg);
	return flag;
}

function nothing (input, msg){
	var value = input.val();
	if(msg == null)
		msg = "不能为空";
	if(value == ''){
		error(input, msg);
	}
}

function notNull(input){
	var value = input.val();
	if(value != ''){
		value = $.trim(value);
		if(value != ''){
			success(input);
			return true;
		}else{
			error(input, "不能为空");
			return false;
		}
	}else{
		clear(input);
		return false;
	}
}

function isDigit (input, length, msg){
	var value = input.val();
	var not = notNull(input);
	if(not){
		var reg = new RegExp("^\\d{1,"+length+"}$");
		return hint(reg.test(value), input, msg);
	}else{
		return false;
	}
	
}

function isString (input, length, msg){
	var value = input.val();
	var not = notNull(input);
	if(not){
		var reg = new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]{1,"+ length +"}$");
		return hint(reg.test(value), input, msg);
	}else{
		return false;
	}
	
}

function isLongitude (input){
	var value = input.val();
	var not = notNull(input);
	if(not){
		var reg = new RegExp("^(((\\d|[1-9]\\d|1[1-7]\\d|0)\\.\\d{0,4})|(\\d|[1-9]\\d|1[1-7]\\d|0{1,3})|180\\.0{0,4}|180)$");
		return hint(reg.test(value), input, "请输入正确经度(小数部分为0~4位)");
	}else{
		return false;
	}
	
}

function isLatitude (input){
	var value = input.val();
	var not = notNull(input);
	
	if(not){
		var reg = new RegExp("^([0-8]?\\d{1}\\.\\d{0,4}|90\\.0{0,4}|[0-8]?\\d{1}|90)$");
		return hint(reg.test(value), input, "请输入正确纬度(小数部分为0~4位)");
	}else{
		return false;
	}
	
}

function isImage(input){
	var fileName = input.val();
	var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
	if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG"){
		success(input);
		return true;
	}
	else{
		error(input, "文件类型需为JPG, JPEG, PNG, GIF");
		return false;
	}

}

$(function() {

	datetime = $('.time h1');
	datetime2 = $('.time p');
	update();
	setInterval(update, 1000);

	$('.pulldown').click(function() {
		$('#sideNav').children().removeClass("active");
		$(this).parent().addClass("active");
		var spans = $("#sideNav>li[class!='active'] a span:last-child");
		for(var i = 0; i < spans.length; i++){
			if($(spans[i]).hasClass("glyphicon-chevron-up")){
				$(spans[i]).removeClass("glyphicon-chevron-up");
				$(spans[i]).addClass("glyphicon-chevron-down");
			}
		}
		var span = $("#sideNav>li.active a span:first-child").next();
		if (span.hasClass("glyphicon-chevron-down")) {
			span.removeClass("glyphicon-chevron-down");
			span.addClass("glyphicon-chevron-up");
		} else if (span.hasClass("glyphicon-chevron-up")) {
			span.removeClass("glyphicon-chevron-up");
			span.addClass("glyphicon-chevron-down");
		}

		var lis = $('#sideNav').children();
		for (var i = 0; i < lis.length; i++) {
			if (!$(lis[i]).hasClass('active'))
				$($(lis[i]).children('ul')).removeClass('in');
		}

	})
	
	$('.prevent').click(function(){
		return false;
	})
	
	$('.delete').click(function(){
		if(confirm("确定要删除?"))
			return true;
		return false;
	})
	
	$('.shrank>i').click(function(){
		if(!$(this).hasClass('fa-rotate-90')){
			$(this).addClass('fa-rotate-90');
			$('#sideNav').removeClass('back').addClass('move');
			$('.main').removeClass('navback').addClass('navmove');
			$('.navTop').removeClass('navback').addClass('navmove');
		}else{
			$(this).removeClass('fa-rotate-90');
			$('#sideNav').removeClass('move').addClass('back');
			$('.main').removeClass('navmove').addClass('navback');
			$('.navTop').removeClass('navmove').addClass('navback');
		}
	})
	
})
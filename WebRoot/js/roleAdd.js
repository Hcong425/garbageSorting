$(function() {

	var name = null;

	$("[name = 'form.name']").change(function() {
		name = isString($(this), 12, "需为1~12位字母、汉字或数字");
	})

	$('form').submit(function() {
		if (name == null) {
			$("[name = 'form.name']").change();
		}
		if ($("[name = 'form.name']").val() == '') {
			nothing($("[name = 'form.name']"));
		}
		if (name)
			this.submit();
		else
			return false;

	})

})

function changeState(el) {
	if (el.readOnly)
		el.checked = el.readOnly = false;
	else if (!el.checked)
		el.readOnly = el.indeterminate = true;
}
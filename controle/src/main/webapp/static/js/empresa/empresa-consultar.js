$(document).ready(function(){
	$("#filtro").change(function(data){
		if($("#filtro").val() == ''){
			$('form').submit();
		}
	});
});
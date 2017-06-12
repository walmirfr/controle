/**
 * 
 */
$( document ).ready(function() {
	verificarMarca();
	
	$('#selectMarca').change(function(){
		var marca = $('#selectMarca').val();
		$('#marcaDoModelo').val(marca);
		montarSelectModeloPorMarca(marca);
		verificarMarca();
	});
	
	$( "input[name*='tipo']" ).change(function(){
		
	});
	
});

function verificarMarca(){
	var marca = $('#selectMarca').val();
	if(marca == '#'){
		$('#selectModelo, #btModelo').prop('disabled', 'disabled');
	}else{
		$('#selectModelo, #btModelo').prop('disabled', false);
	}
}

function inserirMarca(){
	var nomeMarca = $("#nomeMarca").val();
	$.post("inserirMarca", {nome: nomeMarca}, function(){
		montarSelectMarca();
	});
}

function inserirModelo(){
	var nomeModelo = $("#nomeModelo").val();
	var marcaModelo = $("#marcaDoModelo").val();
	$.post("inserirModelo", $('#formModelo').serialize(), function(){
		montarSelectModeloPorMarca(marcaModelo);
	});
}
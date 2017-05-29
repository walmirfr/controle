/**
 * 
 */
$( document ).ready(function() {
	
	$('#selectMarca').change(function(){
		var marca = $('#selectMarca').val();
		$('#marcaDoModelo').val(marca);
		montarSelectModeloPorMarca(marca);
	});
	
});

function montarListaModelos(idMarca){
    $.getJSON('listarModelosPorMarca?idMarca='+idMarca, function(response){ 
        $("#selectModelo option").remove(); 
        var options = '<option value="#">Selecione um Modelo</option>';
        $.each(response, function(index, modelo) {
            options += '<option value="' + modelo.idModelo + '">' + modelo.nome + '</option>';
            $("#selectModelo").html(options);
        });
    });
}

function inserirMarca(){
	var nomeMarca = $("#nomeMarca").val();
	$.post("inserirMarca", {nome: nomeMarca}, function(){
		montarSelectMarca();
	});
}
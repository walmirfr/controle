/**
 * 
 */
$( document ).ready(function() {
	
	$('#selectMarca').change(function(){
		var marca = $('#selectMarca').val();
		$('#marcaDoModelo').val(marca);
		/*montarListaModelos(marca); */
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
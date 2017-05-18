/**
 * Configuração do datepicker
 */
$( document ).ready(function() {
	$('.datepicker').datepicker({
	    format: "dd/mm/yyyy",
		language: "pt-BR"
	});
});

function montarSelectGrupoServico(){
	
	var valor = "<option value='#'>Selecione um Grupo</option>";
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "../servico/carregarListaGrupoServico",
		data : JSON.stringify(),
		dataType : 'json',
		timeout : 1000,
		success : function(data) {
			$(data).each(function(){
				valor = valor.concat('<option value=', this.idGrupoServico, '>', this.nome, '</option>');
			});
			$("#selectgrupoServico").html(valor);
		}
	});
}
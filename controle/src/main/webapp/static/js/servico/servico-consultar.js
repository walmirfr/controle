$(document).ready(function(){
	$("#filtro").change(function(data){
		if($("#filtro").val() == ''){
			$('form').submit();
		}
	});
});
function excluirServico(id){
	if(confirm("Desejá excluir este serviço?")){
		$.get("excluirServico?idServico="+id, carregaLista);
	}
}

function carregaLista(){
	$.get("consultar");
}

function modalExcluir(id){
	$("#excluirServico").val(id);
}
function modalAtivarDesativar(id){
	$("#ativarDesativarServico").val(id);
}

function ativarDesativarServico(funcao){
	var idServico = $("#ativarDesativarServico").val();
	$.post('ativarDesativarServico', {funcao:funcao, idServico: idServico}, function(data){
		$(data).each(function(){
			
		});
	});
}
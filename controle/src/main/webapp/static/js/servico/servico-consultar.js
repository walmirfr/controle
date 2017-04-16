/**
 * 
 */
function deletarServico(id){
	if(confirm("Desejá excluir este serviço?")){
		$.get("deletarServico?idServico="+id, carregaLista);
	}
}

function carregaLista(){
	$.get("consultar");
}
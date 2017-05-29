$(document).ready(function(){
	$("#filtro").change(function(data){
		if($("#filtro").val() == ''){
			$('form').submit();
		}
	});
});
function deletarServico(id){
	if(confirm("Desejá excluir este serviço?")){
		$.get("deletarServico?idServico="+id, carregaLista);
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


function modalAcao(id, acao){
	$('#tituloModalAcoes>span').text(acao);
	$('#tituloModalAcoes>span').closest('div').attr('class', 'modal-header ' + acao);
	corpoAcao(acao);
	$('#idFuncaoAcao').val(acao);
	$('#idServicoAcao').val(id);
}

function corpoAcao(acao){
	var texto1, texto2, classe, funcao = '';
	switch(acao){
		case 'Ativar':
			texto1 = 'O Serviço será ativado!';
			texto2 = 'Tem certeza que deseja ativar?';
			classe = 'btn btn-lg btn-success';
			funcao = 'ativarDesativarServico';
			break;
		case 'Desativar':
			texto1 = 'O Serviço será desativado!';
			texto2 = 'Tem certeza que deseja desativar?';
			classe = 'btn btn-lg btn-warning';
			funcao = 'ativarDesativarServico';
			break;
		case 'Excluir':
			texto1 = 'O Serviço será excluido!';
			texto2 = 'Tem certeza que deseja excluir?';
			classe = 'btn btn-lg btn-danger';
			funcao = 'deletarServico';
			break;
		default: break;
	}
	$('#textoAcao').text(texto1);
	$('#textoAcao2').text(texto2);
	$('#btAcao').attr('class', classe);
	$('#formAcoes').attr('action', funcao);
}

function ativarDesativarServico(funcao){
	var idServico = $("#ativarDesativarServico").val();
	$.post('ativarDesativarServico', {funcao:funcao, idServico: idServico}, function(data){
		$(data).each(function(){
			
		});
	});
}
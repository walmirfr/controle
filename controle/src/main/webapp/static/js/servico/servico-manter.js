/**
 * 
 */

function inserirGrupoServico(){
	var nomeGrupo = $("#nomeGrupo").val();
	$.post("inserirGrupoServico", {nome: nomeGrupo}, function(){
		montarSelectGrupoServico();
	});
}


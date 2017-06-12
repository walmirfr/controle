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

function montarSelectMarca(){
	
	var valor = "<option value='#'>Selecione uma Marca</option>";
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "../veiculo/carregarListaMarcas",
		data : JSON.stringify(),
		dataType : 'json',
		timeout : 1000,
		success : function(data) {
			$(data).each(function(){
				valor = valor.concat('<option value=', this.idMarca, '>', this.nome, '</option>');
			});
			$("#selectMarca").html(valor);
		}
	});
}

//ajustar
function montarSelectModeloPorMarca(idMarca){
	
	var valor = "<option value='#'>Selecione um Modelo</option>";
	
	$.post("../veiculo/carregarListaModelosPorMarca", {idMarca: idMarca}, function(data){
		$(data).each(function(){
			valor = valor.concat('<option value=', this.idModelo, '>', this.nome, '</option>');
		});
		$("#selectModelo").html(valor);
	});
}

function montarSelectProprietário(){
	
	var valor = "<option value='#'>Selecione um Proprietário</option>";
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "../manutencao/carregarListaProprietários",
		data : JSON.stringify(),
		dataType : 'json',
		timeout : 1000,
		success : function(data) {
			$(data).each(function(){
				valor = valor.concat('<option value=', this.idPessoa, '>', this.nome, '</option>');
			});
			$("#selectProprietario").html(valor);
		}
	});
}

function montarSelectServico(){
	
	var valor = "<option value='#'>Selecione um Serviço</option>";
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "../servico/carregarListaServicos",
		data : JSON.stringify(),
		dataType : 'json',
		timeout : 1000,
		success : function(data) {
			$(data).each(function(){
				valor = valor.concat('<option value=', this.idServico, '>', this.nome, '</option>');
			});
			$("#selectServico").html(valor);
		}
	});
}

function montarSelectProfissional(){
	
	var valor = "<option value='#'>Selecione um Profissional</option>";
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "../profissional/carregarListaProfissionais",
		data : JSON.stringify(),
		dataType : 'json',
		timeout : 1000,
		success : function(data) {
			$(data).each(function(){
				valor = valor.concat('<option value=', this.idPessoa, '>', this.nome, '</option>');
			});
			$("#selectProfissionais").html(valor);
		}
	});
}


function modalAcao(id, acao, objeto){
	$('#tituloModalAcoes>span').text(acao);
	$('#tituloModalAcoes>span').closest('div').attr('class', 'modal-header ' + acao);
	corpoAcao(acao, objeto);
	$('#idFuncaoAcao').val(acao);
	$('#idAcao').val(id);
}

function corpoAcao(acao, objeto){
	var texto1, texto2, classe, funcao = '';
	switch(acao){
		case 'Ativar':
			texto1 = 'O '+objeto+' será ativado!';
			texto2 = 'Tem certeza que deseja ativar?';
			classe = 'btn btn-lg btn-success';
			funcao = 'ativarDesativar'+objeto;
			break;
		case 'Desativar':
			texto1 = 'O '+objeto+' será desativado!';
			texto2 = 'Tem certeza que deseja desativar?';
			classe = 'btn btn-lg btn-warning';
			funcao = 'ativarDesativar'+objeto;
			break;
		case 'Excluir':
			texto1 = 'O '+objeto+' será excluido!';
			texto2 = 'Tem certeza que deseja excluir?';
			classe = 'btn btn-lg btn-danger';
			funcao = 'excluir'+removerAcentos(objeto);
			break;
		default: break;
	}
	$('#textoAcao').text(texto1);
	$('#textoAcao2').text(texto2);
	$('#btAcao').attr('class', classe);
	$('#formAcoes').attr('action', funcao);
}

/**
 * Remove acentos de caracteres
 * @param  {String} stringComAcento [string que contem os acentos]
 * @return {String}                 [string sem acentos]
 */
function removerAcentos( newStringComAcento ) {
  var string = newStringComAcento;
	var mapaAcentosHex 	= {
		a : /[\xE0-\xE6]/g,
		e : /[\xE8-\xEB]/g,
		i : /[\xEC-\xEF]/g,
		o : /[\xF2-\xF6]/g,
		u : /[\xF9-\xFC]/g,
		c : /\xE7/g,
		n : /\xF1/g
	};

	for ( var letra in mapaAcentosHex ) {
		var expressaoRegular = mapaAcentosHex[letra];
		string = string.replace( expressaoRegular, letra );
	}

	return string;
}

function removerLinha(ref){
	ref.closest('tr').remove();
}
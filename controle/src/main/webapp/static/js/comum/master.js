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

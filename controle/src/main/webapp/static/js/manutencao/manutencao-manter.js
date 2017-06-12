/**
 * 
 */
$(document).ready(function(){
	verificarProprietario();
	
	$("#proprietario").change(function(){
		verificarProprietario();
		carregarVeiculosPorProprietario();
	});
	$("#selectVeiculo").change(function(){
		verificarVeiculo();
	})
});

function verificarVeiculo(){
	var veiculo = $("#selectVeiculo").val();
	if(veiculo != '#'){
		$.post("../manutencao/consultarVeiculo", {idVeiculo: veiculo}, function(data){
			$("#marca").val(data.marca.nome);
			$("#modelo").val(data.modelo.nome);
		});
	}else{
		limparMarcaModelo();
	}
}
function limparMarcaModelo(){
	$("#marca").val('');
	$("#modelo").val('');
}

function verificarProprietario(){
	var proprietario = $("#proprietario").val();
	if(proprietario == '#'){
		$('.bloq').prop('disabled','disabled');
		limparMarcaModelo();
	}else{
		$('.bloq').prop('disabled', false);
	}
}

function carregarVeiculosPorProprietario(){
	var proprietario = $("#proprietario").val();
	var valor = "<option value='#'>Selecione um Veículo</option>";
	
	$.post("../manutencao/consultarVeiculoPorProprietario", {idPessoa: proprietario}, function(data){
		$(data).each(function(){
			valor += '<option value='+ this.idVeiculo+ '>'+ this.placa;
			valor += '</option>';
		});
		$("#selectVeiculo").html(valor);
	});
}

function adicionarServico(){
	var idGrupo = $('#selectGrupoServico').val();
	var nomeGrupo = $('#selectGrupoServico option:selected').text();
	var idServico = $('#selectServico').val();
	var nomeServico = $('#selectServico option:selected').text();
	
	if(idServico == '#'){
		return;
	}
	
	var controle = $('#controleServico').val() == ''? 0 : $('#controleServico').val();
	controle = 0;
	
	$("#msgServicos").text('');
	
	var linha = '';
	
	linha += '<tr align="center">';
	linha += '<td>'+nomeServico+' <input type="hidden" name="listaServicos['+controle+'].idServico" value="'+idServico+'"></td>';
	linha += '<td>'+nomeGrupo+'</td>';
	linha += '<td><input type="number" name="listaServicos['+controle+'].preco" placeholder="Preço"/></td>';
	linha += '<td><input class="btn btn-danger" onclick="removerLinha(this)" type="button" value="Remover"/></td>';
	linha += "</tr>";
	
	$('#selectGrupoServico option:selected').prop('selected', false);
	$('#selectServico option:selected').prop('selected', false);
	
	$('#controleServico').val(++controle);
	$("#tabelaServicos").append(linha);
}

function adicionarProfissional(){
	var idProfissional = $('#selectProfissional').val();
	var nomeProfissional = $('#selectProfissional option:selected').text();
	
	if(idProfissional == '#'){
		return;
	}
	
	var controle = $('#controleProfissional').val() == ''? 0 : $('#controleProfissional').val();
	controle = 0;
	$("#msgProfissional").text('');
	
	var linha = '';
	
	linha += '<tr align="center">';
	linha += '<td>'+nomeProfissional+' <input type="hidden" name="listaProfissionais['+controle+'].idPessoa" value="'+idProfissional+'"></td>';
	linha += '<td><input class="btn btn-danger" onclick="removerLinha(this)" type="button" value="Remover"/></td>';
	linha += "</tr>";
	
	
	$('#selectProfissional option:selected').prop('selected', false);
	$('#controleProfissional').val(++controle);
	$('#tabelaProfissional').append(linha);
	
}
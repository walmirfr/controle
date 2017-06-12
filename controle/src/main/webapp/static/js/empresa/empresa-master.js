/**
 * 
 */
$('#adicionarTelefone').click(function(){
	var dd = $('#ddTelefone').val();
	var numero = $('#numeroTelefone').val();
	var controle = $('#controleTelefone').val() == ''? 0 : $('#controleTelefone').val();
	
	$('#msgTelefone').text('');
	
	var linha = '';
	
	linha += '<tr align="center">';
	linha += '<td><input type="hidden" value="'+ dd +'" name="listaTelefones['+controle+'].dd">';
	linha += '('+dd+') ';
	linha += '<input type="hidden" value="'+ numero +'" name="listaTelefones['+controle+'].numero">';
	linha += numero+' </td>';
	linha += '<td><input class="btn btn-danger" onclick="removerLinha(this)" type="button" value="Remover"/></td>';
	linha += '</tr>';
	
	$('#ddTelefone').val('');
	$('#numeroTelefone').val('');
	$('#controleTelefone').val(++controle);
	$('#tabelaTelefone').append(linha);
	
});

$('#adicionarFuncionario').click(function(){
	var nome = $('#nomeFunc').val();
	var nascimento = $('#nascimentoFunc').val();
	var cpf = $('#cpfFunc').val();
	var dd = $('#ddFunc').val();
	var numero = $('#numeroFunc').val();
	var sexo = $('#sexoFunc').val();
	
	if(nome == ''){
		return;
	}
	
	var controle = $('#controleFunc').val() == ''? 0 : $('#controleFunc').val();
	
	$('#msgFunc').text('');
	
	var linha = '';
	
	linha += '<tr align="center">';
	linha += '<td><input type="hidden" value="'+nome+'" name="listaFuncionarios['+controle+'].nome">'+nome+'</td>';
	if(nascimento ==''){
		linha += '<td>-</td>';
	}else{
		linha += '<td><input type="hidden" value="'+nascimento+'" name="listaFuncionarios['+controle+'].dtNascimento">'+nascimento+'</td>';
	}
	if(cpf == ''){
		linha += '<td>-</td>';
	}else{
		linha += '<td><input type="hidden" value="'+cpf+'" name="listaFuncionarios['+controle+'].cpf">'+cpf+'</td>';
	}
	if(sexo == '#'){
		linha += '<td>-</td>';
	}else{
		linha += '<td><input type="hidden" value="'+sexo+'" name="listaFuncionarios['+controle+'].sexo">'+sexo+'</td>';
	}
	if(dd == '' || numero == ''){
		linha += '<td>-</td>';
	}else{
		linha += '<td><input type="hidden" value="'+ dd +'" name="listaFuncionarios['+controle+'].telefone.dd">';
		linha += '('+dd+') ';
		linha += '<input type="hidden" value="'+ numero +'" name="listaFuncionarios['+controle+'].telefone.numero">';
		linha += numero+'</td>';		
	}
	linha += '<td><input class="btn btn-primary" onclick="alterarFuncionario(this)" type="button" value="Alterar"/></td>';
	linha += '<td><input class="btn btn-danger" onclick="removerLinha(this)" type="button" value="Remover"/></td>';
	linha += '</tr>';
	
	$('#nomeFunc').val('');
	$('#nascimentoFunc').val('');
	$('#cpfFunc').val('');
	$('#ddFunc').val('');
	$('#numeroFunc').val('');
	$('#sexoFunc').val();
	
	$('#controleTelefone').val(++controle);
	$('#tabelaFunc').append(linha);
});

function alterarFuncionario(ref){
	
}


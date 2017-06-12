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
	linha += '<td><input class="btn btn-danger" onclick="removerTelefone(this)" type="button" value="Remover"/></td>';
	linha += '</tr>';
	
	$('#ddTelefone').val('');
	$('#numeroTelefone').val('');
	$('#controleTelefone').val(++controle);
	$('#tabelaTelefone').append(linha);
	
});

function removerTelefone(ref){
	ref.closest('tr').remove();
}
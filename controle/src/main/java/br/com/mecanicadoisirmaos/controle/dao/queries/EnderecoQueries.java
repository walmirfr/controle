package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface EnderecoQueries {

	public static final String QUERY_INSERIR_ENDERECO = new StringBuilder()
			.append("INSERT INTO ENDERECO ")
			.append("(CEP, RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF, ID_PESSOA) ")
			.append("VALUES ")
			.append("(:cep, :rua, :numero, :complemento, :bairro, :cidade, :uf, :idPessoa) ")
			.toString();
	
	public static final String QUERY_EXCLUIR_ENDERECO = new StringBuilder()
			.append("DELETE FROM ENDERECO ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
	
	public static final String QUERY_CONSULTAR_ENDERECO_POR_PESSOA = new StringBuilder()
			.append("SELECT E.ID_ENDERECO, E.CEP, E.RUA, E.NUMERO, E.COMPLEMENTO, E.BAIRRO, E.CIDADE, E.UF ")
			.append("FROM ENDERECO E ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
	
	public static final String QUERY_ALTERAR_ENDERECO = new StringBuilder()
			.append("UPDATE ENDERECO SET ")
			.append("CEP = :cep, ")
			.append("RUA = :rua, ")
			.append("NUMERO = :numero, ")
			.append("COMPLEMENTO = :complemento, ")
			.append("BAIRRO = :bairro, ")
			.append("CIDADE = :cidade, ")
			.append("UF = :uf ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
}
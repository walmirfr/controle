package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface PessoaQueries {

	public static final String QUERY_INSERIR_PESSOA = new StringBuilder()
			.append("INSERT INTO PESSOA ")
			.append("(EMAIL, TIPO_PESSOA, CNPJ, NOME_FANTASIA, RAZAO_SOCIAL) ")
			.append("VALUES ")
			.append("(:email, :tipoPessoa, :cnpj, :nomeFantasia, :razaoSocial) ")
			.toString();
	
	public static final String QUERY_INSERT_TELEFONE = new StringBuilder()
			.append("INSERT INTO TELEFONE ")
			.append("(ID_PESSOA, TELEFONE) ")
			.append("VALUES ")
			.append("(:idPessoa, :numero) ")
			.toString();
	
	public static final String QUERY_EXCLUIR_TELEFONE = new StringBuilder()
			.append("DELETE FROM TELEFONE ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
	
	public static final String QUERY_EXCLUIR_PESSOA = new StringBuilder()
			.append("DELETE FROM PESSOA ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
	
	
	public static final String QUERY_ATIVAR_DESATIVAR_PESSOA = new StringBuilder()
			.append("UPDATE PESSOA SET ")
			.append("ATIVO = :funcao ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
	
	public static final String QUERY_CONSULTAR_TELEFONE_POR_PESSOA = new StringBuilder()
			.append("SELECT TELEFONE ")
			.append("FROM TELEFONE ")
			.append("WHERE ID_PESSOA = :idPessoa")
			.toString();
	
	public static final String QUERY_ALTERAR_PESSOA = new StringBuilder()
			.append("UPDATE PESSOA SET ")
			.append("EMAIL = :email, ")
			.append("CNPJ = :cnpj, ")
			.append("NOME_FANTASIA = :nomeFantasia, ")
			.append("RAZAO_SOCIAL = :razaoSocial ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
}

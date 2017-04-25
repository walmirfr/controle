package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface PessoaQueries {

	public static final String QUERY_INSERIR_PESSOA = new StringBuilder()
			.append("INSERT INTO PESSOA ")
			.append("(EMAIL, LOGIN, SENHA, TIPO_PESSOA, CNPJ, NOME_FANTASIA, RAZAO_SOCIAL) ")
			.append("VALUES ")
			.append("(:email, :login, :senha, :tipoPessoa, :cnpj, :nomeFantasia, :razaoSocial) ")
			.toString();
}
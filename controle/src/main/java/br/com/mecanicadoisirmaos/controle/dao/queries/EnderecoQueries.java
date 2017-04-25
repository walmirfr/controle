package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface EnderecoQueries {

	public static final String QUERY_INSERIR_ENDERECO = new StringBuilder()
			.append("INSERT INTO ENDERECO ")
			.append("(CEP, RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF, ID_PESSOA) ")
			.append("VALUES ")
			.append("(:cep, :rua, :numero, :complemento, :bairro, :cidade, :uf, :idPessoa) ")
			.toString();
}
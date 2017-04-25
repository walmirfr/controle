package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface PessoaFisicaQueries {

	public static final String QUERY_INSERIR_PESSOA_FISICA = new StringBuilder()
			.append("INSERT INTO PESSOA_FISICA ")
			.append("(ID_PESSOA, TIPO_PESSOA_FISICA, NOME, CPF, DT_NASCIMENTO, SALARIO, ID_PESSOA_JUR) ")
			.append("VALUES ")
			.append("(:idPessoa, :tipoPessoaFisica, :nome, :cpf, :dtNascimento, :salario, :idPessoaJuridica) ")
			.toString();
}
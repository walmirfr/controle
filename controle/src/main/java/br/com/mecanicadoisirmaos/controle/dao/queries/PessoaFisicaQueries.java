package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface PessoaFisicaQueries {

	public static final String QUERY_INSERIR_PESSOA_FISICA = new StringBuilder()
			.append("INSERT INTO PESSOA_FISICA ")
			.append("(ID_PESSOA, TIPO_PESSOA_FISICA, NOME, CPF, DT_NASCIMENTO, SALARIO, ID_PESSOA_JUR) ")
			.append("VALUES ")
			.append("(:idPessoa, :tipoPessoaFisica, :nome, :cpf, :dtNascimento, :salario, :idPessoaJuridica) ")
			.toString();
	
	public static final String QUERY_LISTAR_PESSOAS_POR_TIPO = new StringBuilder()
			.append("SELECT P.ID_PESSOA, PF.NOME, P.EMAIL, T.TELEFONE ")
			.append("FROM PESSOA P ")
			.append("INNER JOIN PESSOA_FISICA PF ON P.ID_PESSOA = PF.ID_PESSOA ")
			.append("INNER JOIN TELEFONE T ON P.ID_PESSOA = T.ID_PESSOA ")
			.append("WHERE PF.TIPO_PESSOA_FISICA = :tipo ")
			.toString();
}
package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface PessoaFisicaQueries {

	public static final String QUERY_INSERIR_PESSOA_FISICA = new StringBuilder()
			.append("INSERT INTO PESSOA_FISICA ")
			.append("(ID_PESSOA, TIPO_PESSOA_FISICA, NOME, CPF, SEXO, DT_NASCIMENTO, SALARIO, ID_PESSOA_JUR) ")
			.append("VALUES ")
			.append("(:idPessoa, :tipoPessoaFisica, :nome, :cpf, :sexo, :dtNascimento, :salario, :idPessoaJuridica) ")
			.toString();
	
	public static final String QUERY_LISTAR_PESSOAS_POR_TIPO = new StringBuilder()
			.append("SELECT P.ID_PESSOA, PF.NOME, P.ATIVO, P.EMAIL ")
			.append(", (SELECT COUNT(*) FROM VEICULO WHERE ID_PESSOA = P.ID_PESSOA) AS VINCULO ")
			.append("FROM PESSOA P ")
			.append("INNER JOIN PESSOA_FISICA PF ON P.ID_PESSOA = PF.ID_PESSOA ")
			.append("WHERE PF.TIPO_PESSOA_FISICA = :tipo ")
			.toString();
	
	public static final String QUERY_EXCLUIR_PESSOA_FISICA = new StringBuilder()
			.append("DELETE FROM PESSOA_FISICA ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
	
	public static final String QUERY_CONSULTAR_PESSOA_FISICA_POR_ID = new StringBuilder()
			.append("SELECT P.ID_PESSOA, P.EMAIL, P.ATIVO ")
			.append(", PF.NOME, PF.CPF, PF.DT_NASCIMENTO, PF.SEXO, PF.SALARIO ")
			.append("FROM PESSOA_FISICA PF ")
			.append("INNER JOIN PESSOA P ON P.ID_PESSOA = PF.ID_PESSOA ")
			.append("WHERE P.ID_PESSOA = :idPessoa ")
			.toString();
	
	public static final String QUERY_CONSULTAR_PESSOA_FISICA_CADASTRADA = new StringBuilder()
			.append("SELECT COUNT(*) AS QNT ")
			.append("FROM PESSOA_FISICA PF ")
			.append("INNER JOIN PESSOA P ON P.ID_PESSOA = PF.ID_PESSOA ")
			.append("WHERE PF.NOME = :nome ")
			.append("AND TIPO_PESSOA_FISICA = :tipoPessoaFisica ")
			.append("AND P.TIPO_PESSOA = 'F' ")
			.toString();
	
	public static final String QUERY_ALTERAR_PESSOA_FISICA = new StringBuilder()
			.append("UPDATE PESSOA_FISICA SET ")
			.append("NOME = :nome, ")
			.append("CPF = :cpf , ")
			.append("DT_NASCIMENTO = :dtNascimento, ")
			.append("SEXO = :sexo, ")
			.append("SALARIO = :salario ")
			.append("WHERE ID_PESSOA = :idPessoa ")
			.toString();
	
	public static final String QUERY_CONSULTAR_FUNCIONARIO_POR_EMPRESA = new StringBuilder()
			.append("SELECT P.ID_PESSOA, P.EMAIL ")
			.append(", PF.NOME, PF.CPF, PF.DT_NASCIMENTO, PF.SEXO ")
			.append("FROM PESSOA_FISICA PF ")
			.append("INNER JOIN PESSOA P ON P.ID_PESSOA = PF.ID_PESSOA ")
			.append("WHERE P.ID_PESSOA_JUR = :idPessoa ")
			.toString();
}
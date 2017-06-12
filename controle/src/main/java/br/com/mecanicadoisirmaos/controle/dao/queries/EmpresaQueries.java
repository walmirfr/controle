package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface EmpresaQueries {

	public static final String QUERY_LISTAR_EMPRESAS = new StringBuilder()
			.append("SELECT P.ID_PESSOA, P.EMAIL, P.ATIVO, P.NOME_FANTASIA ")
			.append(", (SELECT COUNT(*) FROM VEICULO V WHERE V.ID_PESSOA = P.ID_PESSOA) AS VINCULO ")
			.append("FROM PESSOA P ")
			.append("WHERE P.TIPO_PESSOA = 'J' ")
			.toString();
	
	public static final String QUERY_CONSULTAR_EMPRESA_POR_ID = new StringBuilder()
			.append("SELECT P.ID_PESSOA, P.EMAIL, P.ATIVO, P.CNPJ, P.NOME_FANTASIA, P.RAZAO_SOCIAL ")
			.append("FROM PESSOA P ")
			.toString();
	
	public static final String QUERY_CONSULTAR_EMPRESA_CADASTRADA = new StringBuilder()
			.append("SELECT COUNT(*) AS QNT ")
			.append("FROM PESSOA ")
			.append("WHERE NOME_FANTASIA = :nomeFantasia ")
			.append("AND TIPO_PESSOA = 'J' ")
			.toString();
	
	public static final String QUERY_INSERIR_EMPRESA = new StringBuilder()
			.append("INSERT INTO PESSOA ")
			.append("(EMAIL, NOME_FANTASIA, CNPJ, RAZAO_SOCIAL, TIPO_PESSOA) ")
			.append("VALUES ")
			.append("(:email, :nomeFantasia, :cnpj, :razaoSocial, :tipoPessoa ) ")
			.toString();
	
	public static final String QUERY_EXCLUIR_FUNCIONARIO_POR_EMPRESA = new StringBuilder()
			.append("DELETE FROM PESSOA_FISICA ")
			.append("WHERE ID_PESSOA_JUR = :idPessoa ")
			.toString();

	public static final String QUERY_ALTERAR_EMPRESA = new StringBuilder()
			.append("UPDATE PESSOA ")
			.append("EMAIL = :email ")
			.append("NOME_FANTASIA = :nomeFantasia ")
			.append("RAZAO_SOCIAL = :razaoSocial ")
			.append("CNPJ = :social ")
			.append("WHERE ID_PESSOA = :idPessoa")
			.toString();
	
}

package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface GrupoServicoQueries {

	public static final String QUERY_INSERIR_GRUPO_SERVICO = new StringBuilder()
			.append("INSERT INTO GRUPO_SERVICO ")
			.append("(NOME_GRUPO_SERVICO) ")
			.append("VALUES  ")
			.append("(:nome) ")
			.toString();
		
	public static final String QUERY_LISTAR_GRUPO_SERVICOS = new StringBuilder()
			.append("SELECT ID_GRUPO_SERVICO, NOME_GRUPO_SERVICO ")
			.append("FROM GRUPO_SERVICO ")
			.toString();
	
	public static final String QUERY_EXCLUIR_GRUPO_SERVICO_ID = new StringBuilder()
			.append("DELETE FROM GRUPO_SERVICO ")
			.append("WHERE ID_GRUPO_SERVICO = :idGrupoServico ")
			.toString();
	
	public static final String QUERY_ALTERAR_GRUPO_SERVICO_ID = new StringBuilder()
			.append("UPDATE GRUPO_SERVICO SET ")
			.append("NOME_GRUPO_SERVICO = :nome ")
			.append("WHERE ID_GRUPO_SERVICO = :idGrupoServico ")
			.toString();
}
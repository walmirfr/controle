/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.dao.queries;

/**
 * @author walmi
 *
 */
public interface ServicoQueries {

	public static final String QUERY_INSERIR_SERVICO = new StringBuilder()
			.append("INSERT INTO SERVICO ")
			.append("(NOME_SERVICO, DESCRICAO, TEMPO_ESTIMADO, ID_GRUPO_SERVICO) ")
			.append("VALUES ")
			.append("(:nome, :descricao, :tempoEstimado, :idGrupoServico) ")
			.toString();
	
	public static final String QUERY_CONSULTAR_SERVICO_ID = new StringBuilder()
			.append("SELECT SERV.ID_SERVICO, SERV.NOME_SERVICO, SERV.DESCRICAO, SERV.TEMPO_ESTIMADO, SERV.ATIVO, GRUP.ID_GRUPO_SERVICO, GRUP.NOME_GRUPO_SERVICO ")
			.append("FROM SERVICO SERV " )
			.append("INNER JOIN GRUPO_SERVICO GRUP ON GRUP.ID_GRUPO_SERVICO = SERV.ID_GRUPO_SERVICO " )
			.append("WHERE SERV.ID_SERVICO = :idServico " )
			.toString();
	
	public static final String QUERY_LISTAR_SERVICOS = new StringBuilder()
			.append("SELECT SERV.ID_SERVICO, SERV.NOME_SERVICO, SERV.ATIVO, GRUP.NOME_GRUPO_SERVICO ")
			.append("FROM SERVICO SERV " )
			.append("INNER JOIN GRUPO_SERVICO GRUP ON GRUP.ID_GRUPO_SERVICO = SERV.ID_GRUPO_SERVICO ")
			.append("ORDER BY SERV.NOME_SERVICO ")
			.toString();
	
	public static final String QUERY_LISTAR_SERVICOS_POR_MANUTENCAO = new StringBuilder()
			.toString();
	
	public static final String QUERY_EXCLUIR_SERVICO_ID = new StringBuilder()
			.append("DELETE FROM SERVICO ")
			.append("WHERE ID_SERVICO = :idServico")
			.toString();
	
	public static final String QUERY_ALTERAR_SERVICO_ID = new StringBuilder()
			.append("UPDATE SERVICO SET ")
			.append("NOME_SERVICO = :nome ,")
			.append("DESCRICAO = :descricao ,")
			.append("TEMPO_ESTIMADO = :tempoEstimado ,")
			.append("ID_GRUPO_SERVICO = :idGrupoServico ")
			.append("WHERE ID_SERVICO = :idServico ")
			.toString();
}
package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface ManutencaoQueries {

	public static final String QUERY_INSERIR_MANUTENCAO = new StringBuilder()
			.append("INSERT INTO MANUTENCAO ")
			.append("(ID_VEICULO, ID_PESSOA, DATA_ENTRADA, DATA_SAIDA, KM, OBSERVACAO) ")
			.append("VALUES ")
			.append("((SELECT ID_VEICULO FROM VEICULO WHERE PLACA = :placa), :idPessoa, :dataEntrada, :dataSaida, :km, :observacao) ")
			.toString();
	
	public static final String QUERY_INSERIR_SERVICO_MANUTENCAO = new StringBuilder()
			.append("INSERT INTO SERVICO_MANUTENCAO ")
			.append("(ID_SERVICO, ID_MANUTENCAO, PRECO) ")
			.append("VALUES ")
			.append("(:idServico, :idManutencao, :preco) ")
			.toString();
	
	public static final String QUERY_INSERIR_PROFISSIONAL_MANUTENCAO = new StringBuilder()
			.append("INSERT INTO MECANICO_MANUTENCAO ")
			.append("(ID_PESSOA, ID_MANUTENCAO) ")
			.append("VALUES ")
			.append("(:idPessoa, :idManutencao) ")
			.toString();
	
	public static final String QUERY_LISTAR_MANUTENCOES = new StringBuilder()
			.append("SELECT M.ID_MANUTENCAO, MO.NOME_MODELO, V.PLACA, PF.NOME, M.DATA_ENTRADA, M.DATA_SAIDA ")
			.append("FROM MANUTENCAO M ")
			.append("INNER JOIN VEICULO V ON V.ID_VEICULO = M.ID_VEICULO ")
			.append("INNER JOIN MODELO MO ON MO.ID_MODELO = V.ID_MODELO ")
			.append("INNER JOIN PESSOA_FISICA PF ON PF.ID_PESSOA = M.ID_PESSOA ")
			.toString();
	
	public static final String QUERY_CONSULTAR_QUANTIDADE_MANUTENCOES = new StringBuilder()
			.append("SELECT COUNT(*) AS QNT ")
			.append("FROM MANUTENCAO ")
			.toString();
}
package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface ModeloQueries {

	public static final String QUERY_INSERIR_MODELO = new StringBuilder()
			.append("INSERT INTO MODELO ")
			.append("(NOME_MODELO, ID_MARCA) ")
			.append("VALUES ")
			.append("(:nome, :idMarca) ")
			.toString();
	
	public static final String QUERY_LISTAR_MODELOS = new StringBuilder()
			.append("SELECT ID_MODELO, NOME_MODELO ")
			.append("FROM MODELO ")
			.append("WHERE ID_MARCA = :idMarca ")
			.toString();
}
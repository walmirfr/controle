package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface MarcaQueries {

	public static final String QUERY_INSERIR_MARCA = new StringBuilder()
			.append("INSERT INTO MARCA ")
			.append("(NOME_MARCA) ")
			.append("VALUES ")
			.append("(:nome) ")
			.toString();
	
	public static final String QUERY_LISTAR_MARCAS = new StringBuilder()
			.append("SELECT ID_MARCA, NOME_MARCA ")
			.append("FROM MARCA ")
			.toString();
}

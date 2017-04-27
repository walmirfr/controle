package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface ClienteQueries {

	public static final String QUERY_LISTAR_CLIENTES = new StringBuilder()
			.append("SELECT P.ID_PESSOA, PF.NOME, P.EMAIL, T.TELEFONE ")
			.append("FROM PESSOA P ")
			.append("INNER JOIN PESSOA_FISICA PF ON P.ID_PESSOA = PF.ID_PESSOA ")
			.append("INNER JOIN TELEFONE T ON P.ID_PESSOA = T.ID_PESSOA ")
			.append("WHERE PF.TIPO_PESSOA_FISICA = 'C' ")
			.toString();
}
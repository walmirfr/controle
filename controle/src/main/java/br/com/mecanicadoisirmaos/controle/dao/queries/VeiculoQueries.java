package br.com.mecanicadoisirmaos.controle.dao.queries;

public interface VeiculoQueries {

	public static final String QUERY_INSERIR_VEICULO = new StringBuilder()
			.append("INSERT INTO VEICULO ")
			.append("(ANO, COR, PLACA, OBSERVACAO, ID_MODELO, ID_PESSOA) ")
			.append("VALUES ")
			.append("(:ano, :cor, :placa, :observacao, :idModelo, :idPessoa) ")
			.toString();
	
	public static final String QUERY_LISTAR_VEICULO = new StringBuilder()
			.append("SELECT V.ID_VEICULO, V.PLACA, MA.NOME_MARCA, MO.NOME_MODELO, PF.NOME ")
			.append("FROM VEICULO V ")
			.append("INNER JOIN MODELO MO ON MO.ID_MODELO = V.ID_MODELO ")
			.append("INNER JOIN MARCA MA ON MA.ID_MARCA = MO.ID_MARCA ")
			.append("INNER JOIN PESSOA_FISICA PF ON PF.ID_PESSOA = V.ID_PESSOA ")
			.toString();	
}
package br.com.mecanicadoisirmaos.controle.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.EnderecoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.EnderecoQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.EnderecoVo;

public class EnderecoDaoImpl extends AbstractDao implements EnderecoDao, EnderecoQueries {

	private static final Logger LOGGER = Logger.getLogger(EnderecoDaoImpl.class);
	
	public Integer inserirEndereco(EnderecoVo endereco) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_ENDERECO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.CEP, endereco.getCep());
		parans.addValue(Constants.RUA, endereco.getRua());
		parans.addValue(Constants.NUMERO, endereco.getNumero());
		parans.addValue(Constants.COMPLEMENTO, endereco.getComplemento());
		parans.addValue(Constants.BAIRRO, endereco.getBairro());
		parans.addValue(Constants.CIDADE, endereco.getCidade());
		parans.addValue(Constants.UF, endereco.getUf());
		parans.addValue(Constants.IDPESSOA, endereco.getPessoa().getIdPessoa());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na Inclusão da Entidade Endereco: " + d);
			throw d;
		}
	}
}
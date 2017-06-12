package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.EnderecoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.EnderecoQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.EnderecoVo;

@Repository
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

	public Integer excluirEndereco(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_EXCLUIR_ENDERECO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public EnderecoVo consultarEnderecoPorPessoa(Integer idPessoa) throws DatabindingException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_ENDERECO_POR_PESSOA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		
		try{
			return getJdbc().queryForObject(sql.toString(), parans, new EnderecoRowMapper());
		}catch(DataAccessException d){
			throw d;
		}
	}

	public Integer alterarEndereco(EnderecoVo endereco) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_ALTERAR_ENDERECO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, endereco.getPessoa().getIdPessoa());
		parans.addValue(Constants.CEP , endereco.getCep());
		parans.addValue(Constants.RUA , endereco.getRua());
		parans.addValue(Constants.NUMERO , endereco.getNumero());
		parans.addValue(Constants.COMPLEMENTO , endereco.getComplemento());
		parans.addValue(Constants.BAIRRO , endereco.getBairro());
		parans.addValue(Constants.CIDADE , endereco.getCidade());
		parans.addValue(Constants.UF , endereco.getUf());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}
	
	public static class EnderecoRowMapper implements RowMapper<EnderecoVo>{
		public EnderecoVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EnderecoVo end = new EnderecoVo();
			end.setIdEndereco(rs.getInt("ID_ENDERECO"));
			end.setCep(rs.getString("CEP"));
			end.setRua(rs.getString("RUA"));
			end.setNumero(rs.getInt("NUMERO"));
			end.setComplemento(rs.getString("COMPLEMENTO"));
			end.setBairro(rs.getString("BAIRRO"));
			end.setCidade(rs.getString("CIDADE"));
			end.setUf(rs.getString("UF"));
			
			return end;
		}
		
	}
	
}
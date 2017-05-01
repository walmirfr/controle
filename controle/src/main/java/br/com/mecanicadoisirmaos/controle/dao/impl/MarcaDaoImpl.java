package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.MarcaDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.MarcaQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.MarcaVo;
@Repository
public class MarcaDaoImpl extends AbstractDao implements MarcaDao, MarcaQueries{

	public Logger LOGGER = Logger.getLogger(MarcaDaoImpl.class);
	
	public Integer inserirMarca(MarcaVo marca) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_MARCA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME, marca.getNome());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			LOGGER.error("Erro ao inserir na Entidade Marca: " + d);
			throw d;
		}
	}

	public List<MarcaVo> listarMarcas() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_MARCAS);
		
		try{
			return getJdbc().query(sql.toString(), new MarcaRowMapper());
		}catch (DataAccessException d){
			LOGGER.error("Erro ao listar as Marcas: "+ d);
			throw d;
		}
	}
	
	public static class MarcaRowMapper implements RowMapper<MarcaVo>{

		public MarcaVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			MarcaVo marca = new MarcaVo();
			
			marca.setIdMarca(rs.getInt("ID_MARCA"));
			marca.setNome(rs.getString("NOME_MARCA"));
			
			return marca;
		}
	}
}
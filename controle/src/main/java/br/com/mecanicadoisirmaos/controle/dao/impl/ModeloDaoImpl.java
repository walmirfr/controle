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
import br.com.mecanicadoisirmaos.controle.dao.ModeloDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.ModeloQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.ModeloVo;
@Repository
public class ModeloDaoImpl extends AbstractDao implements ModeloDao, ModeloQueries {

	private Logger LOGGER = Logger.getLogger(ModeloDaoImpl.class);
	
	public Integer inserirModelo(ModeloVo modelo) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_MODELO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME, modelo.getNome());
		parans.addValue(Constants.IDMARCA, modelo.getMarca().getIdMarca());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro ao inserir na Entidade Modelo: " + d);
			throw d;
		}
	}

	public List<ModeloVo> listarModelosPorIdMarca(Integer idMarca) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_MODELOS);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDMARCA, idMarca);
		try{
			return getJdbc().query(sql.toString(), parans, new ModeloRowMapper());
		}catch(DataAccessException d){
			LOGGER.error("Erro ao listar Modelos por Marca: " + d);
			throw d;
		}
	}
	
	public static class ModeloRowMapper implements RowMapper<ModeloVo>{
		public ModeloVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			ModeloVo modelo = new ModeloVo();
			modelo.setIdModelo(rs.getInt("ID_MODELO"));
			modelo.setNome(rs.getString("NOME_MODELO"));
			
			return modelo;
		}
	}

}

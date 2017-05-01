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
import br.com.mecanicadoisirmaos.controle.dao.VeiculoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.VeiculoQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.MarcaVo;
import br.com.mecanicadoisirmaos.controle.vo.ModeloVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.VeiculoVo;

@Repository
public class VeiculoDaoImpl extends AbstractDao implements VeiculoDao, VeiculoQueries{

	private Logger LOGGER = Logger.getLogger(VeiculoDaoImpl.class);
	
	public Integer inserirVeiculo(VeiculoVo veiculo) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_VEICULO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.ANO, veiculo.getAno());
		parans.addValue(Constants.COR, veiculo.getCor());
		parans.addValue(Constants.PLACA, veiculo.getPlaca());
		parans.addValue(Constants.OBSERVACAO, veiculo.getObservacao());
		parans.addValue(Constants.IDMODELO, veiculo.getModelo().getIdModelo());
		parans.addValue(Constants.IDPESSOA, veiculo.getProprietario().getIdPessoa());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro ao inserir na Entidade Veiculo: " + d);
			throw d;
		}
	}

	public List<VeiculoVo> listarVeiculos() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_VEICULO);
		
		try{
			return getJdbc().query(sql.toString(), new VeiculoPartRowMapper());
		}catch (DataAccessException d){
			LOGGER.error("Erro ao Listar Todos os Veiculos: " + d);
			throw d;
		}
	}

	public static class VeiculoPartRowMapper implements RowMapper<VeiculoVo>{
		public VeiculoVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			VeiculoVo veiculo = new VeiculoVo();
			veiculo.setIdVeiculo(rs.getInt("ID_VEICULO"));
			veiculo.setPlaca(rs.getString("PLACA"));
			
			PessoaFisicaVo pf = new PessoaFisicaVo();
			pf.setNome(rs.getString("NOME"));
			veiculo.setProprietario(pf);
			
			ModeloVo modelo = new ModeloVo();
			modelo.setNome(rs.getString("NOME_MODELO"));
			veiculo.setModelo(modelo);
			
			MarcaVo marca = new MarcaVo();
			marca.setNome(rs.getString("NOME_MARCA"));
			veiculo.setMarca(marca);
			
			return veiculo;
		}
	}
}
package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.ManutencaoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.ManutencaoQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;
import br.com.mecanicadoisirmaos.controle.vo.ModeloVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;
import br.com.mecanicadoisirmaos.controle.vo.VeiculoVo;

@Repository
public class ManutencaoDaoImpl extends AbstractDao implements ManutencaoDao, ManutencaoQueries {

	public Logger LOGGER = Logger.getLogger(ManutencaoDaoImpl.class);
	
	public Integer inserirManutencao(ManutencaoVo manutencao) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_MANUTENCAO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.PLACA, manutencao.getVeiculo().getPlaca());
		parans.addValue(Constants.IDPESSOA, manutencao.getProprietario().getIdPessoa());
		parans.addValue(Constants.DATAENTRADA, manutencao.getDtEntrada());
		parans.addValue(Constants.DATASAIDA, manutencao.getDtSaida());
		parans.addValue(Constants.KM, manutencao.getKm());
		parans.addValue(Constants.OBSERVACAO, manutencao.getObservacao());
		
		try{
			KeyHolder keyHolder = new GeneratedKeyHolder();
			getJdbc().update(sql.toString(), parans, keyHolder);
			return (Integer) keyHolder.getKeys().get("ID_MANUTENCAO");
		}catch(DataAccessException d){
			LOGGER.error("Erro ao inserir na Entidade Manutencao: " + d);
			throw d;
		}
	}

	public Integer inserirServicoManutencao(ServicoVo servico, Integer idManutencao) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_SERVICO_MANUTENCAO);
		MapSqlParameterSource parans = new MapSqlParameterSource();

		parans.addValue(Constants.IDSERVICO, servico.getIdServico());
		parans.addValue(Constants.PRECO, servico.getPreco());
		parans.addValue(Constants.IDMANUTENCAO, idManutencao);
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			LOGGER.error("Erro ao inserir na Entidade Servico Manutencao: " + d);
			throw d;
		}
	}

	public Integer inserirProfissionalManutencao(ProfissionalVo profissional, Integer idManutencao)
			throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_PROFISSIONAL_MANUTENCAO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, profissional.getIdPessoa());
		parans.addValue(Constants.IDMANUTENCAO, idManutencao);
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			LOGGER.error("Erro ao inserir na Entidade Profissional Manutencao: " + d);
			throw d;
		}
	}

	public List<ManutencaoVo> listarManutencoes() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_MANUTENCOES);
		
		try{
			return getJdbc().query(sql.toString(), new ManutencaoRowMapper());
		}catch(DataAccessException d){
			LOGGER.error("" + d);
			throw d;
		}
	}
	
	public static class ManutencaoRowMapper implements RowMapper<ManutencaoVo>{
		public ManutencaoVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ManutencaoVo manutencao = new ManutencaoVo();
			manutencao.setIdManutencao(rs.getInt("ID_MANUTENCAO"));
			manutencao.setDtEntrada(rs.getDate("DATA_ENTRADA"));
			manutencao.setDtSaida(rs.getDate("DATA_SAIDA"));
			
			VeiculoVo veiculo = new VeiculoVo();
			veiculo.setPlaca(rs.getString("PLACA"));
			
			ModeloVo modelo = new ModeloVo();
			modelo.setNome(rs.getString("NOME_MODELO"));
			veiculo.setModelo(modelo);
			
			manutencao.setVeiculo(veiculo);
			
			PessoaFisicaVo proprietario = new PessoaFisicaVo();
			proprietario.setNome(rs.getString("NOME"));
			manutencao.setProprietario(proprietario);
			
			return manutencao;
		}
	}

	public Integer consultarQuantidadeManutencoesCadastradas() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_QUANTIDADE_MANUTENCOES);
		try{
			return getJdbc().queryForObject(sql.toString(), new MapSqlParameterSource(), Integer.class);
		}catch(DataAccessException d){
			throw d;
		}
	}
}
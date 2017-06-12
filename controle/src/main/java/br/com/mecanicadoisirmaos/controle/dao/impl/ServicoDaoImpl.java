/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.ServicoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.ServicoQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;
import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

/**
 * @author walmi
 *
 */
@Repository
public class ServicoDaoImpl extends AbstractDao implements ServicoDao, ServicoQueries{
	
	public Integer inserirServico(ServicoVo servico) {
		String sql = QUERY_INSERIR_SERVICO;
		
		MapSqlParameterSource parans = new MapSqlParameterSource();
		parans.addValue(Constants.NOME, servico.getNome());
		parans.addValue(Constants.DESCRICAO, servico.getDescricao());
		parans.addValue(Constants.TEMPOESTIMADO, servico.getTempoEstimado());
		parans.addValue(Constants.IDGRUPOSERVICO, servico.getGrupoServico().getIdGrupoServico());
		
		return getJdbc().update(sql, parans);
	}

	public ServicoVo consultarServicoPorId(Integer idServico) {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_SERVICO_ID);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		parans.addValue(Constants.IDSERVICO, idServico);
		
		return getJdbc().queryForObject(sql.toString(), parans, new ServicoRowMapper());
	}

	public List<ServicoVo> listarServicos(ServicoVo servico) {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_SERVICOS);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		if(servico != null){
			sql.append("WHERE NOME_SERVICO LIKE :nome ");
			parans.addValue(Constants.NOME, "%"+servico.getNome()+"%");
		}
		sql.append("ORDER BY SERV.NOME_SERVICO ");
		
		try{
			return getJdbc().query(sql.toString(), parans, new ServicoListaRowMapper());
		}catch(DataAccessException d){
			throw d;
		}
	}

	public Integer alterarServico(ServicoVo servico) {
		String sql = QUERY_ALTERAR_SERVICO_ID;
		
		MapSqlParameterSource parans = new MapSqlParameterSource();
		parans.addValue(Constants.IDSERVICO, servico.getIdServico());
		parans.addValue(Constants.NOME, servico.getNome());
		parans.addValue(Constants.DESCRICAO, servico.getDescricao());
		parans.addValue(Constants.TEMPOESTIMADO, servico.getTempoEstimado());
		parans.addValue(Constants.IDGRUPOSERVICO, servico.getGrupoServico().getIdGrupoServico());
		
		return getJdbc().update(sql, parans);
	}

	public Integer deletarServicoPorId(Integer idServico) {
		String sql = QUERY_EXCLUIR_SERVICO_ID;
		
		MapSqlParameterSource parans = new MapSqlParameterSource();
		parans.addValue(Constants.IDSERVICO, idServico);
		
		return getJdbc().update(sql, parans);
	}
	
	public Integer ativarDesativarServico(ServicoVo servico) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_ATIVAR_DESATIVAR_SERVICO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.FUNCAO, Util.getAtivo(servico.getAtivo()));
		parans.addValue(Constants.IDSERVICO, servico.getIdServico());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}
	
	public static class ServicoListaRowMapper implements RowMapper<ServicoVo>
	{
		public ServicoVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ServicoVo servico = new ServicoVo();
			servico.setIdServico(rs.getInt("ID_SERVICO"));
			servico.setNome(rs.getString("NOME_SERVICO"));
			servico.setAtivo(Util.getAtivo(rs.getString("ATIVO")));
			servico.setVinculo(Util.getVinculo(rs.getInt("VINCULO")));
			GrupoServicoVo grupo = new GrupoServicoVo();
			grupo.setNome(rs.getString("NOME_GRUPO_SERVICO"));
			servico.setGrupoServico(grupo);
			return servico;
		}
	}
	public static class ServicoRowMapper implements RowMapper<ServicoVo>
	{
		public ServicoVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			ServicoVo servico = new ServicoVo();
			servico.setIdServico(rs.getInt("ID_SERVICO"));
			servico.setNome(rs.getString("NOME_SERVICO"));
			servico.setDescricao(rs.getString("DESCRICAO"));
			servico.setTempoEstimado(rs.getInt("TEMPO_ESTIMADO"));
			servico.setAtivo(Util.getAtivo(rs.getString("ATIVO")));
			
			GrupoServicoVo grupo = new GrupoServicoVo();
			grupo.setIdGrupoServico(rs.getInt("ID_GRUPO_SERVICO"));
			grupo.setNome(rs.getString("NOME_GRUPO_SERVICO"));
			
			servico.setGrupoServico(grupo);
			
			return servico;
		}
	}
	public List<ServicoVo> listarServicos(ManutencaoVo manutencao) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer consultarQuantidadeServicosCadastrados() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_QUANTIDADE_SERVICOS);
		try{
			return getJdbc().queryForObject(sql.toString(), new MapSqlParameterSource(), Integer.class);
		}catch(DataAccessException d){
			throw d;
		}
	}
}

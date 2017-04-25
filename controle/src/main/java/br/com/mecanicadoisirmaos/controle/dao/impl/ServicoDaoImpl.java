/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.ServicoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.ServicoQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;
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

	public List<ServicoVo> listarServicos() {
		String sql = QUERY_LISTAR_SERVICOS;
		return getJdbc().query(sql, new ServicoListaRowMapper());
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
	
	public static class ServicoListaRowMapper implements RowMapper<ServicoVo>
	{
		public ServicoVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ServicoVo servico = new ServicoVo();
			servico.setIdServico(rs.getInt("ID_SERVICO"));
			servico.setNome(rs.getString("NOME_SERVICO"));
			servico.setAtivo(Util.getAtivo(rs.getString("ATIVO")));
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
}

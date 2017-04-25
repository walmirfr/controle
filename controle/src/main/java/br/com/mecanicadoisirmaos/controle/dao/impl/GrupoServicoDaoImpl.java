package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.GrupoServicoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.GrupoServicoQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;

@Repository
public class GrupoServicoDaoImpl extends AbstractDao implements GrupoServicoDao, GrupoServicoQueries {

	public Integer cadastrarGrupoServico(GrupoServicoVo grupoServicoVo) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_GRUPO_SERVICO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME, grupoServicoVo.getNome());
		
		return getJdbc().update(sql.toString(), parans);
	}

	public Integer alterarGrupoServico(GrupoServicoVo grupoServicoVo) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_ALTERAR_GRUPO_SERVICO_ID);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME, grupoServicoVo.getNome());
		
		return getJdbc().update(sql.toString(), parans);
	}

	public List<GrupoServicoVo> listarGrupoServico() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_GRUPO_SERVICOS);
		
		return getJdbc().query(sql.toString(), new GrupoServicoRowMapper());
	}

	public Integer deletarGrupoServico(Integer idGrupoServico) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_ALTERAR_GRUPO_SERVICO_ID);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDGRUPOSERVICO, idGrupoServico);
		
		return getJdbc().update(sql.toString(), parans);

	}

	public static class GrupoServicoRowMapper implements RowMapper<GrupoServicoVo>
	{
		public GrupoServicoVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			GrupoServicoVo grupo = new GrupoServicoVo();
			grupo.setIdGrupoServico(rs.getInt("ID_GRUPO_SERVICO"));
			grupo.setNome(rs.getString("NOME_GRUPO_SERVICO"));

			return grupo;
		}
	}
}

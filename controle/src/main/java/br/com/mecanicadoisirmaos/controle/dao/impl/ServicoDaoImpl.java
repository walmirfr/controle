/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.dao.impl;

import static br.com.mecanicadoisirmaos.controle.util.Constantes.ATIVO;
import static br.com.mecanicadoisirmaos.controle.util.Constantes.DESCRICAO;
import static br.com.mecanicadoisirmaos.controle.util.Constantes.IDGRUPOSERVICO;
import static br.com.mecanicadoisirmaos.controle.util.Constantes.NOME;
import static br.com.mecanicadoisirmaos.controle.util.Constantes.TEMPOESTIMADO;
import static br.com.mecanicadoisirmaos.controle.util.Util.getAtivo;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.ServicoDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.ServicoQueries;
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
		parans.addValue(NOME, servico.getNome());
		parans.addValue(DESCRICAO, servico.getDescricao());
		parans.addValue(TEMPOESTIMADO, servico.getTempoEstivamo());
		parans.addValue(IDGRUPOSERVICO, servico.getGrupoServico().getIdGrupoServico());
		
		return getJdbc().update(sql, parans);
	}

	public ServicoVo consultarServicoPorId(Integer idServico) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ServicoVo> listarServicos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer alterarServico(ServicoVo servico) {
		String sql = QUERY_ALTERAR_SERVICO_ID;
		
		MapSqlParameterSource parans = new MapSqlParameterSource();
		parans.addValue(NOME, servico.getNome());
		parans.addValue(DESCRICAO, servico.getDescricao());
		parans.addValue(TEMPOESTIMADO, servico.getTempoEstivamo());
		parans.addValue(IDGRUPOSERVICO, servico.getGrupoServico().getIdGrupoServico());
		parans.addValue(ATIVO, getAtivo(servico.getAtivo()));
		
		return getJdbc().update(sql, parans);
	}

	public Integer deletarServicoPorId(Integer idServico) {
		String sql = QUERY_EXCLUIR_SERVICO_ID;
		
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		return null;
	}
}

/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

/**
 * @author walmi
 *
 */
public interface ServicoDao {

	public Integer inserirServico(ServicoVo servico);
	
	public ServicoVo consultarServicoPorId(Integer idServico);
	
	public List<ServicoVo> listarServicos(ServicoVo servico);
	
	public List<ServicoVo> listarServicos(ManutencaoVo manutencao);
	
	public Integer alterarServico(ServicoVo servico);
	
	public Integer deletarServicoPorId(Integer idServico);
	
	public Integer ativarDesativarServico(ServicoVo servico) throws DataAccessException;
	
	public Integer consultarQuantidadeServicosCadastrados() throws DataAccessException;
}
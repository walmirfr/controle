/**
 * 
 */
package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

/**
 * @author walmi
 *
 */
public interface ServicoDao {

	public Integer inserirServico(ServicoVo servico);
	
	public ServicoVo consultarServicoPorId(Integer idServico);
	
	public List<ServicoVo> listarServicos();
	
	public List<ServicoVo> listarServicos(ManutencaoVo manutencao);
	
	public Integer alterarServico(ServicoVo servico);
	
	public Integer deletarServicoPorId(Integer idServico);
}
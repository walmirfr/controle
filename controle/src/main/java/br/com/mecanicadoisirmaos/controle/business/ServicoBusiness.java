package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

public interface ServicoBusiness {

	public Boolean inserirServico(ServicoVo servico);
	
	public Boolean alterarServico(ServicoVo servico);
	
	public List<ServicoVo> listarServicos(ServicoVo servico);

	public void deletarServico(ServicoVo servico);
	
	public ServicoVo consultarServicoPorId(Integer idServico);
	
	public Boolean ativarDesativarServico(ServicoVo servico, String funcao) throws Exception;
	
	public Integer consultarQuantidadeServicosCadastrados() throws Exception;
}
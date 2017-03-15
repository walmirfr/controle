package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

public interface ServicoBusiness {

	public Boolean inserirServico(ServicoVo servico);
	
	public List<ServicoVo> listarServicos();

	public void deletarServico(ServicoVo servico);
}
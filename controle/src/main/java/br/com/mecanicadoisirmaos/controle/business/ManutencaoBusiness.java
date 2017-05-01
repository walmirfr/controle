package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;

public interface ManutencaoBusiness {

	public Boolean inserirManutencao(ManutencaoVo manutencao) throws Exception;
	
	public List<ManutencaoVo> listarManutencoes() throws Exception;
}
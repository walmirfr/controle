package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;

public interface GrupoServicoBusiness {

	public List<GrupoServicoVo> listarGrupoServico();
	
	public Boolean cadastrarGrupoServico(GrupoServicoVo grupoServicoVo);
}
package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.ModeloVo;

public interface ModeloBusiness {

	public Boolean inserirModelo(ModeloVo modelo) throws Exception;
	
	public List<ModeloVo> listarModelosPorMarca(Integer idMarca) throws Exception;

}
package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.MarcaVo;

public interface MarcaBusiness {

	public Boolean inserirMarca(MarcaVo marca) throws Exception;
	
	public List<MarcaVo> listarMarcas() throws Exception;
}
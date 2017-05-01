package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.VeiculoVo;

public interface VeiculoBusiness {

	public Boolean inserirVeiculo(VeiculoVo veiculo) throws Exception;
	
	public List<VeiculoVo> listarVeiculosPart() throws Exception;
}
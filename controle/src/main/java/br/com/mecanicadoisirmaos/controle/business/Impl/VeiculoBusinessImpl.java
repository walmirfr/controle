package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mecanicadoisirmaos.controle.business.VeiculoBusiness;
import br.com.mecanicadoisirmaos.controle.dao.VeiculoDao;
import br.com.mecanicadoisirmaos.controle.vo.VeiculoVo;

@Component
public class VeiculoBusinessImpl implements VeiculoBusiness{

	@Autowired
	private VeiculoDao veiculoDao;
	
	public Boolean inserirVeiculo(VeiculoVo veiculo) throws Exception {
		if(veiculoDao.inserirVeiculo(veiculo) > 0){
			return true;
		}
		return false;
	}

	public List<VeiculoVo> listarVeiculosPart() throws Exception {
		return veiculoDao.listarVeiculos();
	}

	public Integer consultarQuantidadeVeiculosCadastrados() throws Exception {
		return veiculoDao.consultarQuantidadeVeiculosCadastrados();
	}

	public List<VeiculoVo> consultarVeiculoPorProprietario(Integer idPessoa) throws Exception {
		return veiculoDao.consultarVeiculoPorProprietario(idPessoa);
	}

}
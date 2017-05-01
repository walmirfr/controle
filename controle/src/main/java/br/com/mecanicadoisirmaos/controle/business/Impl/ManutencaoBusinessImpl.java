package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mecanicadoisirmaos.controle.business.ManutencaoBusiness;
import br.com.mecanicadoisirmaos.controle.dao.ManutencaoDao;
import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

@Component
public class ManutencaoBusinessImpl implements ManutencaoBusiness{

	@Autowired
	private ManutencaoDao manutencaoDao;
	
	public Boolean inserirManutencao(ManutencaoVo manutencao) throws Exception {
		Integer idManutencao = manutencaoDao.inserirManutencao(manutencao);
		
		for(ServicoVo servico : manutencao.getListaServicos()){
			manutencaoDao.inserirServicoManutencao(servico, idManutencao);
		}
		
		for(ProfissionalVo profissional : manutencao.getListaMecanicos()){
			manutencaoDao.inserirProfissionalManutencao(profissional, idManutencao);
		}
		return true;
	}

	public List<ManutencaoVo> listarManutencoes() throws Exception {
		return manutencaoDao.listarManutencoes();
	}

}

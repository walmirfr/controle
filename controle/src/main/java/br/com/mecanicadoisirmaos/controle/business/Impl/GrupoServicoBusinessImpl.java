package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mecanicadoisirmaos.controle.business.GrupoServicoBusiness;
import br.com.mecanicadoisirmaos.controle.dao.GrupoServicoDao;
import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;

@Component
public class GrupoServicoBusinessImpl implements GrupoServicoBusiness {

	@Autowired
	private GrupoServicoDao grupoServicoDao;
	
	public List<GrupoServicoVo> listarGrupoServico() {
		return grupoServicoDao.listarGrupoServico();
	}

	public Boolean cadastrarGrupoServico(GrupoServicoVo grupoServicoVo) {
		Integer quantidade = grupoServicoDao.cadastrarGrupoServico(grupoServicoVo);
		if (quantidade > 0) {
			return true;
		}
		return false;
	}

}

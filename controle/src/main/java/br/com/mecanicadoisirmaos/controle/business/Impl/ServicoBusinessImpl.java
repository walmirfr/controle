package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.dao.ServicoDao;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

@Component
public class ServicoBusinessImpl implements ServicoBusiness {

	@Autowired
	private ServicoDao servicoDao;

	public Boolean inserirServico(ServicoVo servico) {

		Integer quantidade = servicoDao.inserirServico(servico);
		if (quantidade > 0) {
			return true;
		}
		return false;
	}

	public List<ServicoVo> listarServicos() {
		return servicoDao.listarServicos();
	}

	public void deletarServico(ServicoVo servico) {
		servicoDao.deletarServicoPorId(servico.getIdServico());
	}

}

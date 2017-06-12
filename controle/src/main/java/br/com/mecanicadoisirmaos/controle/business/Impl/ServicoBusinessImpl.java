package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mecanicadoisirmaos.controle.business.ServicoBusiness;
import br.com.mecanicadoisirmaos.controle.dao.ServicoDao;
import br.com.mecanicadoisirmaos.controle.util.Constants;
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

	public List<ServicoVo> listarServicos(ServicoVo servico) {
		return servicoDao.listarServicos(servico);
	}

	public void deletarServico(ServicoVo servico) {
		servicoDao.deletarServicoPorId(servico.getIdServico());
	}

	public ServicoVo consultarServicoPorId(Integer idServico){
		return servicoDao.consultarServicoPorId(idServico);
	}

	public Boolean alterarServico(ServicoVo servico) {
		Integer quantidade = servicoDao.alterarServico(servico);
		if (quantidade > 0) {
			return true;
		}
		return false;
	}

	public Boolean ativarDesativarServico(ServicoVo servico, String funcao) throws Exception {
		
		if(Constants.ATIVAR.equals(funcao)){
			servico.setAtivo(true);
		}else if(Constants.DESATIVAR.equals(funcao)){
			servico.setAtivo(false);
		}
		
		if(servicoDao.ativarDesativarServico(servico) > 0){
			return true;
		}
		return false;
	}

	public Integer consultarQuantidadeServicosCadastrados() throws Exception {
		return servicoDao.consultarQuantidadeServicosCadastrados();
	}
}
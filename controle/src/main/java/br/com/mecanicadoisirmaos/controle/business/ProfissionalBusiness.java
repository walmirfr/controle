package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;

public interface ProfissionalBusiness {

	public boolean inserirProfissional(ProfissionalVo profissional) throws Exception;

	public List<PessoaFisicaVo> listarProfissionais() throws Exception;
}

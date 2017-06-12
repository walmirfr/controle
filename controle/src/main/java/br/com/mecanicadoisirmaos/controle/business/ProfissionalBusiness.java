package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;

public interface ProfissionalBusiness {

	public boolean inserirProfissional(ProfissionalVo profissional) throws Exception;

	public List<PessoaFisicaVo> listarProfissionais(PessoaFisicaVo pf) throws Exception;

	public Boolean alterarProfissional(ProfissionalVo profissional, PessoaFisicaVo profissionalOriginal) throws Exception;

	public Boolean excluirProfissional(ProfissionalVo profissional) throws Exception;

	public Boolean ativarDesativarProfissional(PessoaVo pessoa, String funcao) throws Exception;

	public PessoaFisicaVo consultarProfissionalPorId(Integer idPessoa) throws Exception;	
}

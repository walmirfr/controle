package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.mecanicadoisirmaos.controle.business.ProfissionalBusiness;
import br.com.mecanicadoisirmaos.controle.dao.EnderecoDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaFisicaDao;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

@Component
public class ProfissionalBusinessImpl implements ProfissionalBusiness {

	@Autowired
	private PessoaDao pessoaDao;
	
	@Autowired
	private PessoaFisicaDao pessoaFisicaDao;
	
	@Autowired
	private EnderecoDao enderecoDao;
	
	@Transactional
	public boolean inserirProfissional(ProfissionalVo profissional) throws Exception{

		if(pessoaFisicaDao.consultarPessoaFisicaCadastrada(Constants.TP_PROFISSIONAL, profissional.getNome(), null) > 0){
			return false;
		}
		
		PessoaVo pessoa = profissional;
		pessoa.setTipoPessoa(Constants.TP_PESSOA_FISICA);
		Integer idPessoa = pessoaDao.inserirPessoa(pessoa);
		
		profissional.setIdPessoa(idPessoa);
		PessoaFisicaVo pessoaFisica = profissional;
		pessoaFisica.setTipoPessoaFisica(Constants.TP_PROFISSIONAL);
		pessoaFisicaDao.inserirPessoaFisica(pessoaFisica);

		if(profissional.getEndereco() != null){
			profissional.getEndereco().setPessoa(profissional);
			enderecoDao.inserirEndereco(profissional.getEndereco());
		}

		inserirTelefone(profissional.getListaTelefones(), pessoa);
		
		return true;
	}

	private void inserirTelefone(List<TelefoneVo> listaTelefones, PessoaVo pessoa){
		if(!listaTelefones.isEmpty()){
			Util.limparListaNullListTelefone(listaTelefones);
			for(TelefoneVo telefone: listaTelefones){
				telefone.setPessoa(pessoa);
				pessoaDao.inserirTelefone(telefone);
			}			
		}
	}
	
	public List<PessoaFisicaVo> listarProfissionais(PessoaFisicaVo pf) throws Exception {
		List<PessoaFisicaVo> listaProfissionais = pessoaFisicaDao.listarPessoasPorTipo(Constants.TP_PROFISSIONAL, pf);
		for(PessoaFisicaVo pessoaFisica : listaProfissionais){
			pessoaFisica.setListaTelefones(pessoaDao.consultarTelefonesPorPessoa(pessoaFisica.getIdPessoa()));
		}
		return listaProfissionais;
	}

	public Boolean alterarProfissional(ProfissionalVo profissional, PessoaFisicaVo profissionalOriginal)
			throws Exception {
		if(pessoaFisicaDao.consultarPessoaFisicaCadastrada(Constants.TP_PROFISSIONAL, profissional.getNome(), profissionalOriginal) > 0){
			return false;
		}
		
		//Alterar Telefone
		pessoaDao.excluirTelefone(profissional.getIdPessoa());
		if(profissional.getListaTelefones() != null && !profissional.getListaTelefones().isEmpty()){
			inserirTelefone(profissional.getListaTelefones(), profissional);
		}
		
		//Endereço
		profissional.getEndereco().setPessoa(profissional);
		enderecoDao.alterarEndereco(profissional.getEndereco());
		
		pessoaFisicaDao.alterarPessoaFisica(profissional);
		
		pessoaDao.alterarPessoa(profissional);
		
		return true;
	}

	public Boolean excluirProfissional(ProfissionalVo profissional) throws Exception {
		if(pessoaFisicaDao.excluirPessoaFisica(profissional.getIdPessoa()) == 0){
			return false;
		}
		if(pessoaDao.excluirTelefone(profissional.getIdPessoa()) == 0){
			return false;
		}
		if(enderecoDao.excluirEndereco(profissional.getIdPessoa()) == 0){
			return false;
		}
		if(pessoaDao.excluirPessoa(profissional.getIdPessoa()) == 0){
			return false;
		}
		return true;
	}

	public Boolean ativarDesativarProfissional(PessoaVo pessoa, String funcao) throws Exception {
		if(Constants.ATIVAR.equals(funcao)){
			pessoa.setAtivo(true);
		}else if(Constants.DESATIVAR.equals(funcao)){
			pessoa.setAtivo(false);
		}

		if(pessoaDao.ativarDesativarPessoa(pessoa) > 0){
			return true;
		}
		return false;
	}

	public PessoaFisicaVo consultarProfissionalPorId(Integer idPessoa) throws Exception {
		PessoaFisicaVo pf = pessoaFisicaDao.consultarPessoaFisicaPorId(idPessoa);
		pf.setListaTelefones(pessoaDao.consultarTelefonesPorPessoa(idPessoa));
		pf.setEndereco(enderecoDao.consultarEnderecoPorPessoa(idPessoa));
				
		return pf;
	}

}

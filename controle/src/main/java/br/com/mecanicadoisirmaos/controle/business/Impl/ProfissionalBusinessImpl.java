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

		if(!profissional.getListaTelefones().isEmpty()){
			for(TelefoneVo telefone: profissional.getListaTelefones()){
				telefone.setPessoa(pessoa);
				pessoaDao.inserirTelefone(telefone);
			}			
		}
		
		return true;
	}

	public List<PessoaFisicaVo> listarProfissionais() throws Exception {
		return pessoaFisicaDao.listarPessoasPorTipo(Constants.TP_PROFISSIONAL);
	}

}

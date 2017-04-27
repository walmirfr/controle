package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.mecanicadoisirmaos.controle.business.ClienteBusiness;
import br.com.mecanicadoisirmaos.controle.dao.ClienteDao;
import br.com.mecanicadoisirmaos.controle.dao.EnderecoDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaFisicaDao;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

@Component
public class ClienteBusinessImpl implements ClienteBusiness {

	@Autowired
	private PessoaDao pessoaDao;
	
	@Autowired
	private PessoaFisicaDao pessoaFisicaDao;
	
	@Autowired
	private EnderecoDao enderecoDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Transactional
	public Boolean inserirCliente(ClienteVo cliente) throws Exception {
		
		PessoaVo pessoa = cliente;
		pessoa.setTipoPessoa(Constants.TP_PESSOA_FISICA);
		Integer idPessoa = pessoaDao.inserirPessoa(pessoa);
		
		cliente.setIdPessoa(idPessoa);
		PessoaFisicaVo pessoaFisica = cliente;
		pessoaFisica.setTipoPessoaFisica(Constants.TP_CLIENTE);
		pessoaFisicaDao.inserirPessoaFisica(pessoaFisica);

		if(cliente.getEndereco() != null){
			cliente.getEndereco().setPessoa(cliente);
			enderecoDao.inserirEndereco(cliente.getEndereco());
		}

		if(!cliente.getListaTelefones().isEmpty()){
			for(TelefoneVo telefone: cliente.getListaTelefones()){
				telefone.setPessoa(pessoa);
				pessoaDao.inserirTelefone(telefone);
			}			
		}
		
		return true;
	}

	public List<PessoaFisicaVo> listarClientes() throws Exception {
		return pessoaFisicaDao.listarPessoasPorTipo(Constants.TP_CLIENTE);
	}
}
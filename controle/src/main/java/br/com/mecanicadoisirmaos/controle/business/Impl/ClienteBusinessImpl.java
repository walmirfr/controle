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
import br.com.mecanicadoisirmaos.controle.util.Util;
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
		
		if(pessoaFisicaDao.consultarPessoaFisicaCadastrada(Constants.TP_CLIENTE, cliente.getNome(), null) > 0){
			return false;
		}
		
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

		inserirTelefone(cliente.getListaTelefones(), pessoa);
		
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
	
	public List<PessoaFisicaVo> listarClientes(PessoaFisicaVo pf) throws Exception {
		List<PessoaFisicaVo> listaClientes = pessoaFisicaDao.listarPessoasPorTipo(Constants.TP_CLIENTE, pf);
		for(PessoaFisicaVo pessoaFisica : listaClientes){
			pessoaFisica.setListaTelefones(pessoaDao.consultarTelefonesPorPessoa(pessoaFisica.getIdPessoa()));
		}
		return listaClientes;
	}
	
	public List<ClienteVo> listarClientesPart() throws Exception {
		return clienteDao.listarClientesPart();
	}

	public Integer consultarQuantidadeClientesCadastrados() throws Exception {
		return clienteDao.consultarQuantidadeClientesCadastrados();
	}

	public Boolean excluirCliente(ClienteVo cliente) throws Exception {
		if(pessoaFisicaDao.excluirPessoaFisica(cliente.getIdPessoa()) == 0){
			return false;
		}
		if(pessoaDao.excluirTelefone(cliente.getIdPessoa()) == 0){
			return false;
		}
		if(enderecoDao.excluirEndereco(cliente.getIdPessoa()) == 0){
			return false;
		}
		if(pessoaDao.excluirPessoa(cliente.getIdPessoa()) == 0){
			return false;
		}
		return true;
	}

	public Boolean ativarDesativarCliente(PessoaVo pessoa, String funcao) throws Exception {

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

	public PessoaFisicaVo consultarClientePorId(Integer idPessoa) throws Exception {
		PessoaFisicaVo pf = pessoaFisicaDao.consultarPessoaFisicaPorId(idPessoa);
		pf.setListaTelefones(pessoaDao.consultarTelefonesPorPessoa(idPessoa));
		pf.setEndereco(enderecoDao.consultarEnderecoPorPessoa(idPessoa));
				
		return pf;
	}

	@Transactional
	public Boolean alterarCliente(ClienteVo cliente,PessoaFisicaVo clienteOriginal) throws Exception {
		if(pessoaFisicaDao.consultarPessoaFisicaCadastrada(Constants.TP_CLIENTE, cliente.getNome(), clienteOriginal) > 0){
			return false;
		}
		
		//Alterar Telefone
		pessoaDao.excluirTelefone(cliente.getIdPessoa());
		if(cliente.getListaTelefones() != null && !cliente.getListaTelefones().isEmpty()){
			inserirTelefone(cliente.getListaTelefones(), cliente);
		}
		
		//Endereço
		cliente.getEndereco().setPessoa(cliente);
		enderecoDao.alterarEndereco(cliente.getEndereco());
		
		pessoaFisicaDao.alterarPessoaFisica(cliente);
		
		pessoaDao.alterarPessoa(cliente);
		
		return true;
	}
	
}
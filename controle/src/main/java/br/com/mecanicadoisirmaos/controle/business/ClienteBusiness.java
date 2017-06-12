package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;

public interface ClienteBusiness {

	public Boolean inserirCliente(ClienteVo cliente) throws Exception;
	
	public List<PessoaFisicaVo> listarClientes(PessoaFisicaVo pf) throws Exception;
	
	public List<ClienteVo> listarClientesPart() throws Exception;

	public Integer consultarQuantidadeClientesCadastrados() throws Exception;

	public Boolean excluirCliente(ClienteVo cliente) throws Exception;

	public Boolean ativarDesativarCliente(PessoaVo pessoa, String funcao) throws Exception;

	public PessoaFisicaVo consultarClientePorId(Integer idPessoa) throws Exception;

	public Boolean alterarCliente(ClienteVo cliente, PessoaFisicaVo clienteOriginal) throws Exception;
}
package br.com.mecanicadoisirmaos.controle.business;

import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;

public interface ClienteBusiness {

	public Boolean inserirCliente(ClienteVo cliente) throws Exception;
	
	public List<PessoaFisicaVo> listarClientes() throws Exception;
	
	public List<ClienteVo> listarClientesPart() throws Exception;
}
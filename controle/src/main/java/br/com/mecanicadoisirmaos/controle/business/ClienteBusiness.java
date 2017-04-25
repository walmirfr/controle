package br.com.mecanicadoisirmaos.controle.business;

import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;

public interface ClienteBusiness {

	public Boolean inserirCliente(ClienteVo cliente) throws Exception;
}
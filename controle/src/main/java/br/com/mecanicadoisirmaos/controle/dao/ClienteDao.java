package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;

public interface ClienteDao {

	public List<ClienteVo> listarClientes() throws DataAccessException;
	
	public List<ClienteVo> listarClientesPart() throws DataAccessException;
}
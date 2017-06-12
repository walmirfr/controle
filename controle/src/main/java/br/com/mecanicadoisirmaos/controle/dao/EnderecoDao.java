package br.com.mecanicadoisirmaos.controle.dao;

import org.springframework.dao.DataAccessException;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import br.com.mecanicadoisirmaos.controle.vo.EnderecoVo;

public interface EnderecoDao {

	public Integer inserirEndereco(EnderecoVo endereco) throws DataAccessException;

	public Integer excluirEndereco(Integer idPessoa) throws DataAccessException;
	
	public EnderecoVo consultarEnderecoPorPessoa(Integer idPessoa) throws DatabindingException;
	
	public Integer alterarEndereco(EnderecoVo endereco) throws DataAccessException;
}
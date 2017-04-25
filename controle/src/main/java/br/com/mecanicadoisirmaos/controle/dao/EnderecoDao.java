package br.com.mecanicadoisirmaos.controle.dao;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.EnderecoVo;

public interface EnderecoDao {

	public Integer inserirEndereco(EnderecoVo endereco) throws DataAccessException;
}
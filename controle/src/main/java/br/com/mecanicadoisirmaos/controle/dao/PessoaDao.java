package br.com.mecanicadoisirmaos.controle.dao;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;

public interface PessoaDao {

	public Integer inserirPessoa(PessoaVo pessoa) throws DataAccessException;
}
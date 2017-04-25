package br.com.mecanicadoisirmaos.controle.dao;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

public interface PessoaDao {

	public Integer inserirPessoa(PessoaVo pessoa) throws DataAccessException;
	
	public Integer inserirTelefone(TelefoneVo telefone) throws DataAccessException;
 }
package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;

public interface PessoaFisicaDao {

	public Integer inserirPessoaFisica(PessoaFisicaVo pessoaFisica) throws DataAccessException;
	
	public List<PessoaFisicaVo> listarPessoasPorTipo(String tipo) throws DataAccessException;
}
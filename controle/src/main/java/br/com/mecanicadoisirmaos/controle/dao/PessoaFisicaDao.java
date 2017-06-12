package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.FuncionarioVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;

public interface PessoaFisicaDao {

	public Integer inserirPessoaFisica(PessoaFisicaVo pessoaFisica) throws DataAccessException;
	
	public List<PessoaFisicaVo> listarPessoasPorTipo(String tipo, PessoaFisicaVo pf) throws DataAccessException;

	public Integer excluirPessoaFisica(Integer idPessoa) throws DataAccessException;

	public PessoaFisicaVo consultarPessoaFisicaPorId(Integer idPessoa) throws DataAccessException;
	
	public Integer consultarPessoaFisicaCadastrada(String tipo, String nome, PessoaFisicaVo clienteOriginal) throws DataAccessException;

	public Integer alterarPessoaFisica(PessoaFisicaVo pessoaFisica) throws DataAccessException;

	public List<FuncionarioVo> listarFuncionariosPorEmpresa(Integer idPessoa) throws DataAccessException;
}
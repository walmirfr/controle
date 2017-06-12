package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

public interface PessoaDao {

	public Integer inserirPessoa(PessoaVo pessoa) throws DataAccessException;
	
	public Integer inserirTelefone(TelefoneVo telefone) throws DataAccessException;

	public Integer excluirTelefone(Integer idPessoa) throws DataAccessException;

	public Integer excluirPessoa(Integer idPessoa) throws DataAccessException;

	public Integer ativarDesativarPessoa(PessoaVo pessoa)throws DataAccessException;

	public List<TelefoneVo> consultarTelefonesPorPessoa(Integer idPessoa) throws DataAccessException;

	public Integer alterarPessoa(PessoaVo pessoa);
}
package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.EmpresaVo;

public interface EmpresaDao {

	public List<EmpresaVo> listarEmpresas(EmpresaVo empresaVo) throws DataAccessException;

	public EmpresaVo consultarEmpresaPorId(Integer idPessoa) throws DataAccessException;

	public Integer consultarEmpresaCadastrada(String nomeFantasia, EmpresaVo empresaOriginal) throws DataAccessException;

	public Integer inserirEmpresa(EmpresaVo emp) throws DataAccessException;

	public Integer excluirFuncionarioPorEmpresa(Integer idPessoa) throws DataAccessException;

	public Integer alterarEmpresa(EmpresaVo empresa) throws DataAccessException;

}

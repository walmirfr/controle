package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.EmpresaDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.EmpresaQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.EmpresaVo;

@Repository
public class EmpresaDaoImpl extends AbstractDao implements EmpresaDao, EmpresaQueries {

	private static final Logger LOGGER = Logger.getLogger(EmpresaDaoImpl.class);
	
	public List<EmpresaVo> listarEmpresas(EmpresaVo empresaVo) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_EMPRESAS);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		if(empresaVo != null && empresaVo.getNomeFantasia() != null){
			sql.append("AND unaccent(NOME_FANTASIA) ILIKE unaccent(:nomeFantasia) ");
			parans.addValue(Constants.NOME_FANTASIA, "%"+empresaVo.getNomeFantasia()+"%");
		}
		
		sql.append("ORDER BY NOME_FANTASIA ");
		
		try{
			return getJdbc().query(sql.toString(), parans, new EmpresaPartRowMapper());
		}catch (DataAccessException d){
			throw d;
		}
	}
	
	public EmpresaVo consultarEmpresaPorId(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_EMPRESA_POR_ID);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		
		try{
			return getJdbc().queryForObject(sql.toString(), parans, new EmpresaRowMapper());
		}catch (DataAccessException d){
			throw d;
		}
	}

	public static class EmpresaPartRowMapper implements RowMapper<EmpresaVo>{
		public EmpresaVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpresaVo emp = new EmpresaVo();
			emp.setIdPessoa(rs.getInt("ID_PESSOA"));
			emp.setAtivo(Util.getAtivo(rs.getString("ATIVO")));
			emp.setVinculo(Util.getVinculo(rs.getInt("VINCULO")));
			emp.setNomeFantasia(rs.getString("NOME_FANTASIA"));
			emp.setEmail(rs.getString("EMAIL"));
			
			return emp;
		}
		
	}

	public static class EmpresaRowMapper implements RowMapper<EmpresaVo>{
		public EmpresaVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpresaVo emp = new EmpresaVo();
			emp.setIdPessoa(rs.getInt("ID_PESSOA"));
			emp.setAtivo(Util.getAtivo(rs.getString("ATIVO")));
			emp.setNomeFantasia(rs.getString("NOME_FANTASIA"));
			emp.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
			emp.setCnpj(rs.getString("CNPJ"));
			emp.setEmail(rs.getString("EMAIL"));
			
			return emp;
		}
		
	}

	public Integer consultarEmpresaCadastrada(String nomeFantasia, EmpresaVo empresaOriginal)
			throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_EMPRESA_CADASTRADA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME_FANTASIA, nomeFantasia);
		
		if(empresaOriginal != null && empresaOriginal.getNomeFantasia() != null){
			sql.append("AND NOME != :original ");
			parans.addValue("original", empresaOriginal.getNomeFantasia());
		}
		
		try{
			return getJdbc().queryForObject(sql.toString(), parans, Integer.class);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public Integer inserirEmpresa(EmpresaVo emp) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_EMPRESA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.TIPO_PESSOA, emp.getTipoPessoa());
		parans.addValue(Constants.NOME_FANTASIA, emp.getNomeFantasia());
		parans.addValue(Constants.CNPJ, emp.getCnpj());
		parans.addValue(Constants.RAZAO_SOCIAL, emp.getRazaoSocial());
		parans.addValue(Constants.EMAIL, emp.getEmail());
		
		try{
			KeyHolder keyHolder = new GeneratedKeyHolder();
			getJdbc().update(sql.toString(), parans, keyHolder);
			return (Integer) keyHolder.getKeys().get("id_pessoa");
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade PessoaFisica: " + d);
			throw d;
		}
	}

	public Integer excluirFuncionarioPorEmpresa(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_EXCLUIR_FUNCIONARIO_POR_EMPRESA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public Integer alterarEmpresa(EmpresaVo emp) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_ALTERAR_EMPRESA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME_FANTASIA, emp.getNomeFantasia());
		parans.addValue(Constants.CNPJ, emp.getCnpj());
		parans.addValue(Constants.RAZAO_SOCIAL, emp.getRazaoSocial());
		parans.addValue(Constants.EMAIL, emp.getEmail());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade PessoaFisica: " + d);
			throw d;
		}
	}
	
}

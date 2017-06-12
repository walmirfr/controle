package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaFisicaDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.PessoaFisicaQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.FuncionarioVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;

@Repository
public class PessoaFisicaDaoImpl extends AbstractDao implements PessoaFisicaDao, PessoaFisicaQueries {

	private static final Logger LOGGER = Logger.getLogger(PessoaFisicaDaoImpl.class);
	
	public Integer inserirPessoaFisica(PessoaFisicaVo pessoaFisica) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_PESSOA_FISICA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, pessoaFisica.getIdPessoa());
		parans.addValue(Constants.TIPO_PESSOA_FISICA, pessoaFisica.getTipoPessoaFisica());
		parans.addValue(Constants.NOME, pessoaFisica.getNome());
		parans.addValue(Constants.CPF, pessoaFisica.getCpf());
		parans.addValue(Constants.SEXO, pessoaFisica.getSexo());
		parans.addValue(Constants.DATANASCIMENTO, pessoaFisica.getDtNascimento());
		parans.addValue(Constants.SALARIO, pessoaFisica.getSalario());
		Integer idEmpresa = null;
		if(pessoaFisica.getEmpresa() != null && pessoaFisica.getEmpresa().getIdPessoa() != null){
			idEmpresa = pessoaFisica.getEmpresa().getIdPessoa();
		}
		parans.addValue(Constants.IDPESSOAJURIDICA, idEmpresa);
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade PessoaFisica: " + d);
			throw d;
		}
	}
	
	public List<PessoaFisicaVo> listarPessoasPorTipo(String tipo, PessoaFisicaVo pf) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_PESSOAS_POR_TIPO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.TIPO, tipo);
		
		if(pf != null && pf.getNome() != null){
			sql.append("AND unaccent(NOME) ILIKE unaccent(:nome) ");
			parans.addValue(Constants.NOME, "%"+pf.getNome()+"%");
		}
		
		sql.append("ORDER BY PF.NOME ");
		
		try{
			return getJdbc().query(sql.toString(), parans, new PessoaFisicaPartRowMapper());
		}catch (DataAccessException d){
			throw d;
		}
	}
	
	public static class PessoaFisicaPartRowMapper implements RowMapper<PessoaFisicaVo>{

		public PessoaFisicaVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			PessoaFisicaVo pessoaFisica = new PessoaFisicaVo();
			pessoaFisica.setIdPessoa(rs.getInt("ID_PESSOA"));
			pessoaFisica.setNome(rs.getString("NOME"));
			pessoaFisica.setEmail(rs.getString("EMAIL"));
			pessoaFisica.setAtivo(Util.getAtivo(rs.getString("ATIVO")));
			pessoaFisica.setVinculo(Util.getVinculo(rs.getInt("VINCULO")));
			
			return pessoaFisica;
		}
		
	}

	public Integer excluirPessoaFisica(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_EXCLUIR_PESSOA_FISICA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public PessoaFisicaVo consultarPessoaFisicaPorId(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_PESSOA_FISICA_POR_ID);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		try{
			return getJdbc().queryForObject(sql.toString(), parans, new PessoaFisicaRowMapper());
		}catch(DataAccessException d){
			throw d;
		}
	}

	public static class PessoaFisicaRowMapper implements RowMapper<PessoaFisicaVo>{
		public PessoaFisicaVo mapRow(ResultSet rs, int rowNum) throws SQLException{
			PessoaFisicaVo pf = new PessoaFisicaVo();
			pf.setIdPessoa(rs.getInt("ID_PESSOA"));
			pf.setEmail(rs.getString("EMAIL"));
			pf.setAtivo(Util.getAtivo(rs.getString("ATIVO")));
			pf.setNome(rs.getString("NOME"));
			pf.setCpf(rs.getString("CPF"));
			pf.setSalario(rs.getDouble("SALARIO"));
			pf.setNascimento(Util.formatarData(rs.getDate("DT_NASCIMENTO")));
			pf.setSexo(rs.getString("SEXO"));
			
			return pf;
		}
	}
	
	public static class FuncionarioRowMapper implements RowMapper<FuncionarioVo>{
		public FuncionarioVo mapRow(ResultSet rs, int rowNum) throws SQLException{
			FuncionarioVo func = new FuncionarioVo();
			func.setIdPessoa(rs.getInt("ID_PESSOA"));
			func.setEmail(rs.getString("EMAIL"));
			func.setNome(rs.getString("NOME"));
			func.setCpf(rs.getString("CPF"));
			func.setNascimento(Util.formatarData(rs.getDate("DT_NASCIMENTO")));
			func.setSexo(rs.getString("SEXO"));
			
			return func;
		}
	}

	public Integer consultarPessoaFisicaCadastrada(String tipo, String nome, PessoaFisicaVo pessoaOriginal) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_PESSOA_FISICA_CADASTRADA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME, nome);
		parans.addValue(Constants.TIPO_PESSOA_FISICA, tipo);
		
		if(pessoaOriginal != null && pessoaOriginal.getNome() != null){
			sql.append("AND NOME != :original ");
			parans.addValue("original", pessoaOriginal.getNome());
		}
		
		try{
			return getJdbc().queryForObject(sql.toString(), parans, Integer.class);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public Integer alterarPessoaFisica(PessoaFisicaVo pessoaFisica) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_ALTERAR_PESSOA_FISICA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.NOME, pessoaFisica.getNome());
		parans.addValue(Constants.CPF, pessoaFisica.getCpf());
		parans.addValue(Constants.SEXO, pessoaFisica.getSexo());
		parans.addValue(Constants.DATANASCIMENTO, pessoaFisica.getDtNascimento());
		parans.addValue(Constants.IDPESSOA, pessoaFisica.getIdPessoa());		
		parans.addValue(Constants.SALARIO, pessoaFisica.getSalario());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade PessoaFisica: " + d);
			throw d;
		}
	}

	public List<FuncionarioVo> listarFuncionariosPorEmpresa(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_FUNCIONARIO_POR_EMPRESA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		
		try{
			return getJdbc().query(sql.toString(), parans, new FuncionarioRowMapper());
		}catch(DataAccessException d){
			throw d;
		}
	}
}
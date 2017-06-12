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
import br.com.mecanicadoisirmaos.controle.dao.PessoaDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.PessoaQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.util.Util;
import br.com.mecanicadoisirmaos.controle.vo.PessoaJuridicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

@Repository
public class PessoaDaoImpl extends AbstractDao implements PessoaDao, PessoaQueries {

	private final static Logger LOGGER = Logger.getLogger(PessoaDaoImpl.class);
	
	private static final String TIPO_JURIDICO = "J";
	
	public Integer inserirPessoa(PessoaVo pessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_PESSOA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.EMAIL, pessoa.getEmail());
		parans.addValue(Constants.TIPO_PESSOA, pessoa.getTipoPessoa());

		/*if(pessoa.getLogin() != null){
			
			parans.addValue(Constants.LOGIN, pessoa.getLogin());
		}
		if(pessoa.getSenha() != null){
			
			parans.addValue(Constants.SENHA, pessoa.getSenha());
		}*/
		
		PessoaJuridicaVo juridica = new PessoaJuridicaVo();
		if(TIPO_JURIDICO.equals(pessoa.getTipoPessoa())){
			juridica = (PessoaJuridicaVo) pessoa;
		}
		parans.addValue(Constants.CNPJ, juridica.getCnpj());
		parans.addValue(Constants.NOME_FANTASIA, juridica.getNomeFantasia());
		parans.addValue(Constants.RAZAO_SOCIAL, juridica.getRazaoSocial());			
		
		try{
			KeyHolder keyHolder = new GeneratedKeyHolder();
			getJdbc().update(sql.toString(), parans, keyHolder);
			return (Integer) keyHolder.getKeys().get("id_pessoa");
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade Pessoa: " + d);
			throw d;
		}
	}

	public Integer inserirTelefone(TelefoneVo telefone) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERT_TELEFONE);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, telefone.getPessoa().getIdPessoa());
		parans.addValue(Constants.NUMERO, telefone.getTelefone());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade Telefone: " + d);
			throw d;
		}
	}

	public Integer excluirTelefone(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_EXCLUIR_TELEFONE);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public Integer excluirPessoa(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_EXCLUIR_PESSOA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public Integer ativarDesativarPessoa(PessoaVo pessoa) throws DataAccessException {

		StringBuilder sql = new StringBuilder(QUERY_ATIVAR_DESATIVAR_PESSOA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.FUNCAO, Util.getAtivo(pessoa.getAtivo()));
		parans.addValue(Constants.IDPESSOA, pessoa.getIdPessoa());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}

	public List<TelefoneVo> consultarTelefonesPorPessoa(Integer idPessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_TELEFONE_POR_PESSOA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, idPessoa);
		
		try{
			return getJdbc().query(sql.toString(), parans, new TelefoneRowMapper());
		}catch(DataAccessException d){
			throw d;
		}
	}
	
	public static class TelefoneRowMapper implements RowMapper<TelefoneVo>{
		public TelefoneVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			TelefoneVo telefone = new TelefoneVo();
			String numero = rs.getString("TELEFONE");
			telefone.setDd(numero.substring(0, 2));
			telefone.setNumero(numero.substring(2));
			return telefone;
		}
	}

	public Integer alterarPessoa(PessoaVo pessoa) {
		StringBuilder sql = new StringBuilder(QUERY_ALTERAR_PESSOA);
		MapSqlParameterSource parans = new MapSqlParameterSource();

		parans.addValue(Constants.EMAIL, pessoa.getEmail());
		parans.addValue(Constants.CNPJ, null);
		parans.addValue(Constants.NOME_FANTASIA, null);
		parans.addValue(Constants.RAZAO_SOCIAL, null);
		parans.addValue(Constants.IDPESSOA, pessoa.getIdPessoa());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch(DataAccessException d){
			throw d;
		}
	}
}
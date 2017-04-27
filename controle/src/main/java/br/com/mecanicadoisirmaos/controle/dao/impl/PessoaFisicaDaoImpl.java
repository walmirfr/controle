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
import br.com.mecanicadoisirmaos.controle.vo.EmpresaVo;
import br.com.mecanicadoisirmaos.controle.vo.FuncionarioVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

@Repository
public class PessoaFisicaDaoImpl extends AbstractDao implements PessoaFisicaDao, PessoaFisicaQueries {

	private static final Logger LOGGER = Logger.getLogger(PessoaFisicaDaoImpl.class);
	
	private static final String TIPO_MECANICO = "M";
	private static final String TIPO_FUNCIONARIO = "F";
	
	public Integer inserirPessoaFisica(PessoaFisicaVo pessoaFisica) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_PESSOA_FISICA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.IDPESSOA, pessoaFisica.getIdPessoa());
		parans.addValue(Constants.TIPO_PESSOA_FISICA, pessoaFisica.getTipoPessoaFisica());
		parans.addValue(Constants.NOME, pessoaFisica.getNome());
		parans.addValue(Constants.CPF, pessoaFisica.getCpf());
		parans.addValue(Constants.DATANASCIMENTO, pessoaFisica.getDtNascimento());
		
		FuncionarioVo funcionario = new FuncionarioVo(new EmpresaVo());
		if(TIPO_FUNCIONARIO.equals(pessoaFisica.getTipoPessoaFisica())){
			funcionario = (FuncionarioVo) pessoaFisica;
		}
		parans.addValue(Constants.IDPESSOAJURIDICA, funcionario.getEmpresa().getIdPessoa());
		
		ProfissionalVo mecanico = new ProfissionalVo();
		if(TIPO_MECANICO.equals(pessoaFisica.getTipoPessoaFisica())){
			mecanico = (ProfissionalVo) pessoaFisica;
		}
		parans.addValue(Constants.SALARIO, mecanico.getSalario());
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade PessoaFisica: " + d);
			throw d;
		}
	}
	
	public List<PessoaFisicaVo> listarPessoasPorTipo(String tipo) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_PESSOAS_POR_TIPO);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.TIPO, tipo);
		
		try{
			return getJdbc().query(sql.toString(), parans, new PessoaFisicaRowMapper());
		}catch (DataAccessException d){
			throw d;
		}
	}
	
	public static class PessoaFisicaRowMapper implements RowMapper<PessoaFisicaVo>{

		public PessoaFisicaVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			PessoaFisicaVo pessoaFisica = new PessoaFisicaVo();
			pessoaFisica.setIdPessoa(rs.getInt("ID_PESSOA"));
			pessoaFisica.setNome(rs.getString("NOME"));
			pessoaFisica.setEmail(rs.getString("EMAIL"));
			
			TelefoneVo telefone = new TelefoneVo();
			telefone.setTelefone(rs.getString("TELEFONE"));
			pessoaFisica.setTelefone(telefone);
			return pessoaFisica;
		}
		
	}

}
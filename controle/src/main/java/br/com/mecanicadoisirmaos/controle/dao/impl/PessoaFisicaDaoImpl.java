package br.com.mecanicadoisirmaos.controle.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaFisicaDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.PessoaFisicaQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.FuncionarioVo;
import br.com.mecanicadoisirmaos.controle.vo.MecanicoVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaFisicaVo;

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
		
		if(TIPO_FUNCIONARIO.equals(pessoaFisica.getTipoPessoaFisica())){
			FuncionarioVo funcionario = (FuncionarioVo) pessoaFisica;
			parans.addValue(Constants.IDPESSOAJURIDICA, funcionario.getEmpresa().getIdPessoa());
		}
		
		if(TIPO_MECANICO.equals(pessoaFisica.getTipoPessoaFisica())){
			MecanicoVo mecanico = (MecanicoVo) pessoaFisica;
			parans.addValue(Constants.SALARIO, mecanico.getSalario());
		}
		
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da Entidade PessoaFisica: " + d);
			throw d;
		}
	}

}
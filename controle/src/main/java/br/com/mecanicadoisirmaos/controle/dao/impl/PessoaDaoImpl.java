package br.com.mecanicadoisirmaos.controle.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.PessoaDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.PessoaQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.PessoaJuridicaVo;
import br.com.mecanicadoisirmaos.controle.vo.PessoaVo;

public class PessoaDaoImpl extends AbstractDao implements PessoaDao, PessoaQueries {

	private final static Logger LOGGER = Logger.getLogger(PessoaDaoImpl.class);
	
	private static final String TIPO_JURIDICO = "J";
	
	public Integer inserirPessoa(PessoaVo pessoa) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_INSERIR_PESSOA);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		parans.addValue(Constants.EMAIL, pessoa.getEmail());
		parans.addValue(Constants.LOGIN, pessoa.getLogin());
		parans.addValue(Constants.SENHA, pessoa.getSenha());
		parans.addValue(Constants.TIPO_PESSOA, pessoa.getTipoPessoa());
		
		if(TIPO_JURIDICO.equals(pessoa.getTipoPessoa())){
			PessoaJuridicaVo juridica = (PessoaJuridicaVo) pessoa;
			parans.addValue(Constants.CNPJ, juridica.getCnpj());
			parans.addValue(Constants.NOME_FANTASIA, juridica.getNomeFantasia());
			parans.addValue(Constants.RAZAO_SOCIAL, juridica.getRazaoSocial());			
		}
		try{
			return getJdbc().update(sql.toString(), parans);
		}catch (DataAccessException d){
			LOGGER.error("Erro na inclusão da entidade Pessoa: " + d);
			throw d;
		}
	}
}
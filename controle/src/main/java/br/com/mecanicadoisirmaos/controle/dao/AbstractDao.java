package br.com.mecanicadoisirmaos.controle.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class AbstractDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private NamedParameterJdbcTemplate jdbc;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public AbstractDao(){
		InitialContext initCtx;
		try {
			initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup( "java:/comp/env/jdbc/gestor_oficina" );
			setDataSource(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Respons�vel por retornar o atributo jdbcTemplateObject
	 * @return o jdbcTemplateObject
	 */
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	/**
	 * Respons�vel por atribuir valor ao atributo jdbcTemplateObject
	 * @param jdbcTemplateObject para o atributo jdbcTemplateObject
	 */
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	/**
	 * Respons�vel por retornar o atributo jdbc
	 * @return o jdbc
	 */
	public NamedParameterJdbcTemplate getJdbc() {
		return jdbc;
	}

	/**
	 * Respons�vel por atribuir valor ao atributo jdbc
	 * @param jdbc para o atributo jdbc
	 */
	public void setJdbc(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	/**
	 * Respons�vel por retornar o atributo dataSource
	 * @return o dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
}
package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.ClienteDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.ClienteQueries;
import br.com.mecanicadoisirmaos.controle.util.Constants;
import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

@Repository
public class ClienteDaoImpl extends AbstractDao implements ClienteDao, ClienteQueries {

	public List<ClienteVo> listarClientes(ClienteVo cliente) throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_CLIENTES);
		MapSqlParameterSource parans = new MapSqlParameterSource();
		
		if(cliente.getNome() != null){
			sql.append("AND NOME LIKE :nome ");
			parans.addValue(Constants.NOME, "%"+cliente.getNome()+"%");
		}
		
		sql.append("ORDER BY PF.NOME ");
		
		try{
			return getJdbc().query(sql.toString(), parans, new ClienteRowMapper());
		}catch (DataAccessException d){
			throw d;
		}
	}
	
	public List<ClienteVo> listarClientesPart() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_CLIENTES_PART);
		try{
			return getJdbc().query(sql.toString(), new ClientePartRowMapper());
		}catch (DataAccessException d){
			throw d;
		}
	}
	
	public static class ClienteRowMapper implements RowMapper<ClienteVo>{
		public ClienteVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ClienteVo cliente = new ClienteVo();
			cliente.setIdPessoa(rs.getInt("ID_PESSOA"));
			cliente.setNome(rs.getString("NOME"));
			cliente.setEmail(rs.getString("EMAIL"));
			
			TelefoneVo telefone = new TelefoneVo();
			telefone.setTelefone(rs.getString("TELEFONE"));
			cliente.setTelefone(telefone);
			return cliente;
		}
	}
	public static class ClientePartRowMapper implements RowMapper<ClienteVo>{
		public ClienteVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			ClienteVo cliente = new ClienteVo();
			cliente.setIdPessoa(rs.getInt("ID_PESSOA"));
			cliente.setNome(rs.getString("NOME"));
			return cliente;
		}
	}
	public Integer consultarQuantidadeClientesCadastrados() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_CONSULTAR_QUANTIDADE_CLIENTES);
		try{
			return getJdbc().queryForObject(sql.toString(), new MapSqlParameterSource(), Integer.class);
		}catch(DataAccessException d){
			throw d;
		}
	}
}
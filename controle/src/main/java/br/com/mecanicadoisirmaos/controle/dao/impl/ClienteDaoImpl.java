package br.com.mecanicadoisirmaos.controle.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.mecanicadoisirmaos.controle.dao.AbstractDao;
import br.com.mecanicadoisirmaos.controle.dao.ClienteDao;
import br.com.mecanicadoisirmaos.controle.dao.queries.ClienteQueries;
import br.com.mecanicadoisirmaos.controle.vo.ClienteVo;
import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

@Repository
public class ClienteDaoImpl extends AbstractDao implements ClienteDao, ClienteQueries {

	public List<ClienteVo> listarClientes() throws DataAccessException {
		StringBuilder sql = new StringBuilder(QUERY_LISTAR_CLIENTES);
		
		try{
			return getJdbc().query(sql.toString(), new ClienteRowMapper());
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
}
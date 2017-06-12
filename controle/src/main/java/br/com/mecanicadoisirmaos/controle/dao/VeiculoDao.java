package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.VeiculoVo;

public interface VeiculoDao {

	public Integer inserirVeiculo(VeiculoVo veiculo) throws DataAccessException;
	
	public List<VeiculoVo> listarVeiculos() throws DataAccessException;

	public Integer consultarQuantidadeVeiculosCadastrados() throws DataAccessException;

	public List<VeiculoVo> consultarVeiculoPorProprietario(Integer idPessoa) throws DataAccessException;
}
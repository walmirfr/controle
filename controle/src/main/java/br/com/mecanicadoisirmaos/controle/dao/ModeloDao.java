package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.ModeloVo;

public interface ModeloDao {

	public Integer inserirModelo(ModeloVo modelo) throws DataAccessException;
	
	public List<ModeloVo> listarModelosPorIdMarca(Integer idMarca) throws DataAccessException;
}
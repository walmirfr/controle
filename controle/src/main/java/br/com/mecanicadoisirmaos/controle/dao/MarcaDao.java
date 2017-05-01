package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.MarcaVo;

public interface MarcaDao {

	public Integer inserirMarca(MarcaVo marca) throws DataAccessException;
	
	public List<MarcaVo> listarMarcas() throws DataAccessException;
}
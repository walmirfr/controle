package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.GrupoServicoVo;

public interface GrupoServicoDao {

	public Integer cadastrarGrupoServico(GrupoServicoVo grupoServicoVo) throws DataAccessException;
	
	public Integer alterarGrupoServico(GrupoServicoVo grupoServicoVo) throws DataAccessException;
	
	public List<GrupoServicoVo> listarGrupoServico() throws DataAccessException;
	
	public Integer deletarGrupoServico(Integer idGrupoServico) throws DataAccessException;
}
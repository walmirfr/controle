package br.com.mecanicadoisirmaos.controle.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.mecanicadoisirmaos.controle.vo.ManutencaoVo;
import br.com.mecanicadoisirmaos.controle.vo.ProfissionalVo;
import br.com.mecanicadoisirmaos.controle.vo.ServicoVo;

public interface ManutencaoDao {

	public Integer inserirManutencao(ManutencaoVo manutencao) throws DataAccessException;
	
	public Integer inserirServicoManutencao(ServicoVo servico, Integer idManutencao) throws DataAccessException;
	
	public Integer inserirProfissionalManutencao(ProfissionalVo profissional, Integer idManutencao) throws DataAccessException;
	
	public List<ManutencaoVo> listarManutencoes () throws DataAccessException;

	public Integer consultarQuantidadeManutencoesCadastradas() throws DataAccessException;
}
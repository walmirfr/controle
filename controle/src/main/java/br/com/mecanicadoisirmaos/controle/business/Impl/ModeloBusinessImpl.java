package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mecanicadoisirmaos.controle.business.ModeloBusiness;
import br.com.mecanicadoisirmaos.controle.dao.ModeloDao;
import br.com.mecanicadoisirmaos.controle.vo.ModeloVo;

@Component
public class ModeloBusinessImpl implements ModeloBusiness{

	@Autowired
	private ModeloDao modeloDao;
	
	public Boolean inserirModelo(ModeloVo modelo) throws Exception {
		if(modeloDao.inserirModelo(modelo) > 0){
			return true;
		}
		return false;
	}

	public List<ModeloVo> listarModelosPorMarca(Integer idMarca) throws Exception {
		return modeloDao.listarModelosPorIdMarca(idMarca);
	}

}

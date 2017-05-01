package br.com.mecanicadoisirmaos.controle.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mecanicadoisirmaos.controle.business.MarcaBusiness;
import br.com.mecanicadoisirmaos.controle.dao.MarcaDao;
import br.com.mecanicadoisirmaos.controle.vo.MarcaVo;

@Component
public class MarcaBusinessImpl implements MarcaBusiness{

	@Autowired
	private MarcaDao marcaDao;
	
	public Boolean inserirMarca(MarcaVo marca) throws Exception {
		if(marcaDao.inserirMarca(marca) > 0){
			return true;
		}
		return false;
	}

	public List<MarcaVo> listarMarcas() throws Exception {
		return marcaDao.listarMarcas();
	}

}

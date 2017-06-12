package br.com.mecanicadoisirmaos.controle.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.mecanicadoisirmaos.controle.vo.TelefoneVo;

public class Util {

	public static String getAtivo(Boolean ativo){
		String valor = Constants.NAO;
		if(ativo){
			valor = Constants.SIM;
		}
		return valor;
	}
	
	public static Boolean getAtivo(String ativo){
		Boolean valor = false;
		if("S".equalsIgnoreCase(ativo)){
			valor = true;
		}
		return valor;
	}
	
	public static Boolean getVinculo(Integer vinculo){
		Boolean valor = false;
		if(vinculo > 0){
			valor = true;
		}
		return valor;
	}
	
	public static void limparListaNullListTelefone(List<TelefoneVo>lista){

		List<TelefoneVo> listaAux = new ArrayList<TelefoneVo>();
		for(TelefoneVo telefone: lista){
			if(telefone == null || telefone.getDd() == null){
				listaAux.add(telefone);
			}
		}
		lista.removeAll(listaAux);
	}
	
	public static String formatarData(Date data){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dtFormatada = formato.format(data);
		return dtFormatada;
	}
}
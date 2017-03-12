package br.com.mecanicadoisirmaos.controle.util;

import static br.com.mecanicadoisirmaos.controle.util.Constantes.NAO;
import static br.com.mecanicadoisirmaos.controle.util.Constantes.SIM;

public class Util {

	public static String getAtivo(Boolean ativo){
		String valor = NAO;
		if(ativo){
			valor = SIM;
		}
		return valor;
	}
}
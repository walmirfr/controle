package br.com.mecanicadoisirmaos.controle.util;

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
}
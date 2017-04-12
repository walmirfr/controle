package br.com.mecanicadoisirmaos.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManutencaoController {

	/*LINKS*/
	@RequestMapping("/manutencao/cadastrar")
	public ModelAndView cadastrarManutencao(){
		return getRetorno("manutencao/manutencao-cadastrar");
	}
	
	@RequestMapping("/manutencao/consultar")
	public ModelAndView listarManutencaos(){
		ModelAndView mv = getRetorno("manutencao/manutencao-consultar");
		return mv;
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "manutencao");
		return mv;
	}
}

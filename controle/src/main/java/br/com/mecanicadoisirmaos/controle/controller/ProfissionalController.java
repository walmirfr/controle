package br.com.mecanicadoisirmaos.controle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfissionalController {

	/*LINKS*/
	@RequestMapping("/profissional/cadastrar")
	public ModelAndView cadastrarProfissional(){
		return getRetorno("profissional/profissional-cadastrar");
	}
	
	@RequestMapping("/profissional/consultar")
	public ModelAndView listarProfissionals(){
		ModelAndView mv = getRetorno("profissional/profissional-consultar");
		return mv;
	}
	
	private ModelAndView getRetorno(String pagRetorno){
		ModelAndView mv = new ModelAndView(pagRetorno);
		mv.addObject("pagina", "profissional");
		return mv;
	}
}
